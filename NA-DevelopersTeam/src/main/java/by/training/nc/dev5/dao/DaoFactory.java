package by.training.nc.dev5.dao;

import by.training.nc.dev5.entity.*;

/**
 * Created by Nikita on 26.03.2017.
 */
public abstract class DaoFactory {
    /** MySQL Database */
    public static final int MYSQL = 1;

    /**
     * Obtains an implementation of {@link CustomerDao} interface
     * @return a dao for {@link Customer} objects
     */
    public abstract CustomerDao getCustomerDao();

    /**
     * Obtains an implementation of {@link DeveloperDao} interface
     * @return a dao for {@link Developer} objects
     */
    public abstract DeveloperDao getDeveloperDao();

    /**
     * Obtains an implementation of {@link ManagerDao} interface
     * @return a dao for {@link Manager} objects
     */
    public abstract ManagerDao getManagerDao();

    /**
     * Obtains an implementation of {@link InvoiceDao} interface
     * @return a dao for {@link Invoice} objects
     */
    public abstract InvoiceDao getInvoiceDao();

    /**
     * Obtains an implementation of {@link ProjectDao} interface
     * @return a dao for {@link Project} objects
     */
    public abstract ProjectDao getProjectDao();

    /**
     * Obtains an implementation of {@link TermsOfReferenceDao} interface
     * @return a dao for {@link TermsOfReference}
     * objects
     */
    public abstract TermsOfReferenceDao getTermsOfReferenceDao();

    /**
     * Obtains an implementation of {@link TaskDao} interface
     * @return a dao for {@link Task} objects
     */
    public abstract TaskDao getTaskDao();

    /**
     * Obtains an implementation of {@link TimeSheetDao} interface
     * @return a dao for {@link TimeSheet objects}
     */
    public abstract TimeSheetDao getTimeSheetDao();

    /**
     * Obtains an implementation of {@link QualificationDao} interface
     * @return a dao for {@link Qualification}
     * objects
     */
    public abstract QualificationDao getQualificationDao();

    /**
     * Gets an implementation of DaoFactory basing on the storage type.
     * @param storageType the type of data storage to access
     * @return an implementation of DaoFactory that grants access to the
     * storage of the specified type
     */
    public static DaoFactory getDaoFactory(int storageType) {
        switch (storageType) {
        case MYSQL:
            return null;
        default:
            return null;
        }
    }
}
