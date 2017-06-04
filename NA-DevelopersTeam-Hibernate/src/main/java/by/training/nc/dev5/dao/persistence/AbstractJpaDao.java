package by.training.nc.dev5.dao.persistence;

import by.training.nc.dev5.dao.AbstractDao;
import by.training.nc.dev5.exception.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;

/**
 * Created by Nikita on 04.05.2017.
 */
public class AbstractJpaDao<E, K> implements AbstractDao<E, K> {
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    private Class<E> eClass;

    public AbstractJpaDao(EntityManagerFactory entityManagerFactory, Class<E> eClass) {
        this.entityManagerFactory = entityManagerFactory;
        this.eClass = eClass;
    }

    /**
     * Gets the value of entityManager
     *
     * @return the value of entityManager.
     */
    protected EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    /**
     * Gets all instances of type {@code E} that are located in data storage
     *
     * @return a collection of objects of type {@code E} located in the storage. If no
     * objects found, empty collection is returned.
     * @throws DataAccessException when database access error occurs
     */
    public Collection<E> getAll() throws DataAccessException {
        try {
            CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
            CriteriaQuery<E> cq = cb.createQuery(eClass);
            Root<E> fromE = cq.from(eClass);

            cq.select(fromE);

            TypedQuery<E> q = getEntityManager().createQuery(cq);

            return q.getResultList();
        } catch (PersistenceException e) {
            throw new DataAccessException(e);
        }
    }

    /**
     * Gets a record from a storage identified by {@code id}.
     *
     * @param id a unique identifier of desired record
     * @return a record from the storage or {@code null} if no found
     * @throws DataAccessException when database access error occurs
     */
    public E getEntityById(K id) throws DataAccessException {
        try {
            return getEntityManager().find(eClass, id);
        } catch (PersistenceException e) {
            throw new DataAccessException(e);
        }
    }

    /**
     * Updates fields of record identified by {@code entity.getId()}. Since
     * this method uses id of entity for search purpose it does not support
     * changing of this id.
     *
     * @param entity an entity to update
     * @return true if entity exists and was updated, false otherwise
     * @throws DataAccessException when database access error occurs
     */
    public boolean update(E entity) throws DataAccessException {
        try {
            EntityManager em = getEntityManager();

            Object pk = em.getEntityManagerFactory().getPersistenceUnitUtil()
                    .getIdentifier(entity);
            E found = em.find(eClass, pk);

            if (found == null) {
                return false;
            }

            em.remove(found);
            em.persist(entity);

            return true;
        } catch (PersistenceException e) {
            throw new DataAccessException(e);
        }
    }

    /**
     * Deletes entry with id
     *
     * @param id an identifier of entry to delete
     * @return true if entry existed and was deleted, false otherwise
     * @throws DataAccessException when database access error occurs
     */
    public boolean delete(K id) throws DataAccessException {
        try {
            EntityManager em = getEntityManager();

            E entityById = getEntityById(id);

            if (entityById == null) {
                return false;
            }

            em.remove(entityById);

            return true;
        } catch (PersistenceException e) {
            throw new DataAccessException(e);
        }
    }

    /**
     * Creates a new entry in the storage. Specifying id is not mandatory
     * since DAO must take care of its uniqueness within storage.
     *
     * @param entity an entity to create
     * @return an id of created entity
     * @throws DataAccessException when database access error occurs
     */
    public K create(E entity) throws DataAccessException {
        try {
            EntityManager em = getEntityManager();
            Object id;

            try {
    //            em.getTransaction().begin();
                em.persist(entity);
    //            em.getTransaction().commit();
                id = em.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(entity);
            } catch (EntityExistsException e) {
                return null;
            }

            return (K) id;
        } catch (PersistenceException e) {
            throw new DataAccessException(e);
        }
    }
}
