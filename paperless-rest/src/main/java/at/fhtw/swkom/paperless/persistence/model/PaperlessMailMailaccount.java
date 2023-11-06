package at.fhtw.swkom.paperless.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "paperless_mail_mailaccount")
public class PaperlessMailMailaccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @javax.validation.constraints.Size(max = 256)
    @javax.validation.constraints.NotNull
    @Column(name = "name", nullable = false, length = 256)
    private String name;

    @javax.validation.constraints.Size(max = 256)
    @javax.validation.constraints.NotNull
    @Column(name = "imap_server", nullable = false, length = 256)
    private String imapServer;

    @Column(name = "imap_port")
    private Integer imapPort;

    @javax.validation.constraints.NotNull
    @Column(name = "imap_security", nullable = false)
    private Integer imapSecurity;

    @javax.validation.constraints.Size(max = 256)
    @javax.validation.constraints.NotNull
    @Column(name = "username", nullable = false, length = 256)
    private String username;

    @javax.validation.constraints.Size(max = 2048)
    @javax.validation.constraints.NotNull
    @Column(name = "password", nullable = false, length = 2048)
    private String password;

    @javax.validation.constraints.Size(max = 256)
    @javax.validation.constraints.NotNull
    @Column(name = "character_set", nullable = false, length = 256)
    private String characterSet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private AuthUser owner;

    @javax.validation.constraints.NotNull
    @Column(name = "is_token", nullable = false)
    private Boolean isToken = false;

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

    public String getImapServer() {
        return imapServer;
    }

    public void setImapServer(String imapServer) {
        this.imapServer = imapServer;
    }

    public Integer getImapPort() {
        return imapPort;
    }

    public void setImapPort(Integer imapPort) {
        this.imapPort = imapPort;
    }

    public Integer getImapSecurity() {
        return imapSecurity;
    }

    public void setImapSecurity(Integer imapSecurity) {
        this.imapSecurity = imapSecurity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCharacterSet() {
        return characterSet;
    }

    public void setCharacterSet(String characterSet) {
        this.characterSet = characterSet;
    }

    public AuthUser getOwner() {
        return owner;
    }

    public void setOwner(AuthUser owner) {
        this.owner = owner;
    }

    public Boolean getIsToken() {
        return isToken;
    }

    public void setIsToken(Boolean isToken) {
        this.isToken = isToken;
    }

}