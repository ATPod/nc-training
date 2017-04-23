package by.training.nc.dev5.entities;

import java.io.Serializable;

public class Client extends Entity implements Serializable{

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean isInBlackList;

    public Client(int id, String firstName, String lastName, String email, String password, boolean isInBlackList) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isInBlackList = isInBlackList;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isInBlackList() {
        return isInBlackList;
    }

    public void setInBlackList(boolean inBlackList) {
        isInBlackList = inBlackList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (isInBlackList() != client.isInBlackList()) return false;
        if (!getFirstName().equals(client.getFirstName())) return false;
        if (!getLastName().equals(client.getLastName())) return false;
        if (!getEmail().equals(client.getEmail())) return false;
        return getPassword().equals(client.getPassword());
    }

    @Override
    public int hashCode() {
        int result = getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + (isInBlackList() ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isInBlackList=" + isInBlackList +
                '}';
    }
}
