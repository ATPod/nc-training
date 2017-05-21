package by.training.nc.dev5.dao.persistence;

import by.training.nc.dev5.dao.CustomerDao;
import by.training.nc.dev5.entity.Customer;

import javax.persistence.EntityManager;

/**
 * Created by Nikita on 04.05.2017.
 */
public class CustomerJpaDao
        extends AbstractJpaDao<Customer, Integer>
        implements CustomerDao {

    public CustomerJpaDao(EntityManager entityManager) {
        super(entityManager, Customer.class);
    }
}
