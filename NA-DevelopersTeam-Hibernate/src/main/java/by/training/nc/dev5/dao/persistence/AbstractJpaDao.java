package by.training.nc.dev5.dao.persistence;

import by.training.nc.dev5.dao.AbstractDao;
import by.training.nc.dev5.exception.DataAccessException;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.List;

/**
 * Created by Nikita on 04.05.2017.
 */
public class AbstractJpaDao<E, K> implements AbstractDao<E, K> {
    private EntityManager entityManager;
    private Class<E> eClass;

    public AbstractJpaDao(EntityManager entityManager, Class<E> eClass) {
        this.entityManager = entityManager;
        this.eClass = eClass;
    }

    /**
     * Gets the value of entityManager
     *
     * @return the value of entityManager.
     */
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * Gets all instances of type {@code E} that are located in data storage
     *
     * @return a collection of objects of type {@code E} located in the storage. If no
     * objects found, empty collection is returned.
     * @throws DataAccessException when database access error occurs
     */
    public Collection<E> getAll() throws DataAccessException {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<E> cq = cb.createQuery(eClass);
        Root<E> fromE = cq.from(eClass);

        cq.select(fromE);

        TypedQuery<E> q = getEntityManager().createQuery(cq);

        return q.getResultList();
    }

    /**
     * Gets a record from a storage identified by {@code id}.
     *
     * @param id a unique identifier of desired record
     * @return a record from the storage or {@code null} if no found
     * @throws DataAccessException when database access error occurs
     */
    public E getEntityById(K id) throws DataAccessException {
        return getEntityManager().find(eClass, id);
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
        EntityManager em = getEntityManager();

        Object pk = em.getEntityManagerFactory().getPersistenceUnitUtil()
                .getIdentifier(entity);
        E e = em.find(eClass, pk);

        if (e == null) {
            return false;
        }

        em.remove(e);
        em.persist(entity);

        return true;

    }

    /**
     * Deletes entry with id
     *
     * @param id an identifier of entry to delete
     * @return true if entry existed and was deleted, false otherwise
     * @throws DataAccessException when database access error occurs
     */
    public boolean delete(K id) throws DataAccessException {
        EntityManager em = getEntityManager();

        E e = getEntityById(id);

        if (e == null) {
            return false;
        }

        em.remove(e);

        return true;
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
        EntityManager em = getEntityManager();
        Object id = em.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(entity);

        try {
//            em.getTransaction().begin();
            em.persist(entity);
//            em.getTransaction().commit();
        } catch (EntityExistsException e) {
            return null;
        }

        return (K) id;
    }
}
