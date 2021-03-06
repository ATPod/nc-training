package by.training.nc.dev5.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ordering extends Entity implements Serializable {

    private List<Product> products;
    private int idClient;
    private boolean isPaid;

    public Ordering(int id, int idClient) {
        super(id);
        this.idClient = idClient;
        this.products = new ArrayList<Product>();
        this.isPaid = false;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ordering ordering = (Ordering) o;

        if (getId() != ordering.getId()) return false;
        if (getIdClient() != ordering.getIdClient()) return false;
        if (isPaid() != ordering.isPaid()) return false;
        return getProducts().equals(ordering.getProducts());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getProducts().hashCode();
        result = 31 * result + getIdClient();
        result = 31 * result + (isPaid() ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ordering{" +
                "id=" + this.getId() +
                ", products=" + products +
                ", idClient=" + idClient +
                ", isPaid=" + isPaid +
                '}';
    }
}
