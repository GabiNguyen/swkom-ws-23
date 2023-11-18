package at.fhtw.swkom.paperless.services;

import at.fhtw.swkom.paperless.persistence.entity.Document;
import org.springframework.stereotype.Service;

import at.fhtw.swkom.paperless.persistence.repository.DocumentRepository;
import java.util.List;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final RabbitMQService rabbitMQService;

    public DocumentService(DocumentRepository documentRepository, RabbitMQService rabbitMQService) {
        this.documentRepository = documentRepository;
        this.rabbitMQService = rabbitMQService;
    }

    public List<Document> getAllDocuments() {
        rabbitMQService.sendMessage("message");
        return documentRepository.findAll();
    }

    public Document postDocument(Document document) {
        return documentRepository.save(document);
    }

}
