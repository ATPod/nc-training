package by.training.nc.dev5.beans.users;

/**
 * This class describes abstract entity <b>User</b>
 *
 * @author Alena Artsiuschcyk
 * @version 1.0
 */

public abstract class User {
    private int id;
    private String name;
    private String surname;
    private String login;
    private String password;

    /**
     * Creates new entity of the class <b>{@code User}</b>
     */
    public User() {

    }

    /**
     * Creates new entity of the class <b>{@code Tutor}</b> and initialize it
     *
     * @param id       -id
     * @param name     -name
     * @param surname  -surname
     * @param login    -login
     * @param password -password
     **/
    public User(int id, String name, String surname, String login, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id -id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return user name
     */

    public String getName() {
        return name;
    }

    /**
     * @param name - name to set
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return user surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname - surname to set
     */

    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return user login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login - login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return user password
     */

    public String getPassword() {
        return password;
    }

    /**
     * @param password - password to set
     */

    public void setPassword(String password) {
        this.password = password;
    }

    /* (non-Javadoc)
    * @see java.lang.Object#equals()
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;

    }

    /* (non-Javadoc)
      * @see java.lang.Object#hashCode()
      */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    /* (non-Javadoc)
        * @see java.lang.Object#toString()
        */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
