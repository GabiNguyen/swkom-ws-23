package at.fhtw.swkom.paperless.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "documents_uisettings")
public class DocumentsUisetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @javax.validation.constraints.NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private AuthUser user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AuthUser getUser() {
        return user;
    }

    public void setUser(AuthUser user) {
        this.user = user;
    }

/*
    TODO [JPA Buddy] create field to map the 'settings' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "settings", columnDefinition = "jsonb(0, 0)")
    private Object settings;
*/
}