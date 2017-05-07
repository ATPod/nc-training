package by.training.nc.dev5.entity;

import by.training.nc.dev5.accounts.UserRole;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Nikita on 26.03.2017.
 */
@Entity
@Table(name = "customer")
@DiscriminatorValue("" + UserRole.CUSTOMER_ROLE_ID)
public class Customer extends Person {
    public Customer() {
        setUserRole(UserRole.CUSTOMER);
    }
}
