package by.training.nc.dev5.unit3.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Andrei Tishkovski
 */
@Entity(name = "employee")
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    private Set<Training> trainings = new HashSet<Training>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int pId) {
        id = pId;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String pFirstName) {
        firstName = pFirstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String pLastName) {
        lastName = pLastName;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }
    public void setEmail(String pEmail) {
        email = pEmail;
    }

    @OneToMany
    @JoinTable(name = "employee_training",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "training_id"))
    public Set<Training> getTrainings() {
        return trainings;
    }
    public void setTrainings(Set<Training> pTrainings) {
        trainings = pTrainings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (!firstName.equals(employee.firstName)) return false;
        if (!lastName.equals(employee.lastName)) return false;
        if (!email.equals(employee.email)) return false;
        return trainings != null ? trainings.equals(employee.trainings) : employee.trainings == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + (trainings != null ? trainings.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", trainings=" + trainings +
                '}';
    }
}
