package by.training.nc.dev5.dao.mysql;

import by.training.nc.dev5.dao.DeveloperDao;
import by.training.nc.dev5.dao.ProjectDao;
import by.training.nc.dev5.dao.QualificationDao;
import by.training.nc.dev5.entity.Developer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Nikita on 29.03.2017.
 */
public class MysqlDeveloperDao
        extends MysqlAbstractDao<Developer>
        implements DeveloperDao {

    private static final String SELECT_ALL_DEVELOPERS_QUERY =
            "SELECT id, name, project_id, qualification_id FROM developer";
    private static final String SELECT_DEVELOPER_BY_ID_QUERY =
            "SELECT id, name, project_id, qualification_id" +
            " FROM developer" +
            " WHERE id = ?";
    private static final String UPDATE_DEVELOPER_QUERY =
            "UPDATE developer" +
            " SET name = ?," +
                " project_id = ?," +
                " qualification_id = ?" +
            " WHERE id = ?";
    private static final String DELETE_DEVELOPER_QUERY =
            "DELETE FROM developer WHERE id = ?";
    private static final String INSERT_INTO_DEVELOPER_QUERY =
            "INSERT INTO developer(name, project_id, qualification_id)" +
                    " VALUES (?, ?, ?)";
    private static final String SELECT_UNASSIGNED_DEVELOPER_QUERY =
            "SELECT id, name, project_id, qualification_id" +
            " FROM developer" +
            " WHERE ISNULL(project_id) AND qualification_id = ?";

    /**
     * Gets all instances of type {@code E} that are located in data storage
     *
     * @return a collection of objects of type {@code E} located in the storage. If no
     * objects found, empty collection is returned.
     */
    public Collection<Developer> getAll() {
        return getAll(SELECT_ALL_DEVELOPERS_QUERY);
    }

    /**
     * Gets a record from a storage identified by {@code id}.
     *
     * @param id a unique identifier of desired record
     * @return a record from the storage or {@code null} if no found
     */
    public Developer getEntityById(Integer id) {
        return getSingleResultByIntParameter(id, SELECT_DEVELOPER_BY_ID_QUERY);
    }

    @Override
    protected Developer fetchEntity(ResultSet rs)
            throws SQLException {
        Developer d = new Developer();
        ProjectDao projectDao = new MysqlProjectDao();
        QualificationDao qualificationDao = new MysqlQualificationDao();

        d.setId(rs.getInt("id"));
        d.setName(rs.getString("name"));

        int projectId = rs.getInt("project_id");
        int qualificationId = rs.getInt("qualification_id");

        d.setQualification(qualificationDao.getEntityById(qualificationId));

        if (rs.wasNull()) {
            d.setProject(null);
        } else {
            d.setProject(projectDao.getEntityById(projectId));
        }

        return d;
    }

    /**
     * Updates fields of record identified by {@code entity.getId()}. Since
     * this method uses id of entity for search purpose it does not support
     * changing of this id.
     *
     * @param entity an entity to update
     * @return true if entity exists and was updated, false otherwise
     */
    public boolean update(Developer entity) {
        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    UPDATE_DEVELOPER_QUERY);

            ps.setString(1, entity.getName());
            if (entity.getProject() != null) {
                ps.setInt(2, entity.getProject().getId());
            } else {
                ps.setNull(2, Types.INTEGER);
            }
            ps.setInt(3, entity.getQualification().getId());
            ps.setInt(4, entity.getId());

            if (ps.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // todo
        } finally {
            disposeConnection(conn);
        }

        return false;
    }

    /**
     * Deletes entry with id
     *
     * @param id an identifier of entry to delete
     * @return true if entry existed and was deleted, false otherwise
     */
    public boolean delete(Integer id) {
        return delete(id, DELETE_DEVELOPER_QUERY);
    }

    /**
     * Creates a new entry in the storage. Specifying id is not mandatory
     * since DAO must take care of its uniqueness within storage.
     *
     * @param entity an entity to create
     * @return an id of created entity
     */
    public Integer create(Developer entity) {
        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    INSERT_INTO_DEVELOPER_QUERY,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, entity.getName());
            if (entity.getProject() != null) {
                ps.setInt(2, entity.getProject().getId());
            } else {
                ps.setNull(2, Types.INTEGER);
            }

            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();

            generatedKeys.next();

            return (int) generatedKeys.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace();
            // todo
        } finally {
            disposeConnection(conn);
        }

        return null;
    }

    public Collection<Developer> getUnassignedDevelopers(Integer qualificationId) {
        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    SELECT_UNASSIGNED_DEVELOPER_QUERY);
            Collection<Developer> result = new ArrayList<Developer>();

            ps.setInt(1, qualificationId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Developer developer = fetchEntity(rs);

                result.add(developer);
            }

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            // todo
        } finally {
            disposeConnection(conn);
        }

        return null;
    }

    /**
     * Gets developers assigned to this project
     *
     * @param projectId project id to get assigned developers
     * @return a collection of developers that are assigned to project
     * identified by {@code projectId}
     */
    public Collection<Developer> getDevelopers(Integer projectId) {
        // todo
        return null;
    }
}
