package at.fhtw.swkom.paperless.persistence.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistence.model.PaperlessMailMailruleAssignTag}
 */
public class PaperlessMailMailruleAssignTagDto implements Serializable {
    private final Integer id;
    @NotNull
    private final PaperlessMailMailruleDto mailrule;
    @NotNull
    private final DocumentsTagDto tag;

    public PaperlessMailMailruleAssignTagDto(Integer id, PaperlessMailMailruleDto mailrule, DocumentsTagDto tag) {
        this.id = id;
        this.mailrule = mailrule;
        this.tag = tag;
    }

    public Integer getId() {
        return id;
    }

    public PaperlessMailMailruleDto getMailrule() {
        return mailrule;
    }

    public DocumentsTagDto getTag() {
        return tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaperlessMailMailruleAssignTagDto entity = (PaperlessMailMailruleAssignTagDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.mailrule, entity.mailrule) &&
                Objects.equals(this.tag, entity.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mailrule, tag);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "mailrule = " + mailrule + ", " +
                "tag = " + tag + ")";
    }
}