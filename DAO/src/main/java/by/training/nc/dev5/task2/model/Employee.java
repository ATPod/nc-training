package by.training.nc.dev5.task2.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Andrei Tishkovski
 */
public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private Set<Training> trainings = new HashSet<Training>();

    public int getId() {
        return id;
    }

    public void setId(int pId) {
        id = pId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String pFirstName) {
        firstName = pFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String pLastName) {
        lastName = pLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String pEmail) {
        email = pEmail;
    }

    public Set<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(Set<Training> pTrainings) {
        trainings = pTrainings;
    }

}
