package at.fhtw.swkom.paperless.persistence.repository;

import at.fhtw.swkom.paperless.persistence.model.DocumentsSavedview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentsSavedviewRepository extends JpaRepository<DocumentsSavedview, Integer> {
}