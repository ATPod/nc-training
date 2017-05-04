package by.training.nc.dev5.unit3.dao;

import by.training.nc.dev5.unit3.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Andrei Tishkovski
 */
@Repository("employeeDao")
@Transactional(readOnly = true)
public class EmployeeDAOImpl extends AbstractDAO<Integer, Employee> implements EmployeeDAO{
    private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);
    private static String FIND_ALL_EMPLOYEE = "from Employee";

    @Transactional
    public void saveEmployee(Employee pEmployee) {
    }

    public void deleteEmployee(String pEmployee) {
    }

    public Employee findById(int pEmployeeId) {
        return findByKey(pEmployeeId);
    }

    @SuppressWarnings("unchecked")
    public List<Employee> findAll() {
        List<Employee> result = getSession().createQuery(FIND_ALL_EMPLOYEE).list();
        for (Employee item:result) {
            logger.debug("item id:{}, name {}",item.getId(), item.getFirstName());
        }
        return result;
    }
}
