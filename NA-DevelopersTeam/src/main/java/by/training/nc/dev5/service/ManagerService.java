package by.training.nc.dev5.service;

import by.training.nc.dev5.dao.*;
import by.training.nc.dev5.entity.*;

import java.util.Collection;

/**
 * Created by Nikita on 28.03.2017.
 */
public class ManagerService {
    private final DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);

    public TermsOfReferenceBuilder getTermsOfReferenceBuilder() {
        return new TermsOfReferenceBuilder() {
        };
    }

    public Project applyTermsOfReference(Manager manager,
                                      TermsOfReference termsOfReference) {
        Project project = new Project();
        ProjectDao dao = daoFactory.getProjectDao();

        project.setTermsOfReference(termsOfReference);
        project.setManager(manager);

        project.setId(dao.create(project));

        assignDevelopers(termsOfReference);

        return project;
    }

    protected void assignDevelopers(TermsOfReference tor) {
        TaskDao torDao = daoFactory.getTaskDao();

        for (Task task : torDao.getTasks(tor.getId())) {
            assignDevelopersForTask(task);
        }
    }

    private void assignDevelopersForTask(Task task) {
        DeveloperDao devDao = daoFactory.getDeveloperDao();
        TermsOfReference tor = task.getTermsOfReference();
        TaskQuotaDao taskQuotaDao = daoFactory.getTaskQuotaDao();
        ProjectDao projectDao = daoFactory.getProjectDao();

        for (TaskQuota tq : taskQuotaDao.getTaskQuotas(task.getId())) {
            Collection<Developer> developers;

            developers = devDao.getUnassignedDevelopers(
                    tq.getQualification().getId());
            if (developers.size() == 0) {
                throw new RuntimeException(" TODO: Not enough developers");
                // TODO: handle this situation properly
            }

            for (Developer d : developers) {
                d.setProject(projectDao.getProject(tor.getId()));
                devDao.update(d);
            }
        }
    }
}
