package at.fhtw.swkom.paperless.persistence.repository;

import at.fhtw.swkom.paperless.persistence.entity.DocumentTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentTagRepository extends JpaRepository<DocumentTag, Integer> {
}