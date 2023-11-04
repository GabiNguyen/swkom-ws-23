package at.fhtw.swkom.paperless.persistence.repository;

import at.fhtw.swkom.paperless.persistence.model.PaperlessMailMailrule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaperlessMailMailruleRepository extends JpaRepository<PaperlessMailMailrule, Integer> {
}