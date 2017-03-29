package by.training.nc.dev5.dao.factory;

import by.training.nc.dev5.beans.test.Question;
import by.training.nc.dev5.beans.test.Test;
import by.training.nc.dev5.beans.test.Variant;
import by.training.nc.dev5.beans.users.Student;
import by.training.nc.dev5.beans.users.Tutor;
import by.training.nc.dev5.dao.InterfaceDAO;

public abstract class DAOFactory {
    public static final int MYSQL = 1;
    public static final int ORACLE = 2;

    public abstract InterfaceDAO<Student> getStudentDAO();

    public abstract InterfaceDAO<Tutor> getTutorDAO();

    public abstract InterfaceDAO<Test> getTestDAO();

    public abstract InterfaceDAO<Question> getQuestionDAO();

    public abstract InterfaceDAO<Variant> getVariantDAO();

    public static DAOFactory getDAOFactory(int factoryType) {

        switch (factoryType) {
            case ORACLE:
                return null;
            case MYSQL:
                return new MySQLDAOFactory();
            default:
                return null;
        }
    }
}
