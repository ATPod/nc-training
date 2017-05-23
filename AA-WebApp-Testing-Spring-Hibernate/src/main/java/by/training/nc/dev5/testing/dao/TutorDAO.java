package by.training.nc.dev5.testing.dao;

import by.training.nc.dev5.testing.dao.interfaces.ITutorDAO;
import by.training.nc.dev5.testing.entities.users.Tutor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TutorDAO extends GenericDAO<Tutor> implements
        ITutorDAO {
    @Autowired
    public TutorDAO(SessionFactory sessionFactory) {

        super(Tutor.class, sessionFactory);
    }
}
