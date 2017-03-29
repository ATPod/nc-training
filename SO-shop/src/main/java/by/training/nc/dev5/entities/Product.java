package by.training.nc.dev5.entities;


import java.io.Serializable;

public class Product extends Entity implements Serializable {

    private String title;
    private int price;

    public Product(int id, String title, int price) {
        super(id);
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (getId() != product.getId()) return false;
        if (getPrice() != product.getPrice()) return false;
        return getTitle().equals(product.getTitle());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getPrice();
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + this.getId() +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
