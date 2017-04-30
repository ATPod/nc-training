package by.training.nc.dev5.dao.mysql;

import by.training.nc.dev5.dao.*;
import by.training.nc.dev5.entity.*;
import by.training.nc.dev5.exception.ConnectionException;
import by.training.nc.dev5.util.Connector;

import java.sql.Connection;

/**
 * Created by Nikita on 27.03.2017.
 */
public class MysqlDaoFactory extends DaoFactory {

    /**
     * Obtains an implementation of {@link CustomerDao} interface
     *
     * @return a dao for {@link Customer} objects
     */
    public CustomerDao getCustomerDao() {
        return new MysqlCustomerDao();
    }

    /**
     * Obtains an implementation of {@link DeveloperDao} interface
     *
     * @return a dao for {@link Developer} objects
     */
    public DeveloperDao getDeveloperDao() {
        return new MysqlDeveloperDao();
    }

    /**
     * Obtains an implementation of {@link ManagerDao} interface
     *
     * @return a dao for {@link Manager} objects
     */
    public ManagerDao getManagerDao() {
        return new MysqlManagerDao();
    }

    /**
     * Obtains an implementation of {@link InvoiceDao} interface
     *
     * @return a dao for {@link Invoice} objects
     */
    public InvoiceDao getInvoiceDao() {
        return new MysqlInvoiceDao();
    }

    /**
     * Obtains an implementation of {@link ProjectDao} interface
     *
     * @return a dao for {@link Project} objects
     */
    public ProjectDao getProjectDao() {
        return new MysqlProjectDao();
    }

    /**
     * Obtains an implementation of {@link TermsOfReferenceDao} interface
     *
     * @return a dao for {@link TermsOfReference}
     * objects
     */
    public TermsOfReferenceDao getTermsOfReferenceDao() {
        return new MysqlTermsOfReferenceDao();
    }

    /**
     * Obtains an implementation of {@link TaskDao} interface
     *
     * @return a dao for {@link Task} objects
     */
    public TaskDao getTaskDao() {
        return new MysqlTaskDao();
    }

    /**
     * Obtains an implementation of {@link TimeSheetDao} interface
     *
     * @return a dao for {@link TimeSheet} objects
     */
    public TimeSheetDao getTimeSheetDao() {
        return new MysqlTimeSheetDao();
    }

    /**
     * Obtains an implementation of {@link QualificationDao} interface
     *
     * @return a dao for {@link Qualification}
     * objects
     */
    public QualificationDao getQualificationDao() {
        return new MysqlQualificationDao();
    }

    /**
     * Obtains an implementation of {@link TaskQuotaDao} interface
     *
     * @return a dao for {@link TaskQuota}
     * objects
     */
    public TaskQuotaDao getTaskQuotaDao() {
        return new MysqlTaskQuotaDao();
    }

    @Override
    public PersonDao getPersonDao() {
        return new MysqlPersonDao();
    }
}
