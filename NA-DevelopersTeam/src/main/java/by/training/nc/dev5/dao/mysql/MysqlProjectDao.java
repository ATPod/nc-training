package by.training.nc.dev5.dao.mysql;

import by.training.nc.dev5.dao.ManagerDao;
import by.training.nc.dev5.dao.ProjectDao;
import by.training.nc.dev5.dao.TermsOfReferenceDao;
import by.training.nc.dev5.entity.Project;
import by.training.nc.dev5.exception.DataAccessException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Nikita on 29.03.2017.
 */
public class MysqlProjectDao
        extends MysqlAbstractDao<Project>
        implements ProjectDao {

    private static final String SELECT_ALL_PROJECTS_QUERY =
            "SELECT id, manager_id, terms_of_reference_id FROM project";
    private static final String SELECT_PROJECT_BY_ID_QUERY =
            "SELECT id, manager_id, terms_of_reference_id" +
            " FROM project" +
            " WHERE id = ?";
    private static final String UPDATE_PROJECT_QUERY =
            "UPDATE project" +
            " SET manager_id = ?, terms_of_reference_id = ?" +
            " WHERE id = ?";
    private static final String DELETE_PROJECT_QUERY =
            "DELETE FROM project WHERE id = ?";
    private static final String INSERT_INTO_PROJECT_QUERY =
            "INSERT INTO project(terms_of_reference_id, manager_id)" +
            " VALUES (?, ?)";
    private static final String SELECT_PROJECT_BY_TERMS_OF_REFERENCE_QUERY =
            "SELECT id, terms_of_reference_id, manager_id" +
            " FROM project" +
            " WHERE terms_of_reference_id = ?";

    protected Project fetchEntity(ResultSet rs) throws SQLException, DataAccessException {
        Project project = new Project();
        TermsOfReferenceDao torDao = new MysqlTermsOfReferenceDao();
        ManagerDao managerDao = new MysqlManagerDao();
        int termsOfReferenceId = rs.getInt("terms_of_reference_id");
        int managerId = rs.getInt("manager_id");

        project.setId(rs.getInt("id"));
        project.setTermsOfReference(torDao.getEntityById(termsOfReferenceId));
        project.setManager(managerDao.getEntityById(managerId));

        return project;
    }

    public Collection<Project> getAll() throws DataAccessException {
        return getAll(SELECT_ALL_PROJECTS_QUERY);
    }

    public Project getEntityById(Integer id) throws DataAccessException {
        return getSingleResultByIntParameter(id, SELECT_PROJECT_BY_ID_QUERY);
    }

    public boolean update(Project entity) throws DataAccessException {
        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    UPDATE_PROJECT_QUERY);

            ps.setInt(1, entity.getTermsOfReference().getId());
            ps.setInt(2, entity.getManager().getId());
            ps.setInt(3, entity.getId());

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // todo
        } finally {
            disposeConnection(conn);
        }

        return false;
    }

    public boolean delete(Integer id) throws DataAccessException {
        return delete(id, DELETE_PROJECT_QUERY);
    }

    public Integer create(Project entity) throws DataAccessException {
        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    INSERT_INTO_PROJECT_QUERY,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, entity.getTermsOfReference().getId());
            ps.setInt(2, entity.getManager().getId());

            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();

            generatedKeys.next();

            int id = (int) generatedKeys.getLong(1);

            entity.setId(id);

            return id;
        } catch (SQLException e) {
            e.printStackTrace();
            // todo
        } finally {
            disposeConnection(conn);
        }

        return null;
    }

    public Project getProject(Integer termsOfReferenceId) throws DataAccessException {
        return getSingleResultByIntParameter(termsOfReferenceId,
                SELECT_PROJECT_BY_TERMS_OF_REFERENCE_QUERY);
    }
}
