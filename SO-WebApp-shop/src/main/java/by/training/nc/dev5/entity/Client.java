package by.training.nc.dev5.entity;

import javax.persistence.*;
import java.util.Collection;

@NamedQueries( {@NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
                @NamedQuery(name = "Client.findByEmail", query = "SELECT c FROM Client c WHERE c.email=?1"),
                @NamedQuery(name = "Client.findByParam", query = "SELECT c FROM Client c WHERE c.email=?1 AND c.password=?2")})

@Entity
public class Client extends AbstractEntity{

    private String email;
    private String password;
    private byte blacklist;
    private String firstname;
    private String lastname;
    private Collection<Ordering> orderings;

    @Basic
    @Column(name = "email", nullable = false, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "blacklist", nullable = false)
    public byte getBlacklist() {
        return blacklist;
    }

    public void setBlacklist(byte blacklist) {
        this.blacklist = blacklist;
    }

    @Basic
    @Column(name = "firstname", nullable = false, length = 50)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname", nullable = false, length = 50)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @OneToMany(mappedBy = "client")
    public Collection<Ordering> getOrderings() {
        return orderings;
    }

    public void setOrderings(Collection<Ordering> orderings) {
        this.orderings = orderings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Client client = (Client) o;

        if (getBlacklist() != client.getBlacklist()) return false;
        if (!getEmail().equals(client.getEmail())) return false;
        if (!getPassword().equals(client.getPassword())) return false;
        if (!getFirstname().equals(client.getFirstname())) return false;
        if (!getLastname().equals(client.getLastname())) return false;
        return getOrderings().equals(client.getOrderings());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + (int) getBlacklist();
        result = 31 * result + getFirstname().hashCode();
        result = 31 * result + getLastname().hashCode();
        result = 31 * result + getOrderings().hashCode();
        return result;
    }
}
