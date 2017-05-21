package by.training.nc.dev5.entity.metamodel;

import by.training.nc.dev5.entity.Task;
import by.training.nc.dev5.entity.TermsOfReference;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by Nikita on 07.05.2017.
 */
@StaticMetamodel(Task.class)
public class Task_ {
    public static volatile SingularAttribute<Task, Integer> id;
    public static volatile SingularAttribute<Task, TermsOfReference> termsOfReference;
}
