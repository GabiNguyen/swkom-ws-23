package at.fhtw.swkom.paperless.persistence.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistence.model.AuthUserGroup}
 */
public class AuthUserGroupDto implements Serializable {
    private final Integer id;
    @NotNull
    private final AuthUserDto user;
    @NotNull
    private final AuthGroupDto group;

    public AuthUserGroupDto(Integer id, AuthUserDto user, AuthGroupDto group) {
        this.id = id;
        this.user = user;
        this.group = group;
    }

    public Integer getId() {
        return id;
    }

    public AuthUserDto getUser() {
        return user;
    }

    public AuthGroupDto getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthUserGroupDto entity = (AuthUserGroupDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.user, entity.user) &&
                Objects.equals(this.group, entity.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, group);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "user = " + user + ", " +
                "group = " + group + ")";
    }
}