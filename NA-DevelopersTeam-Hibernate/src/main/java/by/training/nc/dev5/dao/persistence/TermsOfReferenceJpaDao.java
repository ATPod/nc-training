package by.training.nc.dev5.dao.persistence;

import by.training.nc.dev5.dao.TermsOfReferenceDao;
import by.training.nc.dev5.entity.TermsOfReference;
import by.training.nc.dev5.exception.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;

/**
 * Created by Nikita on 07.05.2017.
 */
@Repository
public class TermsOfReferenceJpaDao
        extends AbstractJpaDao<TermsOfReference, Integer>
        implements TermsOfReferenceDao {

    @Autowired
    public TermsOfReferenceJpaDao(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, TermsOfReference.class);
    }

    public Collection<TermsOfReference> getTermsOfReferenceWithNoProject()
            throws DataAccessException {

        try {
            TypedQuery<TermsOfReference> q = getEntityManager().createQuery(
                    "select tor from TermsOfReference tor " +
                            "left join tor.project p where p is null",
                    TermsOfReference.class
            );

            return q.getResultList();
        } catch (PersistenceException e) {
            throw new DataAccessException(e);
        }
    }

    public Collection<TermsOfReference>
            getTermsOfReferenceByCustomer(Integer customerId)
            throws DataAccessException {

        try {
            TypedQuery<TermsOfReference> q = getEntityManager().createQuery(
                    "select tor from TermsOfReference tor " +
                            "where tor.customer.id = :customerId",
                    TermsOfReference.class
            );

            q.setParameter("customerId", customerId);

            return q.getResultList();
        } catch (PersistenceException e) {
            throw new DataAccessException(e);
        }
    }
}
