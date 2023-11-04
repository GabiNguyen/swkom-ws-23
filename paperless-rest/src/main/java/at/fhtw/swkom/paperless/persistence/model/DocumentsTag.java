package at.fhtw.swkom.paperless.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "documents_tag")
public class DocumentsTag {
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

    @javax.validation.constraints.NotNull
    @Column(name = "is_inbox_tag", nullable = false)
    private Boolean isInboxTag = false;

    @javax.validation.constraints.Size(max = 7)
    @javax.validation.constraints.NotNull
    @Column(name = "color", nullable = false, length = 7)
    private String color;

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

    public Boolean getIsInboxTag() {
        return isInboxTag;
    }

    public void setIsInboxTag(Boolean isInboxTag) {
        this.isInboxTag = isInboxTag;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public AuthUser getOwner() {
        return owner;
    }

    public void setOwner(AuthUser owner) {
        this.owner = owner;
    }

}