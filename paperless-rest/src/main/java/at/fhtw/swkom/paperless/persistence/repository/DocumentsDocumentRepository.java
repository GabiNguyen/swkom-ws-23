package at.fhtw.swkom.paperless.persistence.repository;

import at.fhtw.swkom.paperless.persistence.model.DocumentsDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentsDocumentRepository extends JpaRepository<DocumentsDocument, Integer> {
}