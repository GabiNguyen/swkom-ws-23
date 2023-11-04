package at.fhtw.swkom.paperless.persistence.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistence.model.AuthtokenToken}
 */
public class AuthtokenTokenDto implements Serializable {
    @Size(max = 40)
    private final String key;
    @NotNull
    private final OffsetDateTime created;
    @NotNull
    private final AuthUserDto user;

    public AuthtokenTokenDto(String key, OffsetDateTime created, AuthUserDto user) {
        this.key = key;
        this.created = created;
        this.user = user;
    }

    public String getKey() {
        return key;
    }

    public OffsetDateTime getCreated() {
        return created;
    }

    public AuthUserDto getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthtokenTokenDto entity = (AuthtokenTokenDto) o;
        return Objects.equals(this.key, entity.key) &&
                Objects.equals(this.created, entity.created) &&
                Objects.equals(this.user, entity.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, created, user);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "key = " + key + ", " +
                "created = " + created + ", " +
                "user = " + user + ")";
    }
}