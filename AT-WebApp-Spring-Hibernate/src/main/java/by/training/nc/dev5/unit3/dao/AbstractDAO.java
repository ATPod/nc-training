package by.training.nc.dev5.unit3.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * @author Andrei Tishkovski
 */
public abstract class AbstractDAO<PK extends Serializable, T> {

    @Autowired
    private SessionFactory sessionFactory;

    private final Class<T> persistentClass;

    public AbstractDAO(){
        this.persistentClass=
                (Class<T>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    protected Query createCriteria(String query){
        return getSession().createQuery(query);
    }

    public T findByKey(PK id) {
        return (T) getSession().get(persistentClass, id);
    }
}
