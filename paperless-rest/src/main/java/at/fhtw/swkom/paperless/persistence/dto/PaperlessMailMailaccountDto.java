package at.fhtw.swkom.paperless.persistence.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistence.model.PaperlessMailMailaccount}
 */
public class PaperlessMailMailaccountDto implements Serializable {
    private final Integer id;
    @NotNull
    @Size(max = 256)
    private final String name;
    @NotNull
    @Size(max = 256)
    private final String imapServer;
    private final Integer imapPort;
    @NotNull
    private final Integer imapSecurity;
    @NotNull
    @Size(max = 256)
    private final String username;
    @NotNull
    @Size(max = 2048)
    private final String password;
    @NotNull
    @Size(max = 256)
    private final String characterSet;
    private final AuthUserDto owner;
    @NotNull
    private final Boolean isToken;

    public PaperlessMailMailaccountDto(Integer id, String name, String imapServer, Integer imapPort, Integer imapSecurity, String username, String password, String characterSet, AuthUserDto owner, Boolean isToken) {
        this.id = id;
        this.name = name;
        this.imapServer = imapServer;
        this.imapPort = imapPort;
        this.imapSecurity = imapSecurity;
        this.username = username;
        this.password = password;
        this.characterSet = characterSet;
        this.owner = owner;
        this.isToken = isToken;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImapServer() {
        return imapServer;
    }

    public Integer getImapPort() {
        return imapPort;
    }

    public Integer getImapSecurity() {
        return imapSecurity;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCharacterSet() {
        return characterSet;
    }

    public AuthUserDto getOwner() {
        return owner;
    }

    public Boolean getIsToken() {
        return isToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaperlessMailMailaccountDto entity = (PaperlessMailMailaccountDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.imapServer, entity.imapServer) &&
                Objects.equals(this.imapPort, entity.imapPort) &&
                Objects.equals(this.imapSecurity, entity.imapSecurity) &&
                Objects.equals(this.username, entity.username) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.characterSet, entity.characterSet) &&
                Objects.equals(this.owner, entity.owner) &&
                Objects.equals(this.isToken, entity.isToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, imapServer, imapPort, imapSecurity, username, password, characterSet, owner, isToken);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "imapServer = " + imapServer + ", " +
                "imapPort = " + imapPort + ", " +
                "imapSecurity = " + imapSecurity + ", " +
                "username = " + username + ", " +
                "password = " + password + ", " +
                "characterSet = " + characterSet + ", " +
                "owner = " + owner + ", " +
                "isToken = " + isToken + ")";
    }
}