package by.training.nc.dev5.service;

import by.training.nc.dev5.dao.*;
import by.training.nc.dev5.entity.*;
import by.training.nc.dev5.exception.DataAccessException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;

/**
 * Created by F1 on 05.04.2017.
 */
public class CustomerService {
    static final Logger logger = LogManager.getLogger(CustomerService.class);
    private final DaoFactory daoFactory =
            DaoFactory.getDaoFactory(DaoFactory.MYSQL);

    public Collection<TermsOfReference> getTermsOfReference(Customer customer) {
        TermsOfReferenceDao torDao = daoFactory.getTermsOfReferenceDao();
        TaskDao taskDao = daoFactory.getTaskDao();
        TaskQuotaDao taskQuotaDao = daoFactory.getTaskQuotaDao();

        try {
            Collection<TermsOfReference> tors;

            logger.debug("Fetching terms of reference by customer");
            tors = torDao
                    .getTermsOfReferenceByCustomer(customer.getId());
            logger.debug("Pulling tasks for terms of reference");

            for (TermsOfReference tor : tors) {
                Collection<Task> tasks = taskDao.getTasks(tor.getId());

                for (Task task : tasks) {
                    task.setTaskQuotas(
                            taskQuotaDao.getTaskQuotas(task.getId()));
                }

                tor.setTasks(tasks);
            }

            return tors;
        } catch (DataAccessException e) {
            logger.error("Database access error", e);
            throw new RuntimeException(e);
        }
    }

    public void proposeTermsOfReference(TermsOfReference termsOfReference) {
        TermsOfReferenceDao torDao = daoFactory.getTermsOfReferenceDao();
        TaskDao taskDao = daoFactory.getTaskDao();
        TaskQuotaDao taskQuotaDao = daoFactory.getTaskQuotaDao();

        try {
            torDao.create(termsOfReference);
            for (Task task : termsOfReference.getTasks()) {
                taskDao.create(task);
    
                for (TaskQuota taskQuota : task.getTaskQuotas()) {
                    taskQuotaDao.create(taskQuota);
                }
            }
        } catch (DataAccessException e) {
            logger.error("Database error", e);
            throw new RuntimeException(e);
        }
    }

    public Collection<Qualification> getQualifications() {
        QualificationDao qualificationDao = daoFactory.getQualificationDao();

        try {
            return qualificationDao.getAll();
        } catch (DataAccessException e) {
            logger.error("Database error", e);
            throw new RuntimeException(e);
        }
    }

    public Qualification getQualification(int id) {
        QualificationDao qualificationDao = daoFactory.getQualificationDao();

        try {
            return qualificationDao.getEntityById(id);
        } catch (DataAccessException e) {
            logger.error("Database error");
            throw new RuntimeException(e);
        }
    }
}
