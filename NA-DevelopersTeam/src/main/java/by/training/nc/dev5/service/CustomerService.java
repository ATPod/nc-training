package by.training.nc.dev5.service;

import by.training.nc.dev5.dao.DaoFactory;
import by.training.nc.dev5.dao.TaskDao;
import by.training.nc.dev5.dao.TaskQuotaDao;
import by.training.nc.dev5.dao.TermsOfReferenceDao;
import by.training.nc.dev5.entity.Task;
import by.training.nc.dev5.entity.TaskQuota;
import by.training.nc.dev5.entity.TermsOfReference;
import by.training.nc.dev5.exception.DataAccessException;

/**
 * Created by F1 on 05.04.2017.
 */
public class CustomerService {
    private static final CustomerService INSTANCE = new CustomerService();
    private final DaoFactory daoFactory = 
            DaoFactory.getDaoFactory(DaoFactory.MYSQL);

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
            e.printStackTrace();
            // TODO: 05.04.2017  
        }
    }
    
    public static CustomerService getInstance() {
        return INSTANCE;
    }
}
