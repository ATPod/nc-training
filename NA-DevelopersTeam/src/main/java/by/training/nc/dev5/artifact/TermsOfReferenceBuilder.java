package by.training.nc.dev5.artifact;

import by.training.nc.dev5.model.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikita on 22.03.2017.
 */
public class TermsOfReferenceBuilder {
    private List<Task> tasks;
    private Customer customer;

    public TermsOfReferenceBuilder() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public TermsOfReference createTermsOfReference() {
        TermsOfReference tor = new TermsOfReference();

        tor.setCustomer(customer);
        tor.setTasks(tasks);

        return tor;
    }
}
