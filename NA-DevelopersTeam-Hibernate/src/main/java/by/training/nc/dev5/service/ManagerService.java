package by.training.nc.dev5.service;

import by.training.nc.dev5.dao.*;
import by.training.nc.dev5.entity.*;
import by.training.nc.dev5.exception.DataAccessException;
import by.training.nc.dev5.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Nikita on 28.03.2017.
 */
public class ManagerService {
    static final Logger logger = LogManager.getLogger(ManagerService.class);
    private final DaoFactory daoFactory =
            DaoFactory.getDaoFactory();

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

    public TermsOfReference getTermsOfReference(int id) throws ServiceException {
        TermsOfReferenceDao torDao = daoFactory.getTermsOfReferenceDao();

        try {
            return torDao.getEntityById(id);
        } catch (DataAccessException e) {
            logger.error("Database access error occurred", e);

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

    public Collection<Project> getProjects(Manager manager)
            throws ServiceException {

        ProjectDao projectDao = daoFactory.getProjectDao();

        try {
            return projectDao.getProjects(manager.getId());
        } catch (DataAccessException e) {
            logger.error("Database access error occurred", e);

            throw new ServiceException("Database access error occurred", e);
        }
    }

    public Collection<Developer> getUnassignedDevelopers()
            throws ServiceException {

        DeveloperDao developerDao = daoFactory.getDeveloperDao();
        QualificationDao qualificationDao = daoFactory.getQualificationDao();

        try {
            Collection<Qualification> qualifications = qualificationDao.getAll();
            Collection<Developer> developers = new ArrayList<Developer>();

            for (Qualification q : qualifications) {
                developers.addAll(
                        developerDao.getUnassignedDevelopers(q.getId()));
            }

            return developers;
        } catch (DataAccessException e) {
            logger.error("Database access error occurred", e);

            throw new ServiceException("Database access error occurred", e);
        }
    }

    public Collection<Developer> getUnassignedDevelopers(int qualificationId)
            throws ServiceException {

        DeveloperDao developerDao = daoFactory.getDeveloperDao();

        try {
            Collection<Developer> developers = new ArrayList<Developer>();

            developers.addAll(
                    developerDao.getUnassignedDevelopers(qualificationId));

            return developers;
        } catch (DataAccessException e) {
            logger.error("Database access error occurred", e);

            throw new ServiceException("Database access error occurred", e);
        }
    }

    public void assignDevelopers(Project project,
                                 Collection<Developer> developers)
            throws ServiceException {
        DeveloperDao developerDao = daoFactory.getDeveloperDao();

        if (project.getManager() == null) {
            logger.warn("Project is not assigned");

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

    public Project getProject(int id) throws ServiceException {
        ProjectDao projectDao = daoFactory.getProjectDao();

        try {
            return projectDao.getEntityById(id);
        } catch (DataAccessException e) {
            logger.error("Database error occurred", e);

            throw new ServiceException("Database error occurred");
        }
    }

    public Developer getDeveloper(int id) throws ServiceException {
        DeveloperDao developerDao = daoFactory.getDeveloperDao();

        try {
            return developerDao.getEntityById(id);
        } catch (DataAccessException e) {
            logger.error("Database access error occurred", e);

            throw new ServiceException("Database access error occurred", e);
        }
    }
}
