package at.fhtw.swkom.paperless.persistence.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistence.model.DocumentsStoragepath}
 */
public class DocumentsStoragepathDto implements Serializable {
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
    @Size(max = 512)
    private final String path;
    private final AuthUserDto owner;

    public DocumentsStoragepathDto(Integer id, String name, String match, Integer matchingAlgorithm, Boolean isInsensitive, String path, AuthUserDto owner) {
        this.id = id;
        this.name = name;
        this.match = match;
        this.matchingAlgorithm = matchingAlgorithm;
        this.isInsensitive = isInsensitive;
        this.path = path;
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

    public String getPath() {
        return path;
    }

    public AuthUserDto getOwner() {
        return owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentsStoragepathDto entity = (DocumentsStoragepathDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.match, entity.match) &&
                Objects.equals(this.matchingAlgorithm, entity.matchingAlgorithm) &&
                Objects.equals(this.isInsensitive, entity.isInsensitive) &&
                Objects.equals(this.path, entity.path) &&
                Objects.equals(this.owner, entity.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, match, matchingAlgorithm, isInsensitive, path, owner);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "match = " + match + ", " +
                "matchingAlgorithm = " + matchingAlgorithm + ", " +
                "isInsensitive = " + isInsensitive + ", " +
                "path = " + path + ", " +
                "owner = " + owner + ")";
    }
}