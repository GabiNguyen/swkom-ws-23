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
import org.openapitools.jackson.nullable.JsonNullable;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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

//    @Override
//    @RabbitListener(queues = "${rabbitmq.queue.name}")
//    public void processMessage(String message) throws JsonProcessingException {
//        log.info("Received Message: " + message);
//
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.registerModule(new JavaTimeModule());
//        mapper.registerModule(new JsonNullableModule());
//
//        // fetch document data
//        Document document = mapper.readValue(message, Document.class);
//        log.debug("Received Document: " + document);
//
//        // fetch document file from Minio
//        try {
//            InputStream is = minioClient.getObject(GetObjectArgs.builder()
//                    .bucket("documents")
//                    .object(document.getId() + "-" + document.getTitle())
//                    .build());
//
//            // do OCR recognition
//            File tempFile = createTempFile(document.getTitle(), is);
//            String result = doOCR(tempFile);
//            log.info(result);
//
//            document.setContent(String.valueOf(JsonNullable.of(result)));
//            document.setModified(OffsetDateTime.now());
//
//            String updatedDocumentString = mapper.writeValueAsString(document);
//            rabbit.convertAndSend("${rabbitmq.exchange.name}", "${rabbitmq.routing.key.name}", updatedDocumentString);
//        } catch (TesseractException | IOException | MinioException e) {
//            log.error(e.getMessage());
//        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
//            throw new RuntimeException(e);
//        }
//    }

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
                log.debug("Received Document: " + document);

                // Fetch document file from Minio using title
                InputStream is = minioClient.getObject(GetObjectArgs.builder()
                        .bucket("documents")
                        .object(document.getId() + "-" + document.getTitle())
                        .build());

                // Do OCR recognition
                File tempFile = createTempFile(document.getTitle(), is);
                String result = doOCR(tempFile);
                log.info(result);

                // Update content of the document
                document.setContent(String.valueOf(JsonNullable.of(result)));
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

//    private long extractDocumentId(String message) {
//        // Assuming that the message format is "Saved document with id {documentId} and uploaded to Minio"
//        String[] parts = message.split(" ");
//        return Long.parseLong(parts[5]);
//    }

    public String doOCR(File tempFile) throws TesseractException {
        var tesseract = new Tesseract();
        tesseract.setDatapath(tesseractData);
        tesseract.setLanguage("eng");
        return tesseract.doOCR(tempFile);
    }

    private static File createTempFile(String title, InputStream is) throws IOException {
        File tempFile = File.createTempFile(title, ".png");
        tempFile.deleteOnExit();
        try (FileOutputStream out = new FileOutputStream(tempFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);  //copy it to file system
            }
        }
        return tempFile;
    }
}
