package by.training.nc.dev5.service;

import by.training.nc.dev5.entity.Customer;
import by.training.nc.dev5.entity.Task;
import by.training.nc.dev5.entity.TermsOfReference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Nikita on 27.03.2017.
 */
public class TermsOfReferenceBuilder {
    private TermsOfReference termsOfReference;
    private List<Task> tasks;

    public TermsOfReferenceBuilder() {
        tasks = new ArrayList<Task>();
        termsOfReference = new TermsOfReference();
    }

    public void addTask(Task task) {
        task.setTermsOfReference(termsOfReference);
        tasks.add(task);
    }

    public Collection<Task> getTasks() {
        return Collections.unmodifiableCollection(tasks);
    }

    public void removeTask(int idx) {
        if (idx >= tasks.size() || idx < 0) {
            throw new IndexOutOfBoundsException();
        }

        tasks.remove(idx);
    }

    public void setCustomer(Customer customer) {
        termsOfReference.setCustomer(customer);
    }

    public TermsOfReference createTermsOfReference() {
        termsOfReference.setTasks(tasks);

        return termsOfReference;
    }
}
