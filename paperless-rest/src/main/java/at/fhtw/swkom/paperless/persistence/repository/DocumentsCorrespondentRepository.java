package at.fhtw.swkom.paperless.persistence.repository;

import at.fhtw.swkom.paperless.persistence.entity.DocumentCorrespondent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentsCorrespondentRepository extends JpaRepository<DocumentCorrespondent, Integer> {
}