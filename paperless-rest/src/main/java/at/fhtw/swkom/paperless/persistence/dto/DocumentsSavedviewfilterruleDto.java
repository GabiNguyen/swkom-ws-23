package at.fhtw.swkom.paperless.persistence.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistence.model.DocumentsSavedviewfilterrule}
 */
public class DocumentsSavedviewfilterruleDto implements Serializable {
    private final Integer id;
    @NotNull
    private final Integer ruleType;
    @Size(max = 255)
    private final String value;
    @NotNull
    private final DocumentsSavedviewDto savedView;

    public DocumentsSavedviewfilterruleDto(Integer id, Integer ruleType, String value, DocumentsSavedviewDto savedView) {
        this.id = id;
        this.ruleType = ruleType;
        this.value = value;
        this.savedView = savedView;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRuleType() {
        return ruleType;
    }

    public String getValue() {
        return value;
    }

    public DocumentsSavedviewDto getSavedView() {
        return savedView;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentsSavedviewfilterruleDto entity = (DocumentsSavedviewfilterruleDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.ruleType, entity.ruleType) &&
                Objects.equals(this.value, entity.value) &&
                Objects.equals(this.savedView, entity.savedView);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ruleType, value, savedView);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "ruleType = " + ruleType + ", " +
                "value = " + value + ", " +
                "savedView = " + savedView + ")";
    }
}