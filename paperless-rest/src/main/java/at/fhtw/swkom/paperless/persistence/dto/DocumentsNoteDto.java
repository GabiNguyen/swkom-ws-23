package at.fhtw.swkom.paperless.persistence.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistence.model.DocumentsNote}
 */
public class DocumentsNoteDto implements Serializable {
    private final Integer id;
    @NotNull
    private final String note;
    @NotNull
    private final OffsetDateTime created;
    private final DocumentsDocumentDto document;
    private final AuthUserDto user;

    public DocumentsNoteDto(Integer id, String note, OffsetDateTime created, DocumentsDocumentDto document, AuthUserDto user) {
        this.id = id;
        this.note = note;
        this.created = created;
        this.document = document;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public OffsetDateTime getCreated() {
        return created;
    }

    public DocumentsDocumentDto getDocument() {
        return document;
    }

    public AuthUserDto getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentsNoteDto entity = (DocumentsNoteDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.note, entity.note) &&
                Objects.equals(this.created, entity.created) &&
                Objects.equals(this.document, entity.document) &&
                Objects.equals(this.user, entity.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, note, created, document, user);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "note = " + note + ", " +
                "created = " + created + ", " +
                "document = " + document + ", " +
                "user = " + user + ")";
    }
}