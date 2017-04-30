package by.training.nc.dev5.dao.mysql;

import by.training.nc.dev5.dao.PersonDao;
import by.training.nc.dev5.entity.Person;
import by.training.nc.dev5.exception.DataAccessException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Represents a data access object for abstract user (Person). You cannot use
 * this class for modifying or creating entries, but still can use it for
 * reading.
 *
 * @author Nikita Atroshenko
 */
public class MysqlPersonDao
        extends MysqlAbstractPersonDao<Person>
        implements PersonDao {

    public MysqlPersonDao() {
        super(Person.class);
    }

    private static final String SELECT_PERSON_BY_LOGIN_QUERY =
            "SELECT id, name, login, password, role_id" +
                    " FROM person" +
                    " WHERE login = ?";

    /**
     * Not supported for this class
     */
    public boolean update(Person entity) throws DataAccessException {
        throw new UnsupportedOperationException(
                "Cannot add an abstract person to database");
    }

    /**
     * Not supported for this class
     */
    public boolean delete(Integer id) throws DataAccessException {
        throw new UnsupportedOperationException(
                "Cannot remove an abstract person from database");
    }

    /**
     * Not supported for this class
     */
    public Integer create(Person entity) throws DataAccessException {
        throw new UnsupportedOperationException(
                "Cannot insert an abstract person to database");
    }

    public Person getPersonByLogin(String login) throws DataAccessException {
        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    SELECT_PERSON_BY_LOGIN_QUERY);
            ResultSet rs;

            ps.setString(1, login);
            rs = ps.executeQuery();

            if (rs.next()) {
                return fetchEntity(rs);
            }

            return null;
        } catch (SQLException e) {
            throw new DataAccessException("Database access error occurred", e);
        }
    }
}
