package by.training.nc.dev5.dao.persistence;

import by.training.nc.dev5.dao.CustomerDao;
import by.training.nc.dev5.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by Nikita on 04.05.2017.
 */
@Repository
public class CustomerJpaDao
        extends AbstractJpaDao<Customer, Integer>
        implements CustomerDao {

    @Autowired
    public CustomerJpaDao(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, Customer.class);
    }
}
