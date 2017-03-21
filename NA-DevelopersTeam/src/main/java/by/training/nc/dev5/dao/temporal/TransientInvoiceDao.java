package by.training.nc.dev5.dao.temporal;

import by.training.nc.dev5.billing.Invoice;
import by.training.nc.dev5.dao.InvoiceDao;

/**
 * Created by Nikita on 21.03.2017.
 */
public class TransientInvoiceDao
        extends TransientAbstractDao<Invoice, Integer>
        implements InvoiceDao {

    private int idCounter;

    @Override
    protected synchronized Integer generateUniqueId() {
        return idCounter++;
    }
}
