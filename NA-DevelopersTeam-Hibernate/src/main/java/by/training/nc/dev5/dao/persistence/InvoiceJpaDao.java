package by.training.nc.dev5.dao.persistence;

import by.training.nc.dev5.dao.InvoiceDao;
import by.training.nc.dev5.entity.Invoice;
import by.training.nc.dev5.exception.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.Collection;

/**
 * Created by Nikita on 07.05.2017.
 */
@Repository
public class InvoiceJpaDao
        extends AbstractJpaDao<Invoice, Integer>
        implements InvoiceDao {

    @Autowired
    public InvoiceJpaDao(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, Invoice.class);
    }

    public Collection<Invoice> getInvoicesByCustomer(int customerId) {
        try {
            TypedQuery<Invoice> q = getEntityManager().createQuery(
                    "select inv from Invoice inv " +
                        "where inv.project.termsOfReference.customer.id = :customerId",
                    Invoice.class
            );

            return q.setParameter("customerId", customerId).getResultList();
        } catch (PersistenceException e) {
            throw new DataAccessException(e);
        }
    }
}
