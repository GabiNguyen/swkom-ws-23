package at.fhtw.swkom.paperless.persistence.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistence.model.AuthUserUserPermission}
 */
public class AuthUserUserPermissionDto implements Serializable {
    private final Integer id;
    @NotNull
    private final AuthUserDto user;
    @NotNull
    private final AuthPermissionDto permission;

    public AuthUserUserPermissionDto(Integer id, AuthUserDto user, AuthPermissionDto permission) {
        this.id = id;
        this.user = user;
        this.permission = permission;
    }

    public Integer getId() {
        return id;
    }

    public AuthUserDto getUser() {
        return user;
    }

    public AuthPermissionDto getPermission() {
        return permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthUserUserPermissionDto entity = (AuthUserUserPermissionDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.user, entity.user) &&
                Objects.equals(this.permission, entity.permission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, permission);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "user = " + user + ", " +
                "permission = " + permission + ")";
    }
}