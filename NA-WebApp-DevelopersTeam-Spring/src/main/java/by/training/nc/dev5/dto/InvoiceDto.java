package by.training.nc.dev5.dto;

/**
 * Created by Nikita on 13.05.2017.
 */
public class InvoiceDto {
    private double price;
    private boolean paid;
    private ProjectDto project;

    /**
     * Gets the value of price
     *
     * @return the value of price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the value of price
     *
     * @param price the new value of price.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the value of paid
     *
     * @return the value of paid.
     */
    public boolean isPaid() {
        return paid;
    }

    /**
     * Sets the value of paid
     *
     * @param paid the new value of paid.
     */
    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    /**
     * Gets the value of project
     *
     * @return the value of project.
     */
    public ProjectDto getProject() {
        return project;
    }

    /**
     * Sets the value of project
     *
     * @param project the new value of project.
     */
    public void setProject(ProjectDto project) {
        this.project = project;
    }
}
