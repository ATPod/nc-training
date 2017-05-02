package by.training.nc.dev5.dao.daoimpl;

import by.training.nc.dev5.dao.LoanDAO;
import by.training.nc.dev5.dbmanager.DBManager;
import by.training.nc.dev5.entity.jdbc.Book;
import by.training.nc.dev5.entity.jdbc.Loan;
import by.training.nc.dev5.entity.jdbc.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("Duplicates")

public class LoanMySQLDAO implements LoanDAO {

    private final static  Logger logger = LogManager.getLogger(LoanMySQLDAO.class);

    private static String insertLoanQuery = "INSERT INTO `mk-library`.loans (id,id_reader,id_book,loan_type) VALUES (?,?,?,?)";
    private static String findLoanQuery = "SELECT name,title,loan_type FROM `mk-library`.loans  \n" +
            "INNER JOIN `mk-library`.books ON id_book=`mk-library`.books.id\n" +
            "INNER JOIN `mk-library`.readers ON id_reader=`mk-library`.readers.id\n" +
            "WHERE `mk-library`.loans.id = ?";
    private static String selectLoansQuery = "SELECT loans.id,users.id,name,books.id,title,loan_type FROM `mk-library`.loans  \n" +
            "INNER JOIN `mk-library`.books ON id_book=`mk-library`.books.id\n" +
            "INNER JOIN `mk-library`.users ON id_user=`mk-library`.users.id" ;
    private static String deleteLoanQuery = "DELETE FROM `loans` WHERE id = ?";


    @Override
    public int insertLoan(Loan loan) {
        try (Connection connection = DBManager.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(insertLoanQuery);
            statement.setInt(1, loan.getId());
            statement.setInt(2, loan.getUser().getId());
            statement.setInt(3, loan.getBook().getId());
            statement.setString(4, loan.getLoanType());
            statement.executeUpdate();
            return loan.getId();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            System.out.println("Что-то пошло не так"); // =) пофиксить
        }
        return -1;
    }

    @Override
    public boolean deleteLoan(int id) {
        try (Connection connection = DBManager.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(deleteLoanQuery);
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return false;
    }


    @Override
    public Loan findLoan(int id) {
        Loan loan = null;
        try (Connection connection = DBManager.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(findLoanQuery);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                loan = new Loan(rs.getInt(1),
                                new User( rs.getInt(2),rs.getString(3)),
                                new Book(rs.getInt(4),rs.getString(5)),
                                rs.getString(6));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            }
        return loan;
    }


    @Override
    public boolean updateLoan(String pLoanId) {
        return false;
    }

    @Override
    public Collection<Loan> selectLoans() {
        List<Loan> loans = null ;
        try (Connection connection = DBManager.getInstance().getConnection()) {
            Statement statement = connection.prepareStatement(selectLoansQuery);
            ResultSet rs = statement.executeQuery(selectLoansQuery);
            loans = new ArrayList<>();
            int id;
            int user_id;
            String userName ;
            int book_id;
            String bookTitle;
            String loanType;
            Book book;
            User user;
            while (rs.next()){
                id = rs.getInt(1);
                user_id =rs.getInt(2);
                userName = rs.getString(3);
                book_id = rs.getInt(4);
                bookTitle =rs.getString(5);
                loanType =rs.getString(6);
                user = new User(user_id,userName);
                book = new Book(book_id,bookTitle);

                loans.add(new Loan(id,user,book,loanType));
            }
            return loans;
        } catch (SQLException e) {
            logger.error(e.getMessage());
            System.out.println("select loans mist");
        }
        return Collections.emptyList();
    }
}
