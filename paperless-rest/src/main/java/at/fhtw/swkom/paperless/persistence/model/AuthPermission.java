package at.fhtw.swkom.paperless.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auth_permission")
public class AuthPermission {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @javax.validation.constraints.Size(max = 255)
    @javax.validation.constraints.NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @javax.validation.constraints.Size(max = 100)
    @javax.validation.constraints.NotNull
    @Column(name = "content_type", nullable = false, length = 100)
    private String contentType;

    @javax.validation.constraints.Size(max = 100)
    @javax.validation.constraints.NotNull
    @Column(name = "codename", nullable = false, length = 100)
    private String codename;

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

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

}