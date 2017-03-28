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
            @Override
            protected DaoFactory getDaoFactory() {
                return daoFactory;
            }
        };
    }

    public Project applyTermsOfReference(Manager manager,
                                      TermsOfReference termsOfReference) {
        Project project = new Project();
        ProjectDao dao = daoFactory.getProjectDao();

        project.setTermsOfReferenceId(termsOfReference.getId());
        project.setManagerId(manager.getId());

        project.setId(dao.create(project));

        assignDevelopers(termsOfReference);

        return project;
    }

    protected void assignDevelopers(TermsOfReference tor) {
        TermsOfReferenceDao torDao = daoFactory.getTermsOfReferenceDao();

        for (Task task : torDao.getTasks(tor.getId())) {
            assignDevelopersForTask(task);
        }
    }

    private void assignDevelopersForTask(Task task) {
        TermsOfReferenceDao torDao = daoFactory.getTermsOfReferenceDao();
        DeveloperDao devDao = daoFactory.getDeveloperDao();
        TaskDao taskDao = daoFactory.getTaskDao();
        TermsOfReference tor = torDao.getEntityById(
                task.getTermsOfReferenceId());

        for (TaskQuota tq : taskDao.getTaskQuotas(task.getId())) {
            Collection<Developer> developers;

            developers = devDao.getUnassignedDevelopers(
                    tq.getQualificationId());
            if (developers.size() == 0) {
                throw new RuntimeException(" TODO: Not enough developers");
                // TODO: handle this situation properly
            }

            for (Developer d : developers) {
                d.setProjectId(torDao.getProject(tor.getId()).getId());
                devDao.update(d);
            }
        }
    }
}
