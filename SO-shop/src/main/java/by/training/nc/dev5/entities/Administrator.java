package by.training.nc.dev5.entities;

import java.io.Serializable;

public class Administrator extends Entity implements Serializable {

    private String name;
    private String password;

    public Administrator(int id, String name, String password) {
        super(id);
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Administrator that = (Administrator) o;

        if (this.getId() != that.getId()) return false;
        if (!name.equals(that.getName())) return false;
        return password.equals(that.getPassword());
    }

    @Override
    public int hashCode() {
        int result = this.getId();
        result = 31 * result + name.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "id=" + this.getId() +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
