package by.training.nc.dev5.testing.dao;

import by.training.nc.dev5.testing.dao.interfaces.IStudentDAO;
import by.training.nc.dev5.testing.entities.users.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO extends GenericDAO<Student>
        implements IStudentDAO
{
    @Autowired
    public StudentDAO(SessionFactory sessionFactory) {

        super(Student.class, sessionFactory);
    }
}
