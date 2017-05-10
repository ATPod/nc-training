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
        return new CustomerJpaDao(null) {
            /**
             * Gets the value of entityManager
             *
             * @return the value of entityManager.
             */
            @Override
            protected EntityManager getEntityManager() {
                return JpaUtil.getInstance().getEntityManager();
            }
        };
    }

    /**
     * Obtains an implementation of {@link DeveloperDao} interface
     *
     * @return a dao for {@link Developer} objects
     */
    public DeveloperDao getDeveloperDao() {
        return new DeveloperJpaDao(null) {
            /**
             * Gets the value of entityManager
             *
             * @return the value of entityManager.
             */
            @Override
            protected EntityManager getEntityManager() {
                return JpaUtil.getInstance().getEntityManager();
            }
        };
    }

    /**
     * Obtains an implementation of {@link ManagerDao} interface
     *
     * @return a dao for {@link Manager} objects
     */
    public ManagerDao getManagerDao() {
        return new ManagerJpaDao(null) {
            /**
             * Gets the value of entityManager
             *
             * @return the value of entityManager.
             */
            @Override
            protected EntityManager getEntityManager() {
                return JpaUtil.getInstance().getEntityManager();
            }
        };
    }

    /**
     * Obtains an implementation of {@link InvoiceDao} interface
     *
     * @return a dao for {@link Invoice} objects
     */
    public InvoiceDao getInvoiceDao() {
        return new InvoiceJpaDao(null) {
            /**
             * Gets the value of entityManager
             *
             * @return the value of entityManager.
             */
            @Override
            protected EntityManager getEntityManager() {
                return JpaUtil.getInstance().getEntityManager();
            }
        };
    }

    /**
     * Obtains an implementation of {@link ProjectDao} interface
     *
     * @return a dao for {@link Project} objects
     */
    public ProjectDao getProjectDao() {
        return new ProjectJpaDao(null) {
            /**
             * Gets the value of entityManager
             *
             * @return the value of entityManager.
             */
            @Override
            protected EntityManager getEntityManager() {
                return JpaUtil.getInstance().getEntityManager();
            }
        };
    }

    /**
     * Obtains an implementation of {@link TermsOfReferenceDao} interface
     *
     * @return a dao for {@link TermsOfReference}
     * objects
     */
    public TermsOfReferenceDao getTermsOfReferenceDao() {
        return new TermsOfReferenceJpaDao(null) {
            /**
             * Gets the value of entityManager
             *
             * @return the value of entityManager.
             */
            @Override
            protected EntityManager getEntityManager() {
                return JpaUtil.getInstance().getEntityManager();
            }
        };
    }

    /**
     * Obtains an implementation of {@link TaskDao} interface
     *
     * @return a dao for {@link Task} objects
     */
    public TaskDao getTaskDao() {
        return new TaskJpaDao(null) {
            /**
             * Gets the value of entityManager
             *
             * @return the value of entityManager.
             */
            @Override
            protected EntityManager getEntityManager() {
                return JpaUtil.getInstance().getEntityManager();
            }
        };
    }

    /**
     * Obtains an implementation of {@link TimeSheetDao} interface
     *
     * @return a dao for {@link TimeSheet} objects
     */
    public TimeSheetDao getTimeSheetDao() {
        return new TimeSheetJpaDao(null) {
            /**
             * Gets the value of entityManager
             *
             * @return the value of entityManager.
             */
            @Override
            protected EntityManager getEntityManager() {
                return JpaUtil.getInstance().getEntityManager();
            }
        };
    }

    /**
     * Obtains an implementation of {@link QualificationDao} interface
     *
     * @return a dao for {@link Qualification}
     * objects
     */
    public QualificationDao getQualificationDao() {
        return new QualificationJpaDao(null) {
            /**
             * Gets the value of entityManager
             *
             * @return the value of entityManager.
             */
            @Override
            protected EntityManager getEntityManager() {
                return JpaUtil.getInstance().getEntityManager();
            }
        };
    }

    /**
     * Obtains an implementation of {@link TaskQuotaDao} interface
     *
     * @return a dao for {@link TaskQuota}
     * objects
     */
    public TaskQuotaDao getTaskQuotaDao() {
        return new TaskQuotaJpaDao(null) {
            /**
             * Gets the value of entityManager
             *
             * @return the value of entityManager.
             */
            @Override
            protected EntityManager getEntityManager() {
                return JpaUtil.getInstance().getEntityManager();
            }
        };
    }

    /**
     * Obtains an implementation of {@link PersonDao} interface
     *
     * @return a dao for {@link Person}
     * objects
     */
    public PersonDao getPersonDao() {
        return new PersonJpaDao(null) {
            /**
             * Gets the value of entityManager
             *
             * @return the value of entityManager.
             */
            @Override
            protected EntityManager getEntityManager() {
                return JpaUtil.getInstance().getEntityManager();
            }
        };
    }
}
