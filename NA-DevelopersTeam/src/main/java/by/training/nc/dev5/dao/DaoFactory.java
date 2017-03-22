package by.training.nc.dev5.dao;

import by.training.nc.dev5.dao.temporal.TransientDaoFactory;

/**
 * Created by Nikita on 21.03.2017.
 */
public interface DaoFactory {
    int TRANSIENT = 1;

    DeveloperDao getDeveloperDao();

    InvoiceDao getInvoiceDao();

    TermsOfReferenceDao getTermsOfReferenceDao();

    static DaoFactory getDaoFactory(int whichFactory){
        switch (whichFactory) {
        case TRANSIENT:
            return new TransientDaoFactory();
        default:
            throw new IllegalArgumentException("");
        }
    }
}
