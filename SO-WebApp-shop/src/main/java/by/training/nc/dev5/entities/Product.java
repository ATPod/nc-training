package by.training.nc.dev5.entities;

import javax.persistence.*;
import java.util.List;

@NamedQueries( {@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")} )

@Entity
public class Product {
    private int id;
    private String title;
    private int price;
    private List <Ordering> orderings;

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
    @Column(name = "title", nullable = false, length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @ManyToMany
    @JoinTable(name="ordering_product",
            joinColumns=@JoinColumn(name="idProduct", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="idOrdering", referencedColumnName="ID"))
    public List <Ordering> getOrderings() {
        return orderings;
    }

    public void setOrderings(List <Ordering> orderings) {
        this.orderings = orderings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (price != product.price) return false;
        if (title != null ? !title.equals(product.title) : product.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }
}
