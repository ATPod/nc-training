package by.training.nc.dev5.dao.persistence;

import by.training.nc.dev5.dao.TaskDao;
import by.training.nc.dev5.entity.Task;
import by.training.nc.dev5.exception.DataAccessException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.Collection;

/**
 * Created by Nikita on 07.05.2017.
 */
//@Repository
public class TaskJpaDao
        extends AbstractJpaDao<Task, Integer>
        implements TaskDao {

//    @Autowired
    public TaskJpaDao(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, Task.class);
    }

    public Collection<Task> getTasks(Integer termsOfReferenceId)
            throws DataAccessException {

        try {
            TypedQuery<Task> q = getEntityManager().createQuery(
                    "select t from Task t where t.termsOfReference.id = :torId",
                    Task.class
            );

            q.setParameter("torId", termsOfReferenceId);

            return q.getResultList();
        } catch (PersistenceException e) {
            throw new DataAccessException(e);
        }
    }
}
