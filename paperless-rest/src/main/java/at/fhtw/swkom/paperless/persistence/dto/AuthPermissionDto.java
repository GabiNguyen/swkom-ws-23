package at.fhtw.swkom.paperless.persistence.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistence.model.AuthPermission}
 */
public class AuthPermissionDto implements Serializable {
    private final Integer id;
    @NotNull
    @Size(max = 255)
    private final String name;
    @NotNull
    @Size(max = 100)
    private final String contentType;
    @NotNull
    @Size(max = 100)
    private final String codename;

    public AuthPermissionDto(Integer id, String name, String contentType, String codename) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
        this.codename = codename;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContentType() {
        return contentType;
    }

    public String getCodename() {
        return codename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthPermissionDto entity = (AuthPermissionDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.contentType, entity.contentType) &&
                Objects.equals(this.codename, entity.codename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, contentType, codename);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "contentType = " + contentType + ", " +
                "codename = " + codename + ")";
    }
}