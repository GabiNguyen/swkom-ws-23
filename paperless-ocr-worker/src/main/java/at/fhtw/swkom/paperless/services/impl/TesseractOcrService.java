package at.fhtw.swkom.paperless.services.impl;

import at.fhtw.swkom.paperless.config.RabbitMQConfig;
import at.fhtw.swkom.paperless.persistence.repository.DocumentRepository;
import at.fhtw.swkom.paperless.services.OcrService;
import at.fhtw.swkom.paperless.persistence.entity.Document;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.errors.MinioException;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.tika.detect.Detector;
import org.apache.tika.detect.TypeDetector;
import org.apache.tika.io.TikaInputStream;
import org.openapitools.jackson.nullable.JsonNullable;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.OffsetDateTime;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@Component
@Slf4j
public class TesseractOcrService implements OcrService {

    private final RabbitTemplate rabbit;
    private final String tesseractData;
    private final MinioClient minioClient;
    private final DocumentRepository documentRepository;

    @Autowired
    public TesseractOcrService(RabbitTemplate rabbit, @Value("${tesseract.data}") String tessData, MinioClient minioClient, DocumentRepository documentRepository) {
        this.rabbit = rabbit;
        this.tesseractData = tessData;
        this.minioClient = minioClient;
        this.documentRepository = documentRepository;
    }

    @Override
    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void processMessage(String message) {
        log.info("Received Message: " + message);

        try {
            // Extract document ID from the message
            int documentId = parseInt(message);

            // Fetch document title from the database
            Optional<Document> optionalDocument = documentRepository.findById(documentId);

            if (optionalDocument.isPresent()) {
                Document document = optionalDocument.get();
                log.info("Received Document: " + document.getTitle());

                // Fetch document file from Minio using title
                InputStream is = minioClient.getObject(GetObjectArgs.builder()
                        .bucket("documents")
                        .object("documents/" + documentId + "-" + document.getTitle())
                        .build());

                // Do OCR recognition
                File tempFile = createTempFile(document.getTitle(), is);
                String result = doOCR(tempFile);
                log.info(result);

                // Update content of the document
//                document.setContent(String.valueOf(JsonNullable.of(result)));
                document.setContent(result);
                document.setModified(OffsetDateTime.now());

                // Save the updated document in the database
                documentRepository.save(document);
            } else {
                log.error("Document not found for ID: " + documentId);
            }
        } catch (TesseractException | IOException | MinioException | NoSuchAlgorithmException | InvalidKeyException e) {
            log.error("Error processing the message: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }


    public String doOCR(File tempFile) throws TesseractException {
        var tesseract = new Tesseract();
        tesseract.setDatapath(tesseractData);
        tesseract.setLanguage("eng");
        String result = tesseract.doOCR(tempFile);
        System.out.println("OCR Result: " + result);
        return result;
    }

    private static File createTempFile(String title, InputStream is) throws IOException {
        // Extract the file extension from the title
        String fileExtension = extractFileExtension(title);

        File tempFile = File.createTempFile(title, "." + fileExtension);
        tempFile.deleteOnExit();

        try (FileOutputStream out = new FileOutputStream(tempFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
        return tempFile;
    }

    private static String extractFileExtension(String title) {
        Path path = Paths.get(title);
        String fileName = path.getFileName().toString();
        int dotIndex = fileName.lastIndexOf(".");
        return dotIndex != -1 ? fileName.substring(dotIndex + 1) : ""; // Extract file extension
    }


}
