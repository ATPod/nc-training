package by.training.nc.dev5.dao.mysql;

import by.training.nc.dev5.accounts.UserRole;
import by.training.nc.dev5.dao.ManagerDao;
import by.training.nc.dev5.entity.Manager;
import by.training.nc.dev5.exception.DataAccessException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Nikita on 29.03.2017.
 */
public class MysqlManagerDao
        extends MysqlAbstractPersonDao<Manager>
        implements ManagerDao {

    public MysqlManagerDao() {
        super(Manager.class);
    }
}
