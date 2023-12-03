package at.fhtw.swkom.paperless.services;

import at.fhtw.swkom.paperless.persistence.entity.Document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import at.fhtw.swkom.paperless.persistence.repository.DocumentRepository;

import java.io.InputStream;
import java.util.List;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.MinioException;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final RabbitMQService rabbitMQService;
    private MinioClient minioClient;

    public DocumentService(DocumentRepository documentRepository, RabbitMQService rabbitMQService,
            MinioClient minioClient) {
        this.documentRepository = documentRepository;
        this.rabbitMQService = rabbitMQService;
        this.minioClient = minioClient;
    }

    public List<Document> getAllDocuments() {
        rabbitMQService.sendMessage("message");
        return documentRepository.findAll();
    }

    public Document postDocument(MultipartFile document) {
        // Saving the document to the database
        Document doc = new Document(document.getOriginalFilename(), document.getContentType());
        Document savedDocument = documentRepository.save(doc);

        // Upload the document to Minio
        try {
            String bucketName = "documents"; // Replace with your bucket name
            String objectName = "documents/" + savedDocument.getId() + "-" + savedDocument.getTitle(); // Object name in
                                                                                                       // Minio

            // Get the document's input stream (assuming you have a method to get it)
            InputStream inputStream = document.getInputStream();

            // Upload the document to Minio
            minioClient.putObject(
                    PutObjectArgs.builder().bucket(bucketName).object(objectName).stream(
                            inputStream, -1, 10485760)
                            .contentType(doc.getMimeType())
                            .build());

            // Send a message about the document being saved and uploaded
            rabbitMQService.sendMessage("Saved document with id " + savedDocument.getId() + " and uploaded to Minio");
        } catch (Exception e) {
            // Handle Minio or other exceptions
            e.printStackTrace();
        }
        return savedDocument;
    }

}
