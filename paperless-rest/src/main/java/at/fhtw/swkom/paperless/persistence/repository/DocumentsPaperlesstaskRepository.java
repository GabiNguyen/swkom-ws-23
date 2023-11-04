package at.fhtw.swkom.paperless.persistence.repository;

import at.fhtw.swkom.paperless.persistence.model.DocumentsPaperlesstask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentsPaperlesstaskRepository extends JpaRepository<DocumentsPaperlesstask, Integer> {
}