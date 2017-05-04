package by.training.nc.dev5.entity.metamodel;

import by.training.nc.dev5.entity.Person;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by Nikita on 04.05.2017.
 */
@StaticMetamodel(Person.class)
public class Person_ {
    public static volatile SingularAttribute<Person, Integer> id;
    public static volatile SingularAttribute<Person, String> name;
    public static volatile SingularAttribute<Person, String> login;
    public static volatile SingularAttribute<Person, String> password;
    public static volatile SingularAttribute<Person, Integer> roleId;
}
