package by.training.nc.dev5.dao.persistence;

import by.training.nc.dev5.dao.QualificationDao;
import by.training.nc.dev5.entity.Qualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by Nikita on 07.05.2017.
 */
@Repository
public class QualificationJpaDao
        extends AbstractJpaDao<Qualification, Integer>
        implements QualificationDao {
    @Autowired
    public QualificationJpaDao(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, Qualification.class);
    }
}
