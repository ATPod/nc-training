package by.training.nc.dev5.entity;

import by.training.nc.dev5.accounts.UserRole;

import javax.persistence.*;

/**
 * Created by F1 on 08.04.2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(
        name = "role_id",
        discriminatorType = DiscriminatorType.INTEGER
)
@Table(name = "person")
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Basic
    @Column(name = "role_id")
    private int roleId;
    private String login;
    private String password;

    /**
     * Gets the value of login
     *
     * @return the value of login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the value of login
     *
     * @param login the new value of login.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Gets the value of password
     *
     * @return the value of password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of password
     *
     * @param password the new value of password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the value of userRole
     *
     * @return the value of userRole.
     */
    public UserRole getUserRole() {
        return UserRole.parseInt(roleId);
    }

    /**
     * Sets the value of userRole
     *
     * @param userRole the new value of userRole.
     */
    public void setUserRole(UserRole userRole) {
        this.roleId = userRole.getRoleId();
    }

    /**
     * Gets the value of id
     *
     * @return the value of id.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of id
     *
     * @param id the new value of id.
     */
    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (getId() != person.getId()) return false;
        return getName() != null ? getName().equals(person.getName()) : person.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
