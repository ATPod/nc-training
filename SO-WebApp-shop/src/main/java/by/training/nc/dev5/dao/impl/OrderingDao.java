package by.training.nc.dev5.dao.impl;

import by.training.nc.dev5.dao.AbstractDao;
import by.training.nc.dev5.dao.IOrderingDao;
import by.training.nc.dev5.entity.Ordering;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.logger.SystemLogger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository("OrderingDao")
@Transactional
public class OrderingDao extends AbstractDao<Ordering> implements IOrderingDao {

    @Transactional(readOnly = true)
    public Ordering getById(int id) throws NotFoundException, DaoException {
        try {
            Ordering ordering = getSession().find(Ordering.class, id);
            if (ordering != null){
                return ordering;
            }
            else {
                throw new NotFoundException();
            }
        }
        catch (Exception e){
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public List<Ordering> getByClient(int clientId) throws DaoException {
        try {
            Query query = getSession().createNamedQuery("Ordering.findByClient");
            query.setParameter(1, clientId);
            List<Ordering> orderingList = (List<Ordering>) query.getResultList();
            return orderingList;
        }
        catch (Exception e){
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public List<Ordering> getAll() throws DaoException {
        try {
            Query query = getSession().createNamedQuery("Ordering.findAll");
            List<Ordering> orderingList = (List<Ordering>) query.getResultList();
            return orderingList;
        }
        catch (Exception e){
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }

    public void remove(Ordering ordering) throws DaoException {}
}
