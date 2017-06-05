package by.training.nc.dev5.entity;

import org.hibernate.annotations.Fetch;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.List;

@NamedQueries( {@NamedQuery(name = "Ordering.findAll", query = "SELECT o FROM Ordering o"),
                @NamedQuery(name = "Ordering.findByClient", query = "SELECT o FROM Ordering o WHERE o.client.id=?1")})

@Entity
public class Ordering extends AbstractEntity{

    private byte paid;
    private Client client;
    private List <Product> products;

    @Basic
    @Column(name = "paid", nullable = false)
    public byte getPaid() {
        return paid;
    }

    public void setPaid(byte paid) {
        this.paid = paid;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="ordering_product",
            joinColumns=@JoinColumn(name="idOrdering", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="idProduct", referencedColumnName="ID"))
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @ManyToOne
    @JoinColumn(name = "idClient", referencedColumnName = "id", nullable = false)
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Ordering ordering = (Ordering) o;

        if (getPaid() != ordering.getPaid()) return false;
        if (!getClient().equals(ordering.getClient())) return false;
        return getProducts().equals(ordering.getProducts());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) getPaid();
        result = 31 * result + getClient().hashCode();
        result = 31 * result + getProducts().hashCode();
        return result;
    }
}
