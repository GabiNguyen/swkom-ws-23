package at.fhtw.swkom.paperless.persistence.repository;

import at.fhtw.swkom.paperless.persistence.model.DocumentsNote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentsNoteRepository extends JpaRepository<DocumentsNote, Integer> {
}