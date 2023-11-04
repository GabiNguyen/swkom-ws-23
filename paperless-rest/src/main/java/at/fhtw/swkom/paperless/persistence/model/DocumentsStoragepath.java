package at.fhtw.swkom.paperless.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "documents_storagepath")
public class DocumentsStoragepath {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @javax.validation.constraints.Size(max = 128)
    @javax.validation.constraints.NotNull
    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @javax.validation.constraints.Size(max = 256)
    @javax.validation.constraints.NotNull
    @Column(name = "match", nullable = false, length = 256)
    private String match;

    @javax.validation.constraints.NotNull
    @Column(name = "matching_algorithm", nullable = false)
    private Integer matchingAlgorithm;

    @javax.validation.constraints.NotNull
    @Column(name = "is_insensitive", nullable = false)
    private Boolean isInsensitive = false;

    @javax.validation.constraints.Size(max = 512)
    @javax.validation.constraints.NotNull
    @Column(name = "path", nullable = false, length = 512)
    private String path;

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

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public Integer getMatchingAlgorithm() {
        return matchingAlgorithm;
    }

    public void setMatchingAlgorithm(Integer matchingAlgorithm) {
        this.matchingAlgorithm = matchingAlgorithm;
    }

    public Boolean getIsInsensitive() {
        return isInsensitive;
    }

    public void setIsInsensitive(Boolean isInsensitive) {
        this.isInsensitive = isInsensitive;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public AuthUser getOwner() {
        return owner;
    }

    public void setOwner(AuthUser owner) {
        this.owner = owner;
    }

}