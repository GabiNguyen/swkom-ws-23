package at.fhtw.swkom.paperless.persistence.repository;

import at.fhtw.swkom.paperless.persistence.model.DocumentsDocumentTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentsDocumentTagRepository extends JpaRepository<DocumentsDocumentTag, Integer> {
}