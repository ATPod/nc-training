package by.training.nc.dev5.dao;

import by.training.nc.dev5.dbmanager.DBManager;
import by.training.nc.dev5.model.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;


@SuppressWarnings("Duplicates")

public class BookMySQLDAO implements BooksDAO {


    private final static  Logger logger = LogManager.getLogger(BookMySQLDAO.class); ///////!!!!!!!!//////////

    private static String insertBookQuery = "INSERT INTO  `books` (id,title) VALUES (?,?)";
    private static String deleteBookQuery = "DELETE FROM  mk-library.books WHERE id = ?";

    @Override
    public int insertBook(Book book) {

        Connection connection;
        connection = DBManager.getInstance().getConnection();
        try {

            PreparedStatement statement = connection.prepareStatement(insertBookQuery);
            statement.setInt(1, book.getId());
            statement.setString(2, book.getTitle());
            statement.executeUpdate();

            return book.getId();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            System.out.println("Что-то пошло не так"); // =) пофиксить
        }
        return -1;
    }

    @Override
    public boolean deleteBook(int id) {
        Connection connection;
        connection = DBManager.getInstance().getConnection();
        try {

            PreparedStatement statement = connection.prepareStatement(deleteBookQuery);
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
    public Book findBook(String pBookId) {
        return null;
    }

    @Override
    public boolean updateBook(String pBookId) {
        return false;
    }

    @Override
    public Collection<Book> selectBooks() {
        return null;
    }

}
