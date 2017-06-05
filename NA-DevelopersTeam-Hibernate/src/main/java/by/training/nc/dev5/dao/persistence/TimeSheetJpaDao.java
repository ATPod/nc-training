package by.training.nc.dev5.dao.persistence;

import by.training.nc.dev5.dao.TimeSheetDao;
import by.training.nc.dev5.entity.Developer;
import by.training.nc.dev5.entity.TimeSheet;
import by.training.nc.dev5.entity.metamodel.TimeSheet_;
import by.training.nc.dev5.exception.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.Collection;

/**
 * Created by Nikita on 07.05.2017.
 */
//@Repository
public class TimeSheetJpaDao
        extends AbstractJpaDao<TimeSheet, Integer>
        implements TimeSheetDao {

//    @Autowired
    public TimeSheetJpaDao(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, TimeSheet.class);
    }

    /**
     * Gets all time sheets associated with specified developer.
     *
     * @param developerId an id of developer to see time sheets of
     * @return a collection of {@link TimeSheet} objects
     */
    public Collection<TimeSheet> getTimeSheets(Integer developerId) throws DataAccessException {
        try {
            TypedQuery<TimeSheet> q = getEntityManager().createQuery(
                    "select t from TimeSheet t" +
                            " where t.developer.id = :developerId",
                    TimeSheet.class
            );

            q.setParameter("developerId", developerId);

            return q.getResultList();
        } catch (PersistenceException e) {
            throw new DataAccessException(e);
        }
    }
}
