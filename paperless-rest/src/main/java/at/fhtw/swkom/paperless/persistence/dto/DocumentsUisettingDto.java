package at.fhtw.swkom.paperless.persistence.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistence.model.DocumentsUisetting}
 */
public class DocumentsUisettingDto implements Serializable {
    private final Integer id;
    @NotNull
    private final AuthUserDto user;

    public DocumentsUisettingDto(Integer id, AuthUserDto user) {
        this.id = id;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public AuthUserDto getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentsUisettingDto entity = (DocumentsUisettingDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.user, entity.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "user = " + user + ")";
    }
}