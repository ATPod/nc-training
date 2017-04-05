package by.training.nc.dev5.service;

import by.training.nc.dev5.dao.*;
import by.training.nc.dev5.entity.*;
import by.training.nc.dev5.exception.DataAccessException;

import java.util.Collection;

/**
 * Created by Nikita on 28.03.2017.
 */
public class ManagerService {
    private final DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);

    public Project applyTermsOfReference(
            Manager manager,
            TermsOfReference termsOfReference) {

        Project project = new Project();
        ProjectDao projectDao = daoFactory.getProjectDao();

        project.setTermsOfReference(termsOfReference);
        project.setManager(manager);

        try {
            persistTermsOfReference(termsOfReference);
            projectDao.create(project);
            assignDevelopers(project);
        } catch (DataAccessException e) {
            e.printStackTrace();
            // todo
        }

        return project;
    }

    private void persistTermsOfReference(TermsOfReference tor)
            throws DataAccessException {

        TermsOfReferenceDao torDao = daoFactory.getTermsOfReferenceDao();
        TaskDao taskDao = daoFactory.getTaskDao();
        TaskQuotaDao taskQuotaDao = daoFactory.getTaskQuotaDao();

        torDao.create(tor);
        for (Task task : tor.getTasks()) {
            taskDao.create(task);

            for (TaskQuota taskQuota : task.getTaskQuotas()) {
                taskQuotaDao.create(taskQuota);
            }
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
