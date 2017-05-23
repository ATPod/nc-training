package by.training.nc.dev5.entity;

import javax.persistence.*;

@NamedQueries( {@NamedQuery(name = "Administrator.findByParam", query = "SELECT a FROM Administrator a WHERE a.name=?1 AND a.password=?2")} )

@Entity
public class Administrator extends AbstractEntity{

    private String password;
    private String name;

    @Basic
    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Administrator that = (Administrator) o;

        if (!getPassword().equals(that.getPassword())) return false;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getName().hashCode();
        return result;
    }
}
