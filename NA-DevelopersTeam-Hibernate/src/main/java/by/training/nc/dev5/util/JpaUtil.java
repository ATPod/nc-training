package by.training.nc.dev5.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Nikita on 07.05.2017.
 */
public class JpaUtil {
    private static final JpaUtil INSTANCE;
    private static final EntityManagerFactory FACTORY;
    private final ThreadLocal<EntityManager> entityManagers;

    static {
        INSTANCE = new JpaUtil();
        FACTORY = Persistence.createEntityManagerFactory("DevelopersTeamUnit");
    }

    {
        entityManagers = new ThreadLocal<EntityManager>();
    }

    public EntityManager getEntityManager() {
        EntityManager em = entityManagers.get();

        if (em == null) {
            em = FACTORY.createEntityManager();
            entityManagers.set(em);
        }

        return em;
    }

    public void releaseEntityManager(EntityManager em) {
        entityManagers.remove();
    }

    public static JpaUtil getInstance() {
        return INSTANCE;
    }
}
