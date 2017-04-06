package by.training.nc.dev5.service;

import by.training.nc.dev5.dao.*;
import by.training.nc.dev5.entity.*;
import by.training.nc.dev5.exception.DataAccessException;

import java.util.Collection;

/**
 * Created by Nikita on 28.03.2017.
 */
public class ManagerService {
    private final DaoFactory daoFactory =
            DaoFactory.getDaoFactory(DaoFactory.MYSQL);
    private static ManagerService INSTANCE = new ManagerService();

    public static ManagerService getInstance() {
        return INSTANCE;
    }

    public Collection<TermsOfReference> getPendingTermsOfReference() {
        TermsOfReferenceDao torDao = daoFactory.getTermsOfReferenceDao();

        try {
            return torDao.getTermsOfReferenceWithNoProject();
        } catch (DataAccessException e) {
            e.printStackTrace();
            // todo
        }

        return null;
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
            pullTermsOfReference(termsOfReference);
            projectDao.create(project);

            assignDevelopers(project);
        } catch (DataAccessException e) {
            e.printStackTrace();
            // todo
        }

        return project;
    }

    private void pullTermsOfReference(TermsOfReference tor)
            throws DataAccessException {

        if (tor.getTasks() == null) {
            TaskDao taskDao = daoFactory.getTaskDao();

            tor.setTasks(taskDao.getTasks(tor.getId()));
        }
    }

    private void assignDevelopers(Project project)
            throws DataAccessException {

        TaskDao torDao = daoFactory.getTaskDao();
        Collection<Task> tasks;

        tasks = torDao.getTasks(project.getTermsOfReference().getId());

        for (Task task : tasks) {
            assignDevelopersForTask(project, task);
        }
    }

    private void assignDevelopersForTask(Project project, Task task)
            throws DataAccessException {

        DeveloperDao devDao = daoFactory.getDeveloperDao();
        TermsOfReference tor = task.getTermsOfReference();
        TaskQuotaDao taskQuotaDao = daoFactory.getTaskQuotaDao();

        for (TaskQuota tq : taskQuotaDao.getTaskQuotas(task.getId())) {
            Collection<Developer> developers;

            developers = devDao.getUnassignedDevelopers(
                    tq.getQualification().getId());
            if (developers.size() == 0) {
                throw new RuntimeException(" TODO: Not enough developers");
                // TODO: handle this situation properly
            }

            for (Developer d : developers) {
                d.setProject(project);
                devDao.update(d);
            }
        }
    }
}
