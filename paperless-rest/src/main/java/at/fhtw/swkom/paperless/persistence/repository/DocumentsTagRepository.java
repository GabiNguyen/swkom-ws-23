package at.fhtw.swkom.paperless.persistence.repository;

import at.fhtw.swkom.paperless.persistence.model.DocumentsTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentsTagRepository extends JpaRepository<DocumentsTag, Integer> {
}