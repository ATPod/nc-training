package by.training.nc.dev5.dao.mysql;

import by.training.nc.dev5.dao.CustomerDao;
import by.training.nc.dev5.entity.Customer;

/**
 * Created by Nikita on 27.03.2017.
 */
public class MysqlCustomerDao
        extends MysqlAbstractPersonDao<Customer>
        implements CustomerDao {

    public MysqlCustomerDao() {
        super(Customer.class);
    }
}
