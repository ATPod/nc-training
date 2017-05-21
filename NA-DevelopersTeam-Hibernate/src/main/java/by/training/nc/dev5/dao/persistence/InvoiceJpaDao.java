package by.training.nc.dev5.dao.persistence;

import by.training.nc.dev5.dao.InvoiceDao;
import by.training.nc.dev5.entity.Invoice;

import javax.persistence.EntityManager;

/**
 * Created by Nikita on 07.05.2017.
 */
public class InvoiceJpaDao
        extends AbstractJpaDao<Invoice, Integer>
        implements InvoiceDao {

    public InvoiceJpaDao(EntityManager em) {
        super(em, Invoice.class);
    }
}
