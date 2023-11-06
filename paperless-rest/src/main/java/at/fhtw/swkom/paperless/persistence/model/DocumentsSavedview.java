package at.fhtw.swkom.paperless.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "documents_savedview")
public class DocumentsSavedview {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @javax.validation.constraints.Size(max = 128)
    @javax.validation.constraints.NotNull
    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @javax.validation.constraints.NotNull
    @Column(name = "show_on_dashboard", nullable = false)
    private Boolean showOnDashboard = false;

    @javax.validation.constraints.NotNull
    @Column(name = "show_in_sidebar", nullable = false)
    private Boolean showInSidebar = false;

    @javax.validation.constraints.Size(max = 128)
    @Column(name = "sort_field", length = 128)
    private String sortField;

    @javax.validation.constraints.NotNull
    @Column(name = "sort_reverse", nullable = false)
    private Boolean sortReverse = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private AuthUser owner;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getShowOnDashboard() {
        return showOnDashboard;
    }

    public void setShowOnDashboard(Boolean showOnDashboard) {
        this.showOnDashboard = showOnDashboard;
    }

    public Boolean getShowInSidebar() {
        return showInSidebar;
    }

    public void setShowInSidebar(Boolean showInSidebar) {
        this.showInSidebar = showInSidebar;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public Boolean getSortReverse() {
        return sortReverse;
    }

    public void setSortReverse(Boolean sortReverse) {
        this.sortReverse = sortReverse;
    }

    public AuthUser getOwner() {
        return owner;
    }

    public void setOwner(AuthUser owner) {
        this.owner = owner;
    }

}