package by.training.nc.dev5.dao;

import by.training.nc.dev5.entity.Invoice;

import java.util.Collection;

/**
 * Created by Nikita on 26.03.2017.
 */
public interface InvoiceDao extends AbstractDao<Invoice, Integer> {
    Collection<Invoice> getInvoicesByCustomer(int customerId);
}
