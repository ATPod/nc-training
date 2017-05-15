package by.training.nc.dev5.entity.metamodel;

import by.training.nc.dev5.entity.Customer;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by Nikita on 07.05.2017.
 */
@StaticMetamodel(Customer.class)
public class Customer_ {
    public static volatile SingularAttribute<Customer, Integer> id;
    public static volatile SingularAttribute<Customer, String> name;
}
