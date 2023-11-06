package at.fhtw.swkom.paperless.persistence.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistence.model.AuthUser}
 */
public class AuthUserDto implements Serializable {
    private final Integer id;
    @NotNull
    @Size(max = 128)
    private final String password;
    private final OffsetDateTime lastLogin;
    @NotNull
    private final Boolean isSuperuser;
    @NotNull
    @Size(max = 150)
    private final String username;
    @NotNull
    @Size(max = 150)
    private final String firstName;
    @NotNull
    @Size(max = 150)
    private final String lastName;
    @NotNull
    @Size(max = 254)
    private final String email;
    @NotNull
    private final Boolean isStaff;
    @NotNull
    private final Boolean isActive;
    @NotNull
    private final OffsetDateTime dateJoined;

    public AuthUserDto(Integer id, String password, OffsetDateTime lastLogin, Boolean isSuperuser, String username, String firstName, String lastName, String email, Boolean isStaff, Boolean isActive, OffsetDateTime dateJoined) {
        this.id = id;
        this.password = password;
        this.lastLogin = lastLogin;
        this.isSuperuser = isSuperuser;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isStaff = isStaff;
        this.isActive = isActive;
        this.dateJoined = dateJoined;
    }

    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public OffsetDateTime getLastLogin() {
        return lastLogin;
    }

    public Boolean getIsSuperuser() {
        return isSuperuser;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getIsStaff() {
        return isStaff;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public OffsetDateTime getDateJoined() {
        return dateJoined;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthUserDto entity = (AuthUserDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.lastLogin, entity.lastLogin) &&
                Objects.equals(this.isSuperuser, entity.isSuperuser) &&
                Objects.equals(this.username, entity.username) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.isStaff, entity.isStaff) &&
                Objects.equals(this.isActive, entity.isActive) &&
                Objects.equals(this.dateJoined, entity.dateJoined);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, lastLogin, isSuperuser, username, firstName, lastName, email, isStaff, isActive, dateJoined);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "password = " + password + ", " +
                "lastLogin = " + lastLogin + ", " +
                "isSuperuser = " + isSuperuser + ", " +
                "username = " + username + ", " +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "email = " + email + ", " +
                "isStaff = " + isStaff + ", " +
                "isActive = " + isActive + ", " +
                "dateJoined = " + dateJoined + ")";
    }
}