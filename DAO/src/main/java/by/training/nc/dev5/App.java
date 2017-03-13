package by.training.nc.dev5;

import by.training.nc.dev5.unit2.dao.EmployeeDAO;
import by.training.nc.dev5.unit2.factory.DAOFactory;
import by.training.nc.dev5.unit2.model.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Console App to get DAO functionality
 */
public class App {

    private static final Logger logger = LogManager.getLogger(App.class.getName());

    public static void main(String[] args) {
        DAOFactory mySqlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        EmployeeDAO employeeDAO = mySqlDAOFactory.getEmpoyeeDAO();
        if(employeeDAO != null){
            employeeDAO.selectEmployees();
            for(Employee item:employeeDAO.selectEmployees()){
                logger.debug(item);
            }
        }
    }
}
