package by.training.nc.dev5.dao.temporal;

import by.training.nc.dev5.dao.DaoFactory;
import by.training.nc.dev5.dao.DeveloperDao;
import by.training.nc.dev5.dao.InvoiceDao;

/**
 * Created by Nikita on 21.03.2017.
 */
public class TransientDaoFactory implements DaoFactory {
    @Override
    public DeveloperDao getDeveloperDao() {
        return new TransientDeveloperDao();
    }

    @Override
    public InvoiceDao getInvoiceDao() {
        // TODO: implement me
        throw new UnsupportedOperationException();
    }
}
