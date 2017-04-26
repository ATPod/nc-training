package by.training.nc.dev5.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static EntityManager entityManager;

    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SO");
            entityManager = emf.createEntityManager();
        }
        return entityManager;
    }

    public static void closeEntityManager(){
        if (entityManager != null){
            entityManager.close();
        }
    }
}