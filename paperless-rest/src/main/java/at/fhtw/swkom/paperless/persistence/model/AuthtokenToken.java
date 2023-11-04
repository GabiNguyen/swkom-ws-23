package at.fhtw.swkom.paperless.persistence.model;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "authtoken_token")
public class AuthtokenToken {
    @Id
    @javax.validation.constraints.Size(max = 40)
    @Column(name = "key", nullable = false, length = 40)
    private String key;

    @javax.validation.constraints.NotNull
    @Column(name = "created", nullable = false)
    private OffsetDateTime created;

    @javax.validation.constraints.NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private AuthUser user;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public OffsetDateTime getCreated() {
        return created;
    }

    public void setCreated(OffsetDateTime created) {
        this.created = created;
    }

    public AuthUser getUser() {
        return user;
    }

    public void setUser(AuthUser user) {
        this.user = user;
    }

}