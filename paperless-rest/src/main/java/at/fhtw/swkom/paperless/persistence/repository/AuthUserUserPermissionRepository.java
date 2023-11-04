package at.fhtw.swkom.paperless.persistence.repository;

import at.fhtw.swkom.paperless.persistence.model.AuthUserUserPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserUserPermissionRepository extends JpaRepository<AuthUserUserPermission, Integer> {
}