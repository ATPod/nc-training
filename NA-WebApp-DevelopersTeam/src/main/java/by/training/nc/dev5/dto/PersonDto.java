package by.training.nc.dev5.dto;

import by.training.nc.dev5.accounts.UserRole;

/**
 * Created by Nikita on 08.05.2017.
 */
public abstract class PersonDto {
    private String name;
    private UserRole userRole;

    public PersonDto(UserRole userRole) {
        this.userRole = userRole;
    }

    /**
     * Gets the value of name
     *
     * @return the value of name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of name
     *
     * @param name the new value of name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value of userRole
     *
     * @return the value of userRole.
     */
    public UserRole getUserRole() {
        return userRole;
    }

    /**
     * Sets the value of userRole
     *
     * @param userRole the new value of userRole.
     */
    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
