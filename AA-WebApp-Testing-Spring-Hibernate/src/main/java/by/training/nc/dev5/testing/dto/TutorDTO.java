package by.training.nc.dev5.testing.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Data transfer object TutorDTO
 */
public class TutorDTO {
    @Size(min = 2, max = 20, message = "First name should be between 2 and 20 characters long")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я0-9]+$", message = "First name should be alphanumeric with no spaces")
    @NotNull(message = "First name cannot be empty")
    private String firstName;
    @Size(min = 3, max = 50, message = "Last name should be between 3 and 50 characters long")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я0-9-/s]+$", message = "First name should be alphanumeric with no spaces")
    @NotNull(message = "Last name cannot be empty")
    private String lastName;

    @Size(min = 3, max = 20, message = "Login should be between 3 and 20 characters long")
    @NotNull(message = "Login cannot be empty")
    private String login;

    @Size(min = 6, max = 20, message = "Password should be between 3 and 20 characters long")
    @NotNull(message = "Password cannot be empty")
    private String password;

    @Size(min = 2, max = 20, message = "Subject should be between 2 and 20 characters long")
    @NotNull(message = "Subject cannot be empty")
    private String subject;

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
