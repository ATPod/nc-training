package by.training.nc.dev5.service;

import by.training.nc.dev5.dao.DaoFactory;
import by.training.nc.dev5.dao.InvoiceDao;
import by.training.nc.dev5.entity.Invoice;
import by.training.nc.dev5.entity.Project;
import by.training.nc.dev5.exception.DataAccessException;

/**
 * Created by Nikita on 28.03.2017.
 */
public class InvoiceService {
    private final DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);

    public void issueInvoice(Project project, double price) {
        InvoiceDao invoiceDao = daoFactory.getInvoiceDao();
        Invoice invoice = new Invoice();

        invoice.setProject(project);
        invoice.setPrice(price);
        invoice.setPaid(false);

        try {
            invoice.setId(invoiceDao.create(invoice));
        } catch (DataAccessException e) {
            e.printStackTrace();
            // todo
        }
    }

    public void payInvoice(Invoice invoice) {
        InvoiceDao invoiceDao = daoFactory.getInvoiceDao();

        invoice.setPaid(true);
        try {
            invoiceDao.update(invoice);
        } catch (DataAccessException e) {
            e.printStackTrace();
            // todo
        }
    }
}
