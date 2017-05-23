package by.training.nc.dev5.dao.util;

        import by.training.nc.dev5.utils.HibernateUtil;
        import org.hibernate.HibernateException;
        import org.hibernate.Session;
        import org.hibernate.query.Query;
        import javax.persistence.criteria.CriteriaBuilder;
        import javax.persistence.criteria.CriteriaQuery;
        import javax.persistence.criteria.Root;

        import java.io.Serializable;
        import java.util.List;

public abstract class AbstractDAO<PK extends Serializable, T> {

    protected static HibernateUtil util = HibernateUtil.getInstance();
    private final Class<T> persistentClass;

    public AbstractDAO(Class<T> persistentClass){
        this.persistentClass = persistentClass;
    }

    protected Session getSession(){
        return util.getSession();
    }

    protected Query createCriteria(String query){
        return getSession().createQuery(query);
    }

    public T findByKey(PK id) {
        return (T) getSession().get(persistentClass, id);
    }

    public void delete(PK id){
        try {
            Session session = util.getSession();
            T entity = session.get(persistentClass, id);
            session.delete(entity);
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
    }

    public void update(T entity) {
        try {
            Session session = util.getSession();
            session.merge(entity);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public Serializable insert(T entity) {
        Serializable id = 0;
        try {
            Session session = util.getSession();
            session.saveOrUpdate(entity);
            id = session.getIdentifier(entity);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return id;
    }

    public List<T> getAll() {
        List<T> results=null;
        try {
            Session session = util.getSession();
            CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
            CriteriaQuery<T> criteria=criteriaBuilder.createQuery(persistentClass);
            Root<T> typeRoot=criteria.from(persistentClass);
            criteria.select(typeRoot);
            results=session.createQuery(criteria).getResultList();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        return results;
    }


}
