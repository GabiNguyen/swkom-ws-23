package at.fhtw.swkom.paperless.persistence.repository;

import org.springframework.stereotype.Repository;
import at.fhtw.swkom.paperless.persistence.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {
}