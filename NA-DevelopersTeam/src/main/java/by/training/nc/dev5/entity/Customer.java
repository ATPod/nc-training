package by.training.nc.dev5.entity;

/**
 * Created by Nikita on 26.03.2017.
 */
public class Customer {
    private int id;
    private String name;

    /**
     * Gets the value of id
     *
     * @return the value of id.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of id
     *
     * @param id the new value of id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the value of name
     *
     * @return the value of name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of name
     *
     * @param name the new value of name.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (getId() != customer.getId()) return false;
        return getName() != null ? getName().equals(customer.getName()) : customer.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }
}
