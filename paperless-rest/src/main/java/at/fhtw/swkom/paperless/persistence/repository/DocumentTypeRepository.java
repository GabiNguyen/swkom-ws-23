package at.fhtw.swkom.paperless.persistence.repository;

import at.fhtw.swkom.paperless.persistence.entity.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, Integer> {
}