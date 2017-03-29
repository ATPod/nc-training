package by.training.nc.dev5;

import by.training.nc.dev5.artifact.Project;
import by.training.nc.dev5.artifact.Task;
import by.training.nc.dev5.artifact.TaskBuilder;
import by.training.nc.dev5.artifact.TermsOfReference;
import by.training.nc.dev5.model.Customer;
import by.training.nc.dev5.model.Manager;
import by.training.nc.dev5.model.Qualification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Sample application. Demonstrates usage of classes
 *
 * @author Nikita Atroshenko`
 */
public class App 
{
    public static void main( String[] args )
    {
        Customer customer = new Customer();
        Manager manager = new Manager();
        TermsOfReference termsOfReference;
        List<Task> taskSet = createTaskSet();

        taskSet.forEach(customer::addTask);
        termsOfReference = customer.composeTermsOfReference();
        Project project = manager.formProject(termsOfReference);
    }

    private static List<Task> createTaskSet() {
        List<Task> tasks = new ArrayList<>(3);
        TaskBuilder builder;

        builder = new TaskBuilder();
        builder.setSpecification("Create usable web interface");
        builder.addDevelopers(Qualification.MEDIUM, 1);
        builder.addDevelopers(Qualification.JUNIOR, 2);

        tasks.add(builder.createTask());

        builder = new TaskBuilder();
        builder.setSpecification("Store data in DummySQL database");
        builder.addDevelopers(Qualification.MEDIUM, 2);

        tasks.add(builder.createTask());

        builder = new TaskBuilder();
        builder.setSpecification("Implement scalable distributed architecture");
        builder.addDevelopers(Qualification.SENIOR, 2);
        builder.addDevelopers(Qualification.MEDIUM, 1);

        tasks.add(builder.createTask());

        return tasks;
    }
}
