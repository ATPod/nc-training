package by.training.nc.dev5.dao.persistence;

import by.training.nc.dev5.dao.ManagerDao;
import by.training.nc.dev5.entity.Manager;

import javax.persistence.EntityManager;

/**
 * Created by Nikita on 04.05.2017.
 */
public class ManagerJpaDao
        extends AbstractJpaDao<Manager, Integer>
        implements ManagerDao {
    public ManagerJpaDao(EntityManager entityManager) {
        super(entityManager, Manager.class);
    }
}
