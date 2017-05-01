package by.training.nc.dev5.util;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;


public class JPAUtil {

    private static final String persistenceUnitName = "library";

    private static Map<String, EntityManagerFactory> persistenceUnits = new HashMap<>();

    public static  EntityManager getEntityManager() {
        persistenceUnits.putIfAbsent(persistenceUnitName,
                Persistence.createEntityManagerFactory(persistenceUnitName));
        return persistenceUnits.get(persistenceUnitName)
                .createEntityManager();
    }


    public static Session getSession() {
        return getEntityManager( ).unwrap(Session.class);
    }
}