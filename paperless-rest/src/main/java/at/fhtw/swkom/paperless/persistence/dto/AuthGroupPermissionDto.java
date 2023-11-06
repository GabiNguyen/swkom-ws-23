package at.fhtw.swkom.paperless.persistence.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistence.model.AuthGroupPermission}
 */
public class AuthGroupPermissionDto implements Serializable {
    private final Integer id;
    @NotNull
    private final AuthGroupDto group;
    @NotNull
    private final AuthPermissionDto permission;

    public AuthGroupPermissionDto(Integer id, AuthGroupDto group, AuthPermissionDto permission) {
        this.id = id;
        this.group = group;
        this.permission = permission;
    }

    public Integer getId() {
        return id;
    }

    public AuthGroupDto getGroup() {
        return group;
    }

    public AuthPermissionDto getPermission() {
        return permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthGroupPermissionDto entity = (AuthGroupPermissionDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.group, entity.group) &&
                Objects.equals(this.permission, entity.permission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, group, permission);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "group = " + group + ", " +
                "permission = " + permission + ")";
    }
}