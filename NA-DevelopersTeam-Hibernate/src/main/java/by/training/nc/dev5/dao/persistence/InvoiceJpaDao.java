package by.training.nc.dev5.dao.persistence;

import by.training.nc.dev5.dao.InvoiceDao;
import by.training.nc.dev5.entity.Invoice;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collection;

/**
 * Created by Nikita on 07.05.2017.
 */
public class InvoiceJpaDao
        extends AbstractJpaDao<Invoice, Integer>
        implements InvoiceDao {

    public InvoiceJpaDao(EntityManager em) {
        super(em, Invoice.class);
    }

    public Collection<Invoice> getInvoicesByCustomer(int customerId) {
        TypedQuery<Invoice> q = getEntityManager().createQuery(
                "select inv from Invoice inv " +
                    "where inv.project.termsOfReference.customer.id = :customerId",
                Invoice.class
        );

        return q.setParameter("customerId", customerId).getResultList();
    }
}
