package by.training.nc.dev5;

import by.training.nc.dev5.beans.users.Student;
import by.training.nc.dev5.dao.InterfaceDAO;
import by.training.nc.dev5.dao.factory.DAOFactory;

public class App {
    public static void main(String[] args) {
        DAOFactory mySqlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        InterfaceDAO<Student> studentDAO = mySqlDAOFactory.getStudentDAO();
        if(studentDAO != null){
            for(Student item:studentDAO.getAll("")){
                System.out.println(item);
            }
        }
    }
}

