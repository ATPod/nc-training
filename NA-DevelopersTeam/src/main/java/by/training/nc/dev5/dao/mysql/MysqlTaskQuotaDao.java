package by.training.nc.dev5.dao.mysql;

import by.training.nc.dev5.dao.QualificationDao;
import by.training.nc.dev5.dao.TaskDao;
import by.training.nc.dev5.dao.TaskQuotaDao;
import by.training.nc.dev5.entity.TaskQuota;
import by.training.nc.dev5.exception.DataAccessException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Nikita on 04.04.2017.
 */
public class MysqlTaskQuotaDao
        extends MysqlAbstractDao<TaskQuota>
        implements TaskQuotaDao {
    private static final String SELECT_TASK_QUOTAS_BY_TASK_ID_QUERY =
            "SELECT qualification_id, task_id, developers_number" +
            " FROM task_quota WHERE task_id = ?";
    private static final String UPDATE_TASK_QUOTA_QUERY =
            "UPDATE task_quota" +
            " SET qualification_id = ?," +
                " task_id = ?," +
                " developers_number = ?" +
            " WHERE id = ?";
    private static final String INSERT_INTO_TASK_QUOTA_QUERY =
            "INSERT INTO task_quota(" +
                    "qualification_id, " +
                    "task_id, " +
                    "developers_number)" +
            " VALUES (?, ?, ?)";
    private static final String SELECT_ALL_TASK_QUOTAS_QUERY =
            "SELECT qualification_id, task_id, developers_number" +
            " FROM task_quota";
    private static final String SELECT_TASK_QUOTA_BY_ID_QUERY =
            "SELECT qualification_id, task_id, developers_number" +
            " FROM task_quota WHERE id = ?";
    private static final String DELETE_FROM_TASK_QUOTA_QUERY =
            "DELETE FROM task_quota WHERE id = ?";

    public Collection<TaskQuota> getTaskQuotas(int taskId)
            throws DataAccessException {
        return getCollectionByIntParameter(
                taskId, SELECT_TASK_QUOTAS_BY_TASK_ID_QUERY);
    }

    public Collection<TaskQuota> getAll() throws DataAccessException {
        return getAll(SELECT_ALL_TASK_QUOTAS_QUERY);
    }

    public TaskQuota getEntityById(Integer id) throws DataAccessException {
        return getSingleResultByIntParameter(id, SELECT_TASK_QUOTA_BY_ID_QUERY);
    }

    public boolean update(TaskQuota entity) throws DataAccessException {
        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    UPDATE_TASK_QUOTA_QUERY);

            ps.setInt(1, entity.getQualification().getId());
            ps.setInt(2, entity.getTask().getId());
            ps.setInt(3, entity.getDevelopersNumber());
            ps.setInt(4, entity.getId());

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
        return delete(id, DELETE_FROM_TASK_QUOTA_QUERY);
    }

    public Integer create(TaskQuota entity) throws DataAccessException {
        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    INSERT_INTO_TASK_QUOTA_QUERY,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, entity.getQualification().getId());
            ps.setInt(2, entity.getTask().getId());
            ps.setInt(3, entity.getDevelopersNumber());

            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            int id;

            generatedKeys.next();
            id = (int) generatedKeys.getLong(1);
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

    protected TaskQuota fetchEntity(ResultSet rs)
            throws SQLException, DataAccessException {

        TaskQuota taskQuota = new TaskQuota();
        TaskDao taskDao = new MysqlTaskDao();
        QualificationDao qualificationDao = new MysqlQualificationDao();

        taskQuota.setId(rs.getInt("id"));
        taskQuota.setDevelopersNumber(rs.getInt("developers_number"));
        taskQuota.setTask(taskDao.getEntityById(rs.getInt("task_id")));
        taskQuota.setQualification(qualificationDao.getEntityById(
                rs.getInt("qualification_id")));

        return taskQuota;
    }
}
