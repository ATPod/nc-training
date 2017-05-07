package by.training.nc.dev5.entity.metamodel;

import by.training.nc.dev5.entity.Manager;
import by.training.nc.dev5.entity.Project;

import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by Nikita on 07.05.2017.
 */
@StaticMetamodel(Manager.class)
public class Manager_ {
    public static volatile SingularAttribute<Manager, Integer> id;
    public static volatile SingularAttribute<Manager, String> name;
    public static volatile CollectionAttribute<Manager, Project> projects;
}
