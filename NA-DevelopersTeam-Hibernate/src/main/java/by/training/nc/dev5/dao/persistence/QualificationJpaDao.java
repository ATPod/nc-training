package by.training.nc.dev5.dao.persistence;

import by.training.nc.dev5.dao.QualificationDao;
import by.training.nc.dev5.entity.Qualification;

import javax.persistence.EntityManager;

/**
 * Created by Nikita on 07.05.2017.
 */
public class QualificationJpaDao
        extends AbstractJpaDao<Qualification, Integer>
        implements QualificationDao {
    public QualificationJpaDao(EntityManager em) {
        super(em, Qualification.class);
    }
}
