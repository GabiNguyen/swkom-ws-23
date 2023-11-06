package at.fhtw.swkom.paperless.persistence.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistence.model.DocumentsDocumentTag}
 */
public class DocumentsDocumentTagDto implements Serializable {
    private final Integer id;
    @NotNull
    private final DocumentsDocumentDto document;
    @NotNull
    private final DocumentsTagDto tag;

    public DocumentsDocumentTagDto(Integer id, DocumentsDocumentDto document, DocumentsTagDto tag) {
        this.id = id;
        this.document = document;
        this.tag = tag;
    }

    public Integer getId() {
        return id;
    }

    public DocumentsDocumentDto getDocument() {
        return document;
    }

    public DocumentsTagDto getTag() {
        return tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentsDocumentTagDto entity = (DocumentsDocumentTagDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.document, entity.document) &&
                Objects.equals(this.tag, entity.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, document, tag);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "document = " + document + ", " +
                "tag = " + tag + ")";
    }
}