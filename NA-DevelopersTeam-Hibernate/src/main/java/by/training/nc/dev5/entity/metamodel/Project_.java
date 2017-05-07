package by.training.nc.dev5.entity.metamodel;

import by.training.nc.dev5.entity.Manager;
import by.training.nc.dev5.entity.Project;
import by.training.nc.dev5.entity.TermsOfReference;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by Nikita on 04.05.2017.
 */
@StaticMetamodel(Project.class)
public class Project_ {
    public static volatile SingularAttribute<Project, Integer> id;
    public static volatile SingularAttribute<Project, Manager> manager;
    public static volatile SingularAttribute<Project, TermsOfReference> termsOfReference;
}
