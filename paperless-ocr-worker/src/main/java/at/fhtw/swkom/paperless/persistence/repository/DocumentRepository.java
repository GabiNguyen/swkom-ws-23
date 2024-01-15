package at.fhtw.swkom.paperless.persistence.repository;

import at.fhtw.swkom.paperless.persistence.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {
}