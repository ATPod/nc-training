package by.training.nc.dev5.util;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;
import java.util.Map;

/**
 * Created by Nikita on 07.05.2017.
 */
public class JpaUtil implements EntityManagerFactory {
    private static final JpaUtil INSTANCE;
    private final EntityManagerFactory entityManagerFactory;
    private final ThreadLocal<EntityManager> entityManagers;

    static {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevelopersTeamUnit");
        INSTANCE = new JpaUtil(emf);
    }

    {
        entityManagers = new ThreadLocal<EntityManager>();
    }

    @Autowired
    public JpaUtil(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    private EntityManager ensureBoundToThread(EntityManager em) {
        EntityManager entityManager = entityManagers.get();

        if (entityManager == null || !entityManager.isOpen()) {
            entityManagers.set(em);
        }

        return entityManagers.get();
    }

    public EntityManager getEntityManager() {
        return createEntityManager();
    }

    public void releaseEntityManager() {
        entityManagers.remove();
    }

    public static JpaUtil getInstance() {
        return INSTANCE;
    }

    public EntityManager createEntityManager() {
        return ensureBoundToThread(
                entityManagerFactory.createEntityManager());
    }

    public EntityManager createEntityManager(Map map) {
        return ensureBoundToThread(
                entityManagerFactory.createEntityManager(map));
    }

    public EntityManager createEntityManager(SynchronizationType synchronizationType) {
        return ensureBoundToThread(
                entityManagerFactory.createEntityManager(synchronizationType));
    }

    public EntityManager createEntityManager(SynchronizationType synchronizationType, Map map) {
        return ensureBoundToThread(
                entityManagerFactory.createEntityManager(synchronizationType, map));
    }

    public CriteriaBuilder getCriteriaBuilder() {
        return entityManagerFactory.getCriteriaBuilder();
    }

    public Metamodel getMetamodel() {
        return entityManagerFactory.getMetamodel();
    }

    public boolean isOpen() {
        return entityManagerFactory.isOpen();
    }

    public void close() {
        entityManagerFactory.close();
    }

    public Map<String, Object> getProperties() {
        return entityManagerFactory.getProperties();
    }

    public Cache getCache() {
        return entityManagerFactory.getCache();
    }

    public PersistenceUnitUtil getPersistenceUnitUtil() {
        return entityManagerFactory.getPersistenceUnitUtil();
    }

    public void addNamedQuery(String name, Query query) {
        entityManagerFactory.addNamedQuery(name, query);
    }

    public <T> T unwrap(Class<T> cls) {
        if (cls.equals(JpaUtil.class)) {
            return (T) this;
        }
        return entityManagerFactory.unwrap(cls);
    }

    public <T> void addNamedEntityGraph(String graphName, EntityGraph<T> entityGraph) {
        entityManagerFactory.addNamedEntityGraph(graphName, entityGraph);
    }
}
