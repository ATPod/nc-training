package by.training.nc.dev5;

import by.training.nc.dev5.unit2.dao.EmployeeDAO;
import by.training.nc.dev5.unit2.factory.DAOFactory;
import by.training.nc.dev5.unit2.model.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Serialize all employee to JSON
 */
public class App {
    private ObjectMapper mapper = new ObjectMapper();
    private static final  String FILE_NAME = "user";
    private static final  String FILE_EXTENSION = ".json";
    private static final Logger logger = LogManager.getLogger(App.class.getName());

    private void printEmployeeJSON(Employee employee){
        try {
            mapper.writeValue(
                    new File(new StringBuffer(FILE_NAME).append(employee.getId()).append(FILE_EXTENSION).toString()), employee);
            logger.debug(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee));
        } catch (JsonGenerationException e) {
            logger.error(e);
        } catch (JsonMappingException e) {
            logger.error(e);
        } catch (IOException e) {
            logger.error(e);
        }
    }

    public static void main(String[] args) {
        DAOFactory mySqlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        EmployeeDAO employeeDAO = mySqlDAOFactory.getEmpoyeeDAO();
        if (employeeDAO != null) {
            employeeDAO.selectEmployees();
            Iterator var3 = employeeDAO.selectEmployees().iterator();
            App appInstance = new App();
            while (var3.hasNext()) {
                Employee item = (Employee) var3.next();
                appInstance.printEmployeeJSON(item);
            }
        }
    }
}
