package by.training.nc.dev5.entity;

import javax.persistence.*;
import java.util.List;

@NamedQueries( {@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")} )

@Entity
public class Product extends AbstractEntity{

    private String title;
    private int price;
    private List <Ordering> orderings;

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
        if (!super.equals(o)) return false;

        Product product = (Product) o;

        if (getPrice() != product.getPrice()) return false;
        return getTitle().equals(product.getTitle());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getPrice();
        return result;
    }
}
