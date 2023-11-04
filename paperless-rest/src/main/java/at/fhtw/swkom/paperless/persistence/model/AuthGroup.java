package at.fhtw.swkom.paperless.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auth_group")
public class AuthGroup {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @javax.validation.constraints.Size(max = 150)
    @javax.validation.constraints.NotNull
    @Column(name = "name", nullable = false, length = 150)
    private String name;

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

}