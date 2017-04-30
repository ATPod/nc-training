package by.training.nc.dev5.unit3.model;

import javax.persistence.*;

/**
 * @author Andrei Tsishkouski
 */
@Entity(name = "training")
public class Training {

    private int id;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int pId) {
        id = pId;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String pName) {
        name = pName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Training training = (Training) o;

        if (id != training.id) return false;
        return name != null ? name.equals(training.name) : training.name == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
