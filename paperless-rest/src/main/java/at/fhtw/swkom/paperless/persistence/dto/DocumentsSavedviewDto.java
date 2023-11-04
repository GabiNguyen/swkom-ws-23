package at.fhtw.swkom.paperless.persistence.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistence.model.DocumentsSavedview}
 */
public class DocumentsSavedviewDto implements Serializable {
    private final Integer id;
    @NotNull
    @Size(max = 128)
    private final String name;
    @NotNull
    private final Boolean showOnDashboard;
    @NotNull
    private final Boolean showInSidebar;
    @Size(max = 128)
    private final String sortField;
    @NotNull
    private final Boolean sortReverse;
    private final AuthUserDto owner;

    public DocumentsSavedviewDto(Integer id, String name, Boolean showOnDashboard, Boolean showInSidebar, String sortField, Boolean sortReverse, AuthUserDto owner) {
        this.id = id;
        this.name = name;
        this.showOnDashboard = showOnDashboard;
        this.showInSidebar = showInSidebar;
        this.sortField = sortField;
        this.sortReverse = sortReverse;
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getShowOnDashboard() {
        return showOnDashboard;
    }

    public Boolean getShowInSidebar() {
        return showInSidebar;
    }

    public String getSortField() {
        return sortField;
    }

    public Boolean getSortReverse() {
        return sortReverse;
    }

    public AuthUserDto getOwner() {
        return owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentsSavedviewDto entity = (DocumentsSavedviewDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.showOnDashboard, entity.showOnDashboard) &&
                Objects.equals(this.showInSidebar, entity.showInSidebar) &&
                Objects.equals(this.sortField, entity.sortField) &&
                Objects.equals(this.sortReverse, entity.sortReverse) &&
                Objects.equals(this.owner, entity.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, showOnDashboard, showInSidebar, sortField, sortReverse, owner);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "showOnDashboard = " + showOnDashboard + ", " +
                "showInSidebar = " + showInSidebar + ", " +
                "sortField = " + sortField + ", " +
                "sortReverse = " + sortReverse + ", " +
                "owner = " + owner + ")";
    }
}