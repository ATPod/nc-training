package by.training.nc.dev5.utils;

import by.training.nc.dev5.logger.TestingSystemLogger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static HibernateUtil util;
    private SessionFactory sessionFactory;
    /*
     ThreadLocal у каждого потока свой собственный,
     индивидуально инициализируемый экземпляр переменной
     */
    private final ThreadLocal <Session> sessions = new ThreadLocal<>();

    private HibernateUtil(){
        try {
            sessionFactory= new Configuration().configure().buildSessionFactory();
        }
        catch(Throwable e){
            TestingSystemLogger.INSTANCE.logError(getClass(),"Initial session factory creation failed ");
            throw new ExceptionInInitializerError(e);
        }
    }

    public static HibernateUtil getInstance(){
        if (util == null){
            util = new HibernateUtil();
        }
        return util;
    }

    public Session getSession(){
        Session session = sessions.get();
        if(session == null){
            session = sessionFactory.openSession();
            sessions.set(session);
        }
        return session;
    }

    public void releaseSession(Session session){
        if(session != null){
            try{
                //session.close();
                sessions.remove();
            }
            catch(HibernateException e){
                TestingSystemLogger.INSTANCE.logError(getClass(),e.getMessage());
            }
        }
    }


}
