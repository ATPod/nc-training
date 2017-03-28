package by.training.nc.dev5.dao.mysql;

import by.training.nc.dev5.dao.*;
import by.training.nc.dev5.entity.*;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Nikita on 27.03.2017.
 */
public class MySqlDaoFactory extends DaoFactory {
    private Connection getConnection() {
        return null;
    }

    /**
     * Obtains an implementation of {@link CustomerDao} interface
     *
     * @return a dao for {@link Customer} objects
     */
    public CustomerDao getCustomerDao() {
        return new MysqlCustomerDao() {
            protected Connection getConnection() {
                return MySqlDaoFactory.this.getConnection();
            }

            protected void disposeConnection(Connection connection) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException("connection.close");
                    // TODO: handle properly
                }
            }
        };
    }

    /**
     * Obtains an implementation of {@link DeveloperDao} interface
     *
     * @return a dao for {@link Developer} objects
     */
    public DeveloperDao getDeveloperDao() {
        return null;
    }

    /**
     * Obtains an implementation of {@link ManagerDao} interface
     *
     * @return a dao for {@link Manager} objects
     */
    public ManagerDao getManagerDao() {
        return null;
    }

    /**
     * Obtains an implementation of {@link InvoiceDao} interface
     *
     * @return a dao for {@link Invoice} objects
     */
    public InvoiceDao getInvoiceDao() {
        return null;
    }

    /**
     * Obtains an implementation of {@link ProjectDao} interface
     *
     * @return a dao for {@link Project} objects
     */
    public ProjectDao getProjectDao() {
        return null;
    }

    /**
     * Obtains an implementation of {@link TermsOfReferenceDao} interface
     *
     * @return a dao for {@link TermsOfReference}
     * objects
     */
    public TermsOfReferenceDao getTermsOfReferenceDao() {
        return null;
    }

    /**
     * Obtains an implementation of {@link TaskDao} interface
     *
     * @return a dao for {@link Task} objects
     */
    public TaskDao getTaskDao() {
        return null;
    }

    /**
     * Obtains an implementation of {@link TimeSheetDao} interface
     *
     * @return a dao for {@link TimeSheet} objects
     */
    public TimeSheetDao getTimeSheetDao() {
        return null;
    }

    /**
     * Obtains an implementation of {@link QualificationDao} interface
     *
     * @return a dao for {@link Qualification}
     * objects
     */
    public QualificationDao getQualificationDao() {
        return null;
    }

    /**
     * Obtains an implementation of {@link TaskQuotaDao} interface
     *
     * @return a dao for {@link TaskQuota}
     * objects
     */
    public TaskQuotaDao getTaskQuotaDao() {
        return null;
    }
}
