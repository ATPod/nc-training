package by.training.nc.dev5.dao;

import by.training.nc.dev5.dbmanager.DBManager;
import by.training.nc.dev5.model.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;


@SuppressWarnings("Duplicates")

public class ReaderMySQLDAO implements ReaderDAO {

    private final static  Logger logger = LogManager.getLogger(ReaderMySQLDAO.class);

    private static String insertReaderQuery = "INSERT INTO  mk-library.readers (id,name) VALUES (?,?)";
    private static String deleteReaderQuery = "DELETE FROM  mk-library.readers WHERE id = ?";

    @Override
    public int insertReader(Reader reader) {

        Connection connection;
        connection = DBManager.getInstance().getConnection();
        try {

            PreparedStatement statement = connection.prepareStatement(insertReaderQuery);

            statement.setInt(1, reader.getId());
            statement.setString(2, reader.getName());

            statement.executeUpdate();

            return reader.getId();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            System.out.println("Что-то пошло не так"); // =) пофиксить
        }
        return -1;
    }


    @Override
    public boolean deleteReader(int id) {
        Connection connection;
        connection = DBManager.getInstance().getConnection();
        try {

            PreparedStatement statement = connection.prepareStatement(deleteReaderQuery);
            statement.setInt(1, id);
            statement.executeUpdate();

            return true;
        } catch (SQLException e) {
            logger.error(e.getMessage());
            System.out.println("Что-то пошло не так"); // =) пофиксить
        }
        return false;
    }

    @Override
    public Reader findReader(String pReaderId) {
        return null;
    }

    @Override
    public boolean updateReader(String pReaderId) {
        return false;
    }

    @Override
    public Collection<Reader> selectReaders() {
        return null;
    }


}
