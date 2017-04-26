package by.training.nc.dev5.entities;

import javax.persistence.*;
import java.util.List;

@NamedQueries( {@NamedQuery(name = "Ordering.findAll", query = "SELECT o FROM Ordering o")} )

@Entity
public class Ordering {
    private int id;
    private byte paid;
    private Client client;
    private List <Product> products;

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
    @Column(name = "paid", nullable = false)
    public byte getPaid() {
        return paid;
    }

    public void setPaid(byte paid) {
        this.paid = paid;
    }

    @ManyToMany
    @JoinTable(name="ordering_product",
            joinColumns=@JoinColumn(name="idOrdering", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="idProduct", referencedColumnName="ID"))
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ordering ordering = (Ordering) o;

        if (id != ordering.id) return false;
        if (paid != ordering.paid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) paid;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idClient", referencedColumnName = "id", nullable = false)
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
