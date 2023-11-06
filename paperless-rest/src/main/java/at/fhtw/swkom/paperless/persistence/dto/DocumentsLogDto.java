package at.fhtw.swkom.paperless.persistence.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistence.model.DocumentsLog}
 */
public class DocumentsLogDto implements Serializable {
    private final Integer id;
    private final UUID group;
    @NotNull
    private final String message;
    @NotNull
    private final Integer level;
    @NotNull
    private final OffsetDateTime created;

    public DocumentsLogDto(Integer id, UUID group, String message, Integer level, OffsetDateTime created) {
        this.id = id;
        this.group = group;
        this.message = message;
        this.level = level;
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public UUID getGroup() {
        return group;
    }

    public String getMessage() {
        return message;
    }

    public Integer getLevel() {
        return level;
    }

    public OffsetDateTime getCreated() {
        return created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentsLogDto entity = (DocumentsLogDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.group, entity.group) &&
                Objects.equals(this.message, entity.message) &&
                Objects.equals(this.level, entity.level) &&
                Objects.equals(this.created, entity.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, group, message, level, created);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "group = " + group + ", " +
                "message = " + message + ", " +
                "level = " + level + ", " +
                "created = " + created + ")";
    }
}