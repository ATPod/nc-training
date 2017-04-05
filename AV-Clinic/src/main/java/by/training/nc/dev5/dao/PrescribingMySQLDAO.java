package by.training.nc.dev5.dao;

import by.training.nc.dev5.utils.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by user on 31.03.2017.
 */
public class PrescribingMySQLDAO{
    static Logger log = Logger.getLogger(PrescribingMySQLDAO.class);

    private String SQL_QUERY_INSERT;
    private String SQL_QUERY_DELETE;

    public void setSQL_QUERY_INSERT(String SQL_QUERY_INSERT) {
        this.SQL_QUERY_INSERT = SQL_QUERY_INSERT;
    }

    public void setSQL_QUERY_DELETE(String SQL_QUERY_DELETE) {
        this.SQL_QUERY_DELETE = SQL_QUERY_DELETE;
    }

    public void add(String name, int patientId) {
        {
            Connection cn = null;
            PreparedStatement st = null;
            try {
                cn = ConnectionPool.retrieve();
                st = cn.prepareStatement(SQL_QUERY_INSERT);
                st.setString(1, name);
                st.setInt(2, patientId);
                st.executeUpdate();

            } catch (SQLException e) {
                log.error(e);
            } finally {
                try {
                    if (st != null) {
                        st.close();
                    }
                } catch (SQLException e) {
                    log.error(e);
                }
                ConnectionPool.putback(cn);
            }
        }
    }

    public void delete(int id){
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SQL_QUERY_DELETE);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            log.error(e);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                log.error(e);
            }
            ConnectionPool.putback(cn);
        }
    }
}
