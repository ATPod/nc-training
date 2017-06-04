package by.training.nc.dev5.dao.impl;

import by.training.nc.dev5.dao.AbstractDao;
import by.training.nc.dev5.dao.IAdministratorDao;
import by.training.nc.dev5.entity.Administrator;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.logger.SystemLogger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Repository("AdministratorDao")
@Transactional
public class AdministratorDao extends AbstractDao<Administrator> implements IAdministratorDao {

    public void add(Administrator administrator) throws DaoException {}

    public void remove(Administrator administrator) throws DaoException {}

    public List<Administrator> getAll() throws DaoException {return null;}

    @Transactional(readOnly = true)
    public Administrator getById(int id) throws DaoException, NotFoundException {
        try {
            Administrator administrator = (Administrator) getSession().find(Administrator.class, id);
            if (administrator != null){
                return administrator;
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
    public Administrator getByParameters(String name, String password) throws DaoException, NotFoundException {
        try {
            Query query = getSession().createNamedQuery("Administrator.findByParam");
            query.setParameter(1, name);
            query.setParameter(2, password);
            Administrator administrator = (Administrator) query.getSingleResult();
            return administrator;
        }
        catch (NoResultException e){
            throw new NotFoundException();
        }
        catch (Exception e){
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public Administrator getByName(String name) throws DaoException, NotFoundException {
        try {
            Query query = getSession().createNamedQuery("Administrator.findByName");
            query.setParameter(1, name);
            Administrator administrator = (Administrator) query.getSingleResult();
            return administrator;
        }
        catch (NoResultException e){
            throw new NotFoundException();
        }
        catch (Exception e){
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }
}
