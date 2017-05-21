package by.training.nc.dev5.dao.mysql;

import by.training.nc.dev5.dao.DeveloperDao;
import by.training.nc.dev5.dao.ProjectDao;
import by.training.nc.dev5.dao.TimeSheetDao;
import by.training.nc.dev5.entity.TimeSheet;
import by.training.nc.dev5.exception.DataAccessException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Nikita on 04.04.2017.
 */
public class MysqlTimeSheetDao
        extends MysqlAbstractDao<TimeSheet>
        implements TimeSheetDao {

    private static final String UPDATE_TIME_SHEET_QUERY =
            "UPDATE time_sheet" +
                " SET" +
                    " project_id = ?," +
                    " developer_id = ?," +
                    " time = ?," +
                    " work_date = ?" +
                " WHERE id = ?";
    private static final String INSERT_INTO_TIME_SHEET_QUERY =
            "INSERT INTO time_sheet(" +
                    "project_id, developer_id, time, work_date)" +
                    " VALUES (?, ?, ?, ?)";
    private static final String DELETE_FROM_TIME_SHEET_QUERY =
            "DELETE FROM time_sheet WHERE id = ?";
    private static final String SELECT_TIME_SHEETS_BY_DEVELOPER_ID_QUERY =
            "SELECT id, project_id, developer_id, time, work_date" +
            " FROM time_sheet WHERE developer_id = ?";
    private static final String SELECT_ALL_TIME_SHEETS_QUERY =
            "SELECT id, project_id, developer_id, time, work_date" +
            " FROM time_sheet";
    private static final String SELECT_TIME_SHEET_BY_ID_QUERY =
            "SELECT id, project_id, developer_id, time, work_date" +
            " FROM time_sheet WHERE id = ?";

    /**
     * Gets all time sheets associated with specified developer.
     *
     * @param developerId an id of developer to see time sheets of
     * @return a collection of {@link TimeSheet} objects
     */
    public Collection<TimeSheet> getTimeSheets(Integer developerId)
            throws DataAccessException {

        return getCollectionByIntParameter(
                developerId, SELECT_TIME_SHEETS_BY_DEVELOPER_ID_QUERY);
    }

    /**
     * Gets all instances of type {@code E} that are located in data storage
     *
     * @return a collection of objects of type {@code E} located in the storage. If no
     * objects found, empty collection is returned.
     */
    public Collection<TimeSheet> getAll() throws DataAccessException {
        return getAll(SELECT_ALL_TIME_SHEETS_QUERY);
    }

    /**
     * Gets a record from a storage identified by {@code id}.
     *
     * @param id a unique identifier of desired record
     * @return a record from the storage or {@code null} if no found
     */
    public TimeSheet getEntityById(Integer id) throws DataAccessException {
        return getSingleResultByIntParameter(
            id, SELECT_TIME_SHEET_BY_ID_QUERY);
    }

    /**
     * Updates fields of record identified by {@code entity.getId()}. Since
     * this method uses id of entity for search purpose it does not support
     * changing of this id.
     *
     * @param entity an entity to update
     * @return true if entity exists and was updated, false otherwise
     */
    public boolean update(TimeSheet entity) throws DataAccessException {
        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    UPDATE_TIME_SHEET_QUERY);

            ps.setInt(1, entity.getProject().getId());
            ps.setInt(2, entity.getDeveloper().getId());
            ps.setInt(3, entity.getTime());
            ps.setDate(4, new java.sql.Date(entity.getDate().getTime()));
            ps.setInt(5, entity.getId());

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
        return delete(id, DELETE_FROM_TIME_SHEET_QUERY);
    }

    /**
     * Creates a new entry in the storage. Specifying id is not mandatory
     * since DAO must take care of its uniqueness within storage.
     *
     * @param entity an entity to create
     * @return an id of created entity
     */
    public Integer create(TimeSheet entity) throws DataAccessException {
        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    INSERT_INTO_TIME_SHEET_QUERY,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, entity.getProject().getId());
            ps.setInt(2, entity.getDeveloper().getId());
            ps.setInt(3, entity.getTime());
            ps.setDate(4, new java.sql.Date(entity.getDate().getTime()));

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

    protected TimeSheet fetchEntity(ResultSet rs) throws DataAccessException {
        TimeSheet timeSheet = new TimeSheet();
        ProjectDao projectDao = new MysqlProjectDao();
        DeveloperDao developerDao = new MysqlDeveloperDao();

        try {
            timeSheet.setId(rs.getInt("id"));
            timeSheet.setProject(projectDao.getEntityById(
                    rs.getInt("project_id")));
            timeSheet.setDeveloper(developerDao.getEntityById(
                    rs.getInt("developer_id")));
            timeSheet.setTime(rs.getInt("time"));
            timeSheet.setDate(rs.getDate("work_date"));
        } catch (SQLException e) {
            throw new DataAccessException("Database error occurred", e);
        }

        return timeSheet;
    }
}
