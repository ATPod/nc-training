package by.training.nc.dev5.dao.persistence;

import by.training.nc.dev5.dao.TermsOfReferenceDao;
import by.training.nc.dev5.entity.TermsOfReference;
import by.training.nc.dev5.exception.DataAccessException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;

/**
 * Created by Nikita on 07.05.2017.
 */
public class TermsOfReferenceJpaDao
        extends AbstractJpaDao<TermsOfReference, Integer>
        implements TermsOfReferenceDao {

    public TermsOfReferenceJpaDao(EntityManager em) {
        super(em, TermsOfReference.class);
    }

    public Collection<TermsOfReference> getTermsOfReferenceWithNoProject()
            throws DataAccessException {

        TypedQuery<TermsOfReference> q = getEntityManager().createQuery(
                "select tor from TermsOfReference tor " +
                        "left join tor.project p where p is null",
                TermsOfReference.class
        );
        List<TermsOfReference> result = q.getResultList();

        return result;
    }

    public Collection<TermsOfReference>
            getTermsOfReferenceByCustomer(Integer customerId)
            throws DataAccessException {

        TypedQuery<TermsOfReference> q = getEntityManager().createQuery(
                "select tor from TermsOfReference tor " +
                        "where tor.customer.id = :customerId",
                TermsOfReference.class
        );

        q.setParameter("customerId", customerId);

        return q.getResultList();
    }
}
