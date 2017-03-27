package by.training.nc.dev5.model;

import by.training.nc.dev5.artifact.Task;
import by.training.nc.dev5.artifact.TermsOfReference;
import by.training.nc.dev5.artifact.TermsOfReferenceBuilder;

/**
 * Created by Nikita on 21.03.2017.
 */
public class Customer {
    private final TermsOfReferenceBuilder builder;

    public Customer() {
        builder = new TermsOfReferenceBuilder();
        builder.setCustomer(this);
    }

    public TermsOfReference composeTermsOfReference() {
        return builder.createTermsOfReference();
    }

    public void addTask(Task task) {
        builder.addTask(task);
    }
}
