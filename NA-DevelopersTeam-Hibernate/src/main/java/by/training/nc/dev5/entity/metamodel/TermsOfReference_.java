package by.training.nc.dev5.entity.metamodel;

import by.training.nc.dev5.entity.Customer;
import by.training.nc.dev5.entity.Project;
import by.training.nc.dev5.entity.Task;
import by.training.nc.dev5.entity.TermsOfReference;

import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by Nikita on 07.05.2017.
 */
@StaticMetamodel(TermsOfReference.class)
public class TermsOfReference_ {
    public static volatile SingularAttribute<TermsOfReference, Integer> id;
    public static volatile SingularAttribute<TermsOfReference, Customer> customer;
    public static volatile CollectionAttribute<TermsOfReference, Task> tasks;
    public static volatile SingularAttribute<TermsOfReference, Project> project;
}
