package at.fhtw.swkom.paperless.persistence.repository;

import at.fhtw.swkom.paperless.persistence.model.AuthtokenToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthtokenTokenRepository extends JpaRepository<AuthtokenToken, String> {
}