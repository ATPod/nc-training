package by.training.nc.dev5.entity;

import by.training.nc.dev5.accounts.UserRole;

import javax.persistence.Entity;

/**
 * Created by Nikita on 26.03.2017.
 */
@Entity
public class Customer extends Person {
    public Customer() {
        setUserRole(UserRole.CUSTOMER);
    }
}
