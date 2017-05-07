package by.training.nc.dev5.entity.metamodel;

import by.training.nc.dev5.entity.Developer;
import by.training.nc.dev5.entity.Project;
import by.training.nc.dev5.entity.Qualification;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by Nikita on 04.05.2017.
 */
@StaticMetamodel(Developer.class)
public class Developer_ {
    public static volatile SingularAttribute<Developer, Qualification> qualification;
    public static volatile SingularAttribute<Developer, Project> project;
}
