package at.fhtw.swkom.paperless.persistence.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistence.model.DocumentsTag}
 */
public class DocumentsTagDto implements Serializable {
    private final Integer id;
    @NotNull
    @Size(max = 128)
    private final String name;
    @NotNull
    @Size(max = 256)
    private final String match;
    @NotNull
    private final Integer matchingAlgorithm;
    @NotNull
    private final Boolean isInsensitive;
    @NotNull
    private final Boolean isInboxTag;
    @NotNull
    @Size(max = 7)
    private final String color;
    private final AuthUserDto owner;

    public DocumentsTagDto(Integer id, String name, String match, Integer matchingAlgorithm, Boolean isInsensitive, Boolean isInboxTag, String color, AuthUserDto owner) {
        this.id = id;
        this.name = name;
        this.match = match;
        this.matchingAlgorithm = matchingAlgorithm;
        this.isInsensitive = isInsensitive;
        this.isInboxTag = isInboxTag;
        this.color = color;
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMatch() {
        return match;
    }

    public Integer getMatchingAlgorithm() {
        return matchingAlgorithm;
    }

    public Boolean getIsInsensitive() {
        return isInsensitive;
    }

    public Boolean getIsInboxTag() {
        return isInboxTag;
    }

    public String getColor() {
        return color;
    }

    public AuthUserDto getOwner() {
        return owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentsTagDto entity = (DocumentsTagDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.match, entity.match) &&
                Objects.equals(this.matchingAlgorithm, entity.matchingAlgorithm) &&
                Objects.equals(this.isInsensitive, entity.isInsensitive) &&
                Objects.equals(this.isInboxTag, entity.isInboxTag) &&
                Objects.equals(this.color, entity.color) &&
                Objects.equals(this.owner, entity.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, match, matchingAlgorithm, isInsensitive, isInboxTag, color, owner);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "match = " + match + ", " +
                "matchingAlgorithm = " + matchingAlgorithm + ", " +
                "isInsensitive = " + isInsensitive + ", " +
                "isInboxTag = " + isInboxTag + ", " +
                "color = " + color + ", " +
                "owner = " + owner + ")";
    }
}