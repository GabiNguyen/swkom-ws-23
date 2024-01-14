//package at.fhtw.swkom.paperless.services;
//
//import at.fhtw.swkom.paperless.persistence.entity.Document;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import at.fhtw.swkom.paperless.persistence.repository.DocumentRepository;
//
//import java.io.InputStream;
//import java.util.List;
//
//import io.minio.BucketExistsArgs;
//import io.minio.MakeBucketArgs;
//import io.minio.MinioClient;
//import io.minio.PutObjectArgs;
//import io.minio.errors.MinioException;
//
//@Service
//public class DocumentService {
//
//    private final DocumentRepository documentRepository;
//    private final RabbitMQService rabbitMQService;
//    private MinioClient minioClient;
//
//    public DocumentService(DocumentRepository documentRepository, RabbitMQService rabbitMQService,
//                           MinioClient minioClient) {
//        this.documentRepository = documentRepository;
//        this.rabbitMQService = rabbitMQService;
//        this.minioClient = minioClient;
//    }
//
//    public List<Document> getAllDocuments() {
////        rabbitMQService.sendMessage("message");
//        return documentRepository.findAll();
//    }
//
//    public Document postDocument(MultipartFile document) {
//        // Saving the document to the database
//        Document doc = new Document(document.getOriginalFilename(), document.getContentType());
//        Document savedDocument = documentRepository.save(doc);
//
//        // Upload the document to Minio
//        try {
//            String bucketName = "documents";
//            String objectName = "documents/" + savedDocument.getId() + "-" + savedDocument.getTitle(); // Object name in
//            // Minio
//
//            // Get the document's input stream
//            InputStream inputStream = document.getInputStream();
//
//            //check if bucket exists, if not create it
//            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
//            if (!found) {
//                minioClient.makeBucket(
//                        MakeBucketArgs.builder()
//                                .bucket(bucketName)
//                                .build());
//            }
//
//            // Upload the document to Minio
//            minioClient.putObject(
//                    PutObjectArgs.builder().bucket(bucketName).object(objectName).stream(
//                                    inputStream, -1, 10485760)
//                            .contentType(doc.getMimeType())
//                            .build());
//
//            // Send a message about the document being saved and uploaded
////            rabbitMQService.sendMessage("Saved document with id " + savedDocument.getId() + " and uploaded to Minio");
//            rabbitMQService.sendMessage(savedDocument.getId());
//        } catch (Exception e) {
//            // Handle Minio or other exceptions
//            e.printStackTrace();
//        }
//        return savedDocument;
//    }
//
//}

package at.fhtw.swkom.paperless.services;

import at.fhtw.swkom.paperless.persistence.entity.Document;
import at.fhtw.swkom.paperless.persistence.repository.DocumentRepository;
import io.minio.errors.MinioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final RabbitMQService rabbitMQService;
    private final MinioService minioService;

    @Autowired
    public DocumentService(DocumentRepository documentRepository, RabbitMQService rabbitMQService,
                           MinioService minioService) {
        this.documentRepository = documentRepository;
        this.rabbitMQService = rabbitMQService;
        this.minioService = minioService;
    }

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public Document postDocument(MultipartFile document) {
        // Saving the document to the database
        Document doc = new Document(document.getOriginalFilename(), document.getContentType());
        Document savedDocument = documentRepository.save(doc);

        // Upload the document to Minio
        try {
            String bucketName = "documents";
            String objectName = "documents/" + savedDocument.getId() + "-" + savedDocument.getTitle();

            // Get the document's input stream
            InputStream inputStream = document.getInputStream();

            // Upload the document to Minio using MinioService
            minioService.uploadFile(bucketName, objectName, inputStream);

            // Send a message about the document being saved and uploaded
            rabbitMQService.sendMessage(savedDocument.getId());
        } catch (Exception e) {
            // Handle Minio or other exceptions
            e.printStackTrace();
        }
        return savedDocument;
    }
}
