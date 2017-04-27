package by.training.nc.dev5.dao.mysql;

import by.training.nc.dev5.dao.DeveloperDao;
import by.training.nc.dev5.dao.ProjectDao;
import by.training.nc.dev5.dao.QualificationDao;
import by.training.nc.dev5.entity.Developer;
import by.training.nc.dev5.exception.DataAccessException;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Nikita on 29.03.2017.
 */
public class MysqlDeveloperDao
        extends MysqlAbstractPersonDao<Developer>
        implements DeveloperDao {

    public MysqlDeveloperDao() {
        super(Developer.class);
    }

    private static final String SELECT_ALL_DEVELOPERS_QUERY =
            "SELECT" +
            "  p.id AS id," +
            "  p.name AS name," +
            "  d.project_id AS project_id," +
            "  d.qualification_id AS qualification_id " +
            "FROM person p" +
            "  JOIN developer d" +
            "    ON p.id = d.person_id";
    private static final String SELECT_DEVELOPER_BY_ID_QUERY =
            "SELECT" +
            "  p.id AS id," +
            "  p.name AS name," +
            "  d.project_id AS project_id," +
            "  d.qualification_id AS qualification_id " +
            "FROM person p" +
            "  JOIN developer d" +
            "    ON p.id = d.person_id " +
            "WHERE p.id = ?";
    private static final String UPDATE_DEVELOPER_QUERY =
            "UPDATE developer" +
            " SET project_id = ?," +
                " qualification_id = ?" +
            " WHERE id = ?";
    private static final String DELETE_DEVELOPER_QUERY =
            "DELETE FROM developer WHERE id = ?";
    private static final String INSERT_INTO_DEVELOPER_QUERY =
            "INSERT INTO developer(person_id, project_id, qualification_id)" +
                    " VALUES (?, ?, ?)";
    private static final String SELECT_UNASSIGNED_DEVELOPER_QUERY =
            "SELECT p.id AS id, " +
                "p.name AS name, " +
                "d.project_id AS project_id, " +
                "d.qualification_id AS qualification_id" +
            " FROM person p" +
            " JOIN developer d" +
            "    ON p.id = d.person_id " +
            " WHERE ISNULL(d.project_id) AND d.qualification_id = ?";
    private static final String SELECT_DEVELOPERS_BY_PROJECT_QUERY =
            "SELECT" +
            "  p.id AS id," +
            "  p.name AS name," +
            "  d.project_id AS project_id," +
            "  d.qualification_id AS qualification_id " +
            "FROM person p" +
            "  JOIN developer d" +
            "    ON p.id = d.person_id " +
            "WHERE d.project_id = ?";

    /**
     * Gets all instances of type {@code E} that are located in data storage
     *
     * @return a collection of objects of type {@code E} located in the storage. If no
     * objects found, empty collection is returned.
     */
    public Collection<Developer> getAll() throws DataAccessException {
        return getAll(SELECT_ALL_DEVELOPERS_QUERY);
    }

    /**
     * Gets a record from a storage identified by {@code id}.
     *
     * @param id a unique identifier of desired record
     * @return a record from the storage or {@code null} if no found
     */
    public Developer getEntityById(Integer id) throws DataAccessException {
        return getSingleResultByIntParameter(id, SELECT_DEVELOPER_BY_ID_QUERY);
    }

    @Override
    protected Developer fetchEntity(ResultSet rs)
            throws DataAccessException {
        Developer d = new Developer();
        ProjectDao projectDao = new MysqlProjectDao();
        QualificationDao qualificationDao = new MysqlQualificationDao();
        int projectId;
        int qualificationId;

        try {
            d.setId(rs.getInt("id"));
            d.setName(rs.getString("name"));

            qualificationId = rs.getInt("qualification_id");
            d.setQualification(qualificationDao.getEntityById(qualificationId));

            projectId = rs.getInt("project_id");
            if (rs.wasNull()) {
                d.setProject(null);
            } else {
                d.setProject(projectDao.getEntityById(projectId));
            }
        } catch (SQLException e) {
            throw new DataAccessException("Database access error occurred", e);
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
    public boolean update(Developer entity) throws DataAccessException {
        if (!super.update(entity)) {
            return false;
        }

        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    UPDATE_DEVELOPER_QUERY);

            if (entity.getProject() != null) {
                ps.setInt(1, entity.getProject().getId());
            } else {
                ps.setNull(1, Types.INTEGER);
            }
            ps.setInt(2, entity.getQualification().getId());
            ps.setInt(3, entity.getId());

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            throw new DataAccessException("Database error occurred", e);
        } finally {
            disposeConnection(conn);
        }
    }

    /**
     * Deletes entry with id
     *
     * @param id an identifier of entry to delete
     * @return true if entry existed and was deleted, false otherwise
     */
    public boolean delete(Integer id) throws DataAccessException {
        if (delete(id, DELETE_DEVELOPER_QUERY)) {
            return super.delete(id); // delete from person
        }

        return false;
    }

    /**
     * Creates a new entry in the storage. Specifying id is not mandatory
     * since DAO must take care of its uniqueness within storage.
     *
     * @param entity an entity to create
     * @return an id of created entity
     */
    public Integer create(Developer entity) throws DataAccessException {
        int personId = super.create(entity); // create entry in person table
        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    INSERT_INTO_DEVELOPER_QUERY,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, personId);
            if (entity.getProject() != null) {
                ps.setInt(2, entity.getProject().getId());
            } else {
                ps.setNull(2, Types.INTEGER);
            }
            ps.setInt(3, entity.getQualification().getId());

            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            int id;

            generatedKeys.next();
            id = (int) generatedKeys.getLong(1);
            entity.setId(id);

            return id;
        } catch (SQLException e) {
            throw new DataAccessException("Database error occurred", e);
        } finally {
            disposeConnection(conn);
        }
    }

    public Collection<Developer> getUnassignedDevelopers(Integer qualificationId)
            throws DataAccessException {

        return getCollectionByIntParameter(qualificationId,
                SELECT_UNASSIGNED_DEVELOPER_QUERY);
    }

    /**
     * Gets developers assigned to this project
     *
     * @param projectId project id to get assigned developers
     * @return a collection of developers that are assigned to project
     * identified by {@code projectId}
     */
    public Collection<Developer> getDevelopers(Integer projectId)
            throws DataAccessException {

        return getCollectionByIntParameter(
                projectId, SELECT_DEVELOPERS_BY_PROJECT_QUERY);
    }
}
