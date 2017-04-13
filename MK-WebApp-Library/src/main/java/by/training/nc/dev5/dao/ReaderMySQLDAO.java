package by.training.nc.dev5.dao;

import by.training.nc.dev5.dao.dao.ReaderDAO;
import by.training.nc.dev5.dbmanager.DBManager;
import by.training.nc.dev5.model.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


@SuppressWarnings("Duplicates")

public class ReaderMySQLDAO implements ReaderDAO {

    private final static Logger logger = LogManager.getLogger(ReaderMySQLDAO.class);

    private static String insertReaderQuery = "INSERT INTO  mk-library.readers (id,name) VALUES (?,?)";
    private static String deleteReaderQuery = "DELETE FROM  mk-library.readers WHERE id = ?";
    private static String findReaderQuery = "SELECT * FROM readers WHERE id = ? ";
    private static String selectReadersQuery = "SELECT * FROM readers ";
    private static String undateReaderQuery = "UPDATE readers SET name =? where id = ? ";


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

        try (Connection connection = DBManager.getInstance().getConnection()) {

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
    public Reader findReader(int id) {

        try (Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement(findReaderQuery);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            Reader reader = new Reader();

            while (rs.next()) {
                String name = rs.getString(2);
                reader.setId(id);
                reader.setName(name);
            }


            return reader;
        } catch (SQLException e) {
            logger.error(e.getMessage());

        }
        return null;

    }

    @Override
    public boolean updateReader(Reader reader) {


        try (Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement(undateReaderQuery);
            statement.setString(1,reader.getName());
            statement.setInt(2,reader.getId());

            return ( statement.executeUpdate()!=0);


        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return false;

    }

    @Override
    public Collection<Reader> selectReaders() {

        try (Connection connection = DBManager.getInstance().getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectReadersQuery);


            ArrayList<Reader> readers = new ArrayList<>();

            int id;
            String name;
            while (rs.next()) {

                id = rs.getInt(1);
                name = rs.getString(2);

                readers.add(new Reader(id, name));
            }

            return readers;

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

        return Collections.EMPTY_LIST;
    }


}
