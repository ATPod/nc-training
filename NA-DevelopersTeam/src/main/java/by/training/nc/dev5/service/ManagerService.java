package by.training.nc.dev5.service;

import by.training.nc.dev5.dao.*;
import by.training.nc.dev5.entity.*;
import by.training.nc.dev5.exception.DataAccessException;
import by.training.nc.dev5.exception.ServiceException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;

/**
 * Created by Nikita on 28.03.2017.
 */
public class ManagerService {
    static final Logger logger = LogManager.getLogger(ManagerService.class);
    private final DaoFactory daoFactory =
            DaoFactory.getDaoFactory(DaoFactory.MYSQL);
    private static ManagerService INSTANCE = new ManagerService();

    public static ManagerService getInstance() {
        return INSTANCE;
    }

    public Collection<TermsOfReference> getPendingTermsOfReference() throws ServiceException {
        TermsOfReferenceDao torDao = daoFactory.getTermsOfReferenceDao();
        TaskDao taskDao = daoFactory.getTaskDao();
        TaskQuotaDao taskQuotaDao = daoFactory.getTaskQuotaDao();

        try {
            Collection<TermsOfReference> result;

            result = torDao.getTermsOfReferenceWithNoProject();
            for (TermsOfReference tor : result) {
                tor.setTasks(taskDao.getTasks(tor.getId()));

                for (Task task : tor.getTasks()) {
                    task.setTaskQuotas(taskQuotaDao.getTaskQuotas(task.getId()));
                }
            }

            return result;
        } catch (DataAccessException e) {
            logger.error("Database access error", e);

            throw new ServiceException("Database access error occurred", e);
        }
    }

    public Project applyTermsOfReference(
            Manager manager,
            TermsOfReference termsOfReference) {

        Project project = new Project();
        ProjectDao projectDao = daoFactory.getProjectDao();

        termsOfReference.setProject(project);
        project.setTermsOfReference(termsOfReference);
        project.setManager(manager);

        try {
            projectDao.create(project);

//            assignDevelopers(project);
            // // TODO: 12.04.2017 manager assigns developers manually
        } catch (DataAccessException e) {
            e.printStackTrace();
            // todo
        }

        return project;
    }

    public Collection<Developer> getUnassignedDevelopers() {
        DeveloperDao developerDao = daoFactory.getDeveloperDao();

        return null;
    }

    public void assignDevelopers(Project project,
                                 Collection<Developer> developers)
            throws ServiceException {
        DeveloperDao developerDao = daoFactory.getDeveloperDao();

        if (project.getManager() == null) {
            logger.info("Project is not assigned");

            return;
        }

        for (Developer developer : developers) {
            developer.setProject(project);

            try {
                developerDao.update(developer);
            } catch (DataAccessException e) {
                logger.error("Database error occurred", e);

                throw new ServiceException("Database error occurred");
            }
        }
    }
}
