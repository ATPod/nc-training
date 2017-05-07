package by.training.nc.dev5.dao.persistence;

import by.training.nc.dev5.dao.TermsOfReferenceDao;
import by.training.nc.dev5.entity.Customer;
import by.training.nc.dev5.entity.Project;
import by.training.nc.dev5.entity.TermsOfReference;
import by.training.nc.dev5.entity.metamodel.Customer_;
import by.training.nc.dev5.entity.metamodel.TermsOfReference_;
import by.training.nc.dev5.exception.DataAccessException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
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

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<TermsOfReference> cq =
                cb.createQuery(TermsOfReference.class);
        Root<TermsOfReference> fromTor = cq.from(TermsOfReference.class);
        Path<Project> projectPath = fromTor.get(TermsOfReference_.project);

        cq.where(cb.isNull(projectPath));
        cq.select(fromTor);

        TypedQuery<TermsOfReference> q = getEntityManager().createQuery(cq);
        List<TermsOfReference> result = q.getResultList();

        return result;
    }

    public Collection<TermsOfReference>
            getTermsOfReferenceByCustomer(Integer customerId)
            throws DataAccessException {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<TermsOfReference> cq =
                cb.createQuery(TermsOfReference.class);
        Root<TermsOfReference> fromTor = cq.from(TermsOfReference.class);
        Path<Customer> customerPath = fromTor.get(TermsOfReference_.customer);
        Path<Integer> customerIdPath = customerPath.get(Customer_.id);

        cq.where(cb.equal(customerIdPath, customerId));
        cq.select(fromTor);

        TypedQuery<TermsOfReference> q = getEntityManager().createQuery(cq);
        List<TermsOfReference> result = q.getResultList();

        return result;
    }
}
