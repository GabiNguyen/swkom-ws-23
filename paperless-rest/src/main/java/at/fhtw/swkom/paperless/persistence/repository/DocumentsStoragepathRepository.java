package at.fhtw.swkom.paperless.persistence.repository;

import at.fhtw.swkom.paperless.persistence.model.DocumentsStoragepath;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentsStoragepathRepository extends JpaRepository<DocumentsStoragepath, Integer> {
}