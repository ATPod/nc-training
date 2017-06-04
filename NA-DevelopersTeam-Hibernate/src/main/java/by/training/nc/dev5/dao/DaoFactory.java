package by.training.nc.dev5.dao;

import by.training.nc.dev5.dao.persistence.JpaDaoFactory;
import by.training.nc.dev5.util.JpaUtil;

/**
 * Created by Nikita on 26.03.2017.
 */
public abstract class DaoFactory {
    /**
     * Obtains an implementation of {@link CustomerDao} interface
     * @return a dao for {@link by.training.nc.dev5.entity.Customer} objects
     */
    public abstract CustomerDao getCustomerDao();

    /**
     * Obtains an implementation of {@link DeveloperDao} interface
     * @return a dao for {@link by.training.nc.dev5.entity.Developer} objects
     */
    public abstract DeveloperDao getDeveloperDao();

    /**
     * Obtains an implementation of {@link ManagerDao} interface
     * @return a dao for {@link by.training.nc.dev5.entity.Manager} objects
     */
    public abstract ManagerDao getManagerDao();

    /**
     * Obtains an implementation of {@link InvoiceDao} interface
     * @return a dao for {@link by.training.nc.dev5.entity.Invoice} objects
     */
    public abstract InvoiceDao getInvoiceDao();

    /**
     * Obtains an implementation of {@link ProjectDao} interface
     * @return a dao for {@link by.training.nc.dev5.entity.Project} objects
     */
    public abstract ProjectDao getProjectDao();

    /**
     * Obtains an implementation of {@link TermsOfReferenceDao} interface
     * @return a dao for {@link by.training.nc.dev5.entity.TermsOfReference}
     * objects
     */
    public abstract TermsOfReferenceDao getTermsOfReferenceDao();

    /**
     * Obtains an implementation of {@link TaskDao} interface
     * @return a dao for {@link by.training.nc.dev5.entity.Task} objects
     */
    public abstract TaskDao getTaskDao();

    /**
     * Obtains an implementation of {@link TimeSheetDao} interface
     * @return a dao for {@link by.training.nc.dev5.entity.TimeSheet} objects
     */
    public abstract TimeSheetDao getTimeSheetDao();

    /**
     * Obtains an implementation of {@link QualificationDao} interface
     * @return a dao for {@link by.training.nc.dev5.entity.Qualification}
     * objects
     */
    public abstract QualificationDao getQualificationDao();

    /**
     * Obtains an implementation of {@link TaskQuotaDao} interface
     * @return a dao for {@link by.training.nc.dev5.entity.TaskQuota}
     * objects
     */
    public abstract TaskQuotaDao getTaskQuotaDao();

    /**
     * Obtains an implementation of {@link PersonDao} interface
     * @return a dao for {@link by.training.nc.dev5.entity.Person}
     * objects
     */
    public abstract PersonDao getPersonDao();

    /**
     * Gets an implementation of DaoFactory basing on the storage type.
     * @return an implementation of DaoFactory
     */
    public static DaoFactory getDaoFactory() {
        return new JpaDaoFactory(JpaUtil.getInstance());
    }
}
