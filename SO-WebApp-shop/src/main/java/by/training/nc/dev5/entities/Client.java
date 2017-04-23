package by.training.nc.dev5.entities;

import javax.persistence.*;
import java.util.Collection;

@NamedQueries( {@NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
                @NamedQuery(name = "Client.findByEmail", query = "SELECT c FROM Client c WHERE c.email=?1"),
                @NamedQuery(name = "Client.findByParam", query = "SELECT c FROM Client c WHERE c.email=?1 AND c.password=?2")})

@Entity
public class Client {
    private int id;
    private String email;
    private String password;
    private byte blacklist;
    private String firstname;
    private String lastname;
    private Collection<Ordering> orderings;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != client.id) return false;
        if (blacklist != client.blacklist) return false;
        if (email != null ? !email.equals(client.email) : client.email != null) return false;
        if (password != null ? !password.equals(client.password) : client.password != null) return false;
        if (firstname != null ? !firstname.equals(client.firstname) : client.firstname != null) return false;
        if (lastname != null ? !lastname.equals(client.lastname) : client.lastname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (int) blacklist;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "client")
    public Collection<Ordering> getOrderings() {
        return orderings;
    }

    public void setOrderings(Collection<Ordering> orderings) {
        this.orderings = orderings;
    }
}
