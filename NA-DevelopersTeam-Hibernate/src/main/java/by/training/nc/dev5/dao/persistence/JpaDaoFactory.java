package by.training.nc.dev5.dao.persistence;

import by.training.nc.dev5.dao.*;
import by.training.nc.dev5.entity.*;
import by.training.nc.dev5.util.JpaUtil;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;

/**
 * Created by Nikita on 07.05.2017.
 */
public class JpaDaoFactory extends DaoFactory {
    private final JpaUtil jpaUtil;

    @Autowired
    public JpaDaoFactory(JpaUtil jpaUtil) {
        this.jpaUtil = jpaUtil;
    }

    /**
     * Obtains an implementation of {@link CustomerDao} interface
     *
     * @return a dao for {@link Customer} objects
     */
    @Bean(autowire = Autowire.BY_TYPE)
    public CustomerDao getCustomerDao() {
        return new CustomerJpaDao(null) {
            /**
             * Gets the value of entityManager
             *
             * @return the value of entityManager.
             */
            @Override
            protected EntityManager getEntityManager() {
                return jpaUtil.getEntityManager();
            }
        };
    }

    /**
     * Obtains an implementation of {@link DeveloperDao} interface
     *
     * @return a dao for {@link Developer} objects
     */
    @Bean(autowire = Autowire.BY_TYPE)
    public DeveloperDao getDeveloperDao() {
        return new DeveloperJpaDao(null) {
            /**
             * Gets the value of entityManager
             *
             * @return the value of entityManager.
             */
            @Override
            protected EntityManager getEntityManager() {
                return jpaUtil.getEntityManager();
            }
        };
    }

    /**
     * Obtains an implementation of {@link ManagerDao} interface
     *
     * @return a dao for {@link Manager} objects
     */
    @Bean(autowire = Autowire.BY_TYPE)
    public ManagerDao getManagerDao() {
        return new ManagerJpaDao(null) {
            /**
             * Gets the value of entityManager
             *
             * @return the value of entityManager.
             */
            @Override
            protected EntityManager getEntityManager() {
                return jpaUtil.getEntityManager();
            }
        };
    }

    /**
     * Obtains an implementation of {@link InvoiceDao} interface
     *
     * @return a dao for {@link Invoice} objects
     */
    @Bean(autowire = Autowire.BY_TYPE)
    public InvoiceDao getInvoiceDao() {
        return new InvoiceJpaDao(null) {
            /**
             * Gets the value of entityManager
             *
             * @return the value of entityManager.
             */
            @Override
            protected EntityManager getEntityManager() {
                return jpaUtil.getEntityManager();
            }
        };
    }

    /**
     * Obtains an implementation of {@link ProjectDao} interface
     *
     * @return a dao for {@link Project} objects
     */
    @Bean(autowire = Autowire.BY_TYPE)
    public ProjectDao getProjectDao() {
        return new ProjectJpaDao(null) {
            /**
             * Gets the value of entityManager
             *
             * @return the value of entityManager.
             */
            @Override
            protected EntityManager getEntityManager() {
                return jpaUtil.getEntityManager();
            }
        };
    }

    /**
     * Obtains an implementation of {@link TermsOfReferenceDao} interface
     *
     * @return a dao for {@link TermsOfReference}
     * objects
     */
    @Bean(autowire = Autowire.BY_TYPE)
    public TermsOfReferenceDao getTermsOfReferenceDao() {
        return new TermsOfReferenceJpaDao(null) {
            /**
             * Gets the value of entityManager
             *
             * @return the value of entityManager.
             */
            @Override
            protected EntityManager getEntityManager() {
                return jpaUtil.getEntityManager();
            }
        };
    }

    /**
     * Obtains an implementation of {@link TaskDao} interface
     *
     * @return a dao for {@link Task} objects
     */
    @Bean(autowire = Autowire.BY_TYPE)
    public TaskDao getTaskDao() {
        return new TaskJpaDao(null) {
            /**
             * Gets the value of entityManager
             *
             * @return the value of entityManager.
             */
            @Override
            protected EntityManager getEntityManager() {
                return jpaUtil.getEntityManager();
            }
        };
    }

    /**
     * Obtains an implementation of {@link TimeSheetDao} interface
     *
     * @return a dao for {@link TimeSheet} objects
     */
    @Bean(autowire = Autowire.BY_TYPE)
    public TimeSheetDao getTimeSheetDao() {
        return new TimeSheetJpaDao(null) {
            /**
             * Gets the value of entityManager
             *
             * @return the value of entityManager.
             */
            @Override
            protected EntityManager getEntityManager() {
                return jpaUtil.getEntityManager();
            }
        };
    }

    /**
     * Obtains an implementation of {@link QualificationDao} interface
     *
     * @return a dao for {@link Qualification}
     * objects
     */
    @Bean(autowire = Autowire.BY_TYPE)
    public QualificationDao getQualificationDao() {
        return new QualificationJpaDao(null) {
            /**
             * Gets the value of entityManager
             *
             * @return the value of entityManager.
             */
            @Override
            protected EntityManager getEntityManager() {
                return jpaUtil.getEntityManager();
            }
        };
    }

    /**
     * Obtains an implementation of {@link TaskQuotaDao} interface
     *
     * @return a dao for {@link TaskQuota}
     * objects
     */
    @Bean(autowire = Autowire.BY_TYPE)
    public TaskQuotaDao getTaskQuotaDao() {
        return new TaskQuotaJpaDao(null) {
            /**
             * Gets the value of entityManager
             *
             * @return the value of entityManager.
             */
            @Override
            protected EntityManager getEntityManager() {
                return jpaUtil.getEntityManager();
            }
        };
    }

    /**
     * Obtains an implementation of {@link PersonDao} interface
     *
     * @return a dao for {@link Person}
     * objects
     */
    @Bean(autowire = Autowire.BY_TYPE)
    public PersonDao getPersonDao() {
        return new PersonJpaDao(null) {
            /**
             * Gets the value of entityManager
             *
             * @return the value of entityManager.
             */
            @Override
            protected EntityManager getEntityManager() {
                return jpaUtil.getEntityManager();
            }
        };
    }
}
