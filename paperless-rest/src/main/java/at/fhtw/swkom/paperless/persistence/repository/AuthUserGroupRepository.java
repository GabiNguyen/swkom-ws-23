package at.fhtw.swkom.paperless.persistence.repository;

import at.fhtw.swkom.paperless.persistence.model.AuthUserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserGroupRepository extends JpaRepository<AuthUserGroup, Integer> {
}