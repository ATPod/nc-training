package by.training.nc.dev5.dao.persistence;

import by.training.nc.dev5.dao.*;
import by.training.nc.dev5.entity.*;
import by.training.nc.dev5.util.JpaUtil;

import javax.persistence.EntityManager;

/**
 * Created by Nikita on 07.05.2017.
 */
public class JpaDaoFactory extends DaoFactory {
    /**
     * Obtains an implementation of {@link CustomerDao} interface
     *
     * @return a dao for {@link Customer} objects
     */
    public CustomerDao getCustomerDao() {
        EntityManager em = JpaUtil.getInstance().getEntityManager();

        return new CustomerJpaDao(em);
    }

    /**
     * Obtains an implementation of {@link DeveloperDao} interface
     *
     * @return a dao for {@link Developer} objects
     */
    public DeveloperDao getDeveloperDao() {
        EntityManager em = JpaUtil.getInstance().getEntityManager();

        return new DeveloperJpaDao(em);
    }

    /**
     * Obtains an implementation of {@link ManagerDao} interface
     *
     * @return a dao for {@link Manager} objects
     */
    public ManagerDao getManagerDao() {
        EntityManager em = JpaUtil.getInstance().getEntityManager();

        return new ManagerJpaDao(em);
    }

    /**
     * Obtains an implementation of {@link InvoiceDao} interface
     *
     * @return a dao for {@link Invoice} objects
     */
    public InvoiceDao getInvoiceDao() {
        EntityManager em = JpaUtil.getInstance().getEntityManager();

        return new InvoiceJpaDao(em);
    }

    /**
     * Obtains an implementation of {@link ProjectDao} interface
     *
     * @return a dao for {@link Project} objects
     */
    public ProjectDao getProjectDao() {
        EntityManager em = JpaUtil.getInstance().getEntityManager();

        return new ProjectJpaDao(em);
    }

    /**
     * Obtains an implementation of {@link TermsOfReferenceDao} interface
     *
     * @return a dao for {@link TermsOfReference}
     * objects
     */
    public TermsOfReferenceDao getTermsOfReferenceDao() {
        EntityManager em = JpaUtil.getInstance().getEntityManager();

        return new TermsOfReferenceJpaDao(em);
    }

    /**
     * Obtains an implementation of {@link TaskDao} interface
     *
     * @return a dao for {@link Task} objects
     */
    public TaskDao getTaskDao() {
        EntityManager em = JpaUtil.getInstance().getEntityManager();

        return null;
    }

    /**
     * Obtains an implementation of {@link TimeSheetDao} interface
     *
     * @return a dao for {@link TimeSheet} objects
     */
    public TimeSheetDao getTimeSheetDao() {
        EntityManager em = JpaUtil.getInstance().getEntityManager();

        return null;
    }

    /**
     * Obtains an implementation of {@link QualificationDao} interface
     *
     * @return a dao for {@link Qualification}
     * objects
     */
    public QualificationDao getQualificationDao() {
        EntityManager em = JpaUtil.getInstance().getEntityManager();

        return null;
    }

    /**
     * Obtains an implementation of {@link TaskQuotaDao} interface
     *
     * @return a dao for {@link TaskQuota}
     * objects
     */
    public TaskQuotaDao getTaskQuotaDao() {
        EntityManager em = JpaUtil.getInstance().getEntityManager();

        return null;
    }

    /**
     * Obtains an implementation of {@link PersonDao} interface
     *
     * @return a dao for {@link Person}
     * objects
     */
    public PersonDao getPersonDao() {
        EntityManager em = JpaUtil.getInstance().getEntityManager();

        return new PersonJpaDao(em);
    }
}
