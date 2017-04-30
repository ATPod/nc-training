package by.training.nc.dev5.dao.mysql;

import by.training.nc.dev5.entity.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by Nikita on 04.04.2017.
 */
public class MysqlCustomerDaoTest {
    private MysqlCustomerDao testedObject;

    @Before
    public void setUp() throws Exception {
        testedObject = new MysqlCustomerDao();
    }

    @Test
    public void testCRUD() throws Exception {
        Customer customer = new Customer();
        Customer actual;

        customer.setName("John Doe");
        customer.setLogin("johnny-donny");
        customer.setPassword("password");
        testedObject.create(customer);

        actual = testedObject.getEntityById(customer.getId());
        Assert.assertEquals(customer, actual);

        customer.setName("Jane Doe");
        Assert.assertTrue(testedObject.update(customer));

        actual = testedObject.getEntityById(customer.getId());
        Assert.assertEquals(customer, actual);

        Assert.assertTrue(testedObject.delete(customer.getId()));
        Assert.assertNull(testedObject.getEntityById(customer.getId()));
    }

    @Test
    public void testGetAll() throws Exception {
        Customer[] actuals = testedObject.getAll().toArray(new Customer[0]);
        Customer[] expecteds = new Customer[2];

        expecteds[0] = new Customer();
        expecteds[0].setName("И.Ильф");
        expecteds[0].setId(1001);

        expecteds[1] = new Customer();
        expecteds[1].setName("Е.Петров");
        expecteds[1].setId(1002);

        Assert.assertArrayEquals(expecteds, actuals);
    }
}