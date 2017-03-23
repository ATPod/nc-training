package by.training.nc.dev5.billing;

import by.training.nc.dev5.dao.DaoFactory;
import by.training.nc.dev5.dao.InvoiceDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Nikita on 21.03.2017.
 */
public class BillingService {
    private static final BillingService instance;
    private final List<InvoiceIssuedListener> invoiceIssuedListeners;
    private final InvoiceDao invoiceDao;

    static {
        instance = new BillingService();
    }

    {
        invoiceIssuedListeners = new ArrayList<>();
        invoiceDao = DaoFactory.getDaoFactory(DaoFactory.TRANSIENT).getInvoiceDao();
    }

    public static BillingService getInstance() {
        return instance;
    }

    public void addInvoiceIssuedListener(InvoiceIssuedListener listener) {
        invoiceIssuedListeners.add(listener);
    }

    public void removeInvoiceIssuedListener(InvoiceIssuedListener listener) {
        invoiceIssuedListeners.remove(listener);
    }

    public void issueInvoice(Invoice invoice) {

    }
}
