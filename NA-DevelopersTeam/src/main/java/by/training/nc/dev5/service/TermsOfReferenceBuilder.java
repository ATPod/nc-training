package by.training.nc.dev5.service;

import by.training.nc.dev5.dao.DaoFactory;
import by.training.nc.dev5.dao.TermsOfReferenceDao;
import by.training.nc.dev5.entity.Customer;
import by.training.nc.dev5.entity.Task;
import by.training.nc.dev5.entity.TermsOfReference;

import java.util.Collection;

/**
 * Created by Nikita on 27.03.2017.
 */
public abstract class TermsOfReferenceBuilder {
    private TermsOfReference termsOfReference;
    private Collection<Task> tasks;

    protected abstract DaoFactory getDaoFactory();

    public TaskBuilder getTaskBuilder() {
        return new TaskBuilder() {
            @Override
            protected DaoFactory getDaoFactory() {
                return TermsOfReferenceBuilder.this.getDaoFactory();
            }
        };
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void setCustomer(Customer customer) {
        termsOfReference.setCustomerId(customer.getId());
    }

    public TermsOfReference createTermsOfReference() {
        TermsOfReferenceDao dao = DaoFactory.getDaoFactory(DaoFactory.MYSQL)
                .getTermsOfReferenceDao();

        termsOfReference.setId(dao.create(termsOfReference));

        for (Task task : tasks) {
            task.setId(termsOfReference.getId());
        }

        return termsOfReference;
    }
}
