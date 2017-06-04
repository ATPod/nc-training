package by.training.nc.dev5.dao.persistence;

import by.training.nc.dev5.dao.ManagerDao;
import by.training.nc.dev5.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by Nikita on 04.05.2017.
 */
//@Repository
public class ManagerJpaDao
        extends AbstractJpaDao<Manager, Integer>
        implements ManagerDao {
//    @Autowired
    public ManagerJpaDao(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, Manager.class);
    }
}
