package at.fhtw.swkom.paperless.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.OffsetDateTime;

@Entity
@Table(name = "auth_user")
public class AuthUser {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @javax.validation.constraints.Size(max = 128)
    @javax.validation.constraints.NotNull
    @Column(name = "password", nullable = false, length = 128)
    private String password;

    @Column(name = "last_login")
    private OffsetDateTime lastLogin;

    @javax.validation.constraints.NotNull
    @Column(name = "is_superuser", nullable = false)
    private Boolean isSuperuser = false;

    @javax.validation.constraints.Size(max = 150)
    @javax.validation.constraints.NotNull
    @Column(name = "username", nullable = false, length = 150)
    private String username;

    @javax.validation.constraints.Size(max = 150)
    @javax.validation.constraints.NotNull
    @Column(name = "first_name", nullable = false, length = 150)
    private String firstName;

    @javax.validation.constraints.Size(max = 150)
    @javax.validation.constraints.NotNull
    @Column(name = "last_name", nullable = false, length = 150)
    private String lastName;

    @javax.validation.constraints.Size(max = 254)
    @javax.validation.constraints.NotNull
    @Column(name = "email", nullable = false, length = 254)
    private String email;

    @javax.validation.constraints.NotNull
    @Column(name = "is_staff", nullable = false)
    private Boolean isStaff = false;

    @javax.validation.constraints.NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

    @javax.validation.constraints.NotNull
    @Column(name = "date_joined", nullable = false)
    private OffsetDateTime dateJoined;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public OffsetDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(OffsetDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Boolean getIsSuperuser() {
        return isSuperuser;
    }

    public void setIsSuperuser(Boolean isSuperuser) {
        this.isSuperuser = isSuperuser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsStaff() {
        return isStaff;
    }

    public void setIsStaff(Boolean isStaff) {
        this.isStaff = isStaff;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public OffsetDateTime getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(OffsetDateTime dateJoined) {
        this.dateJoined = dateJoined;
    }

}