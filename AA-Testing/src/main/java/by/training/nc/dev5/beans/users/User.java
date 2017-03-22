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

    /**
     * Creates new entity of the class <b>{@code User}</b> and initialize it
     *
     * @param id      -id of user
     * @param name    - name of user
     * @param surname - surname of user
     */

    public User(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id - id to set
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return name
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
     * @return surname
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

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
	 */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!name.equals(user.name)) return false;
        return surname.equals(user.surname);

    }

    /* (non-Javadoc)
       * @see java.lang.Object#hashCode()
       */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
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
                '}';
    }
}
