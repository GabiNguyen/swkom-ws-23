package at.fhtw.swkom.paperless.persistence.repository;

import at.fhtw.swkom.paperless.persistence.model.DocumentsCorrespondent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentsCorrespondentRepository extends JpaRepository<DocumentsCorrespondent, Integer> {
}