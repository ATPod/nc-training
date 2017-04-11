package by.training.nc.dev5.dao;

import by.training.nc.dev5.dbmanager.DBManager;
import by.training.nc.dev5.model.Book;
import by.training.nc.dev5.model.Loan;
import by.training.nc.dev5.model.LoanView;
import by.training.nc.dev5.model.Reader;
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
    private static String selectLoansQuery = "SELECT id,readers.id,name,books.id,title,loan_type FROM `mk-library`.loans  \n" +
            "INNER JOIN `mk-library`.books ON id_book=`mk-library`.books.id\n" +
            "INNER JOIN `mk-library`.readers ON id_reader=`mk-library`.readers.id\n" ;


    @Override
    public int insertLoan(Loan loan) {

        Connection connection;
        connection = DBManager.getInstance().getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(insertLoanQuery);
            statement.setInt(1, loan.getId());
            statement.setInt(2, loan.getReaderId());
            statement.setInt(3, loan.getBookId());
            statement.setString(4, loan.getLoanType());
            statement.executeUpdate();

            return loan.getId();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            System.out.println("Что-то пошло не так"); // =) пофиксить
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return -1;
    }

    @Override
    public boolean deleteLoan(String pLoan) {
        return false;
    }


    @Override
    public Loan findLoan(int id) {

        Connection connection;
        connection = DBManager.getInstance().getConnection();
        Loan loan = null;
        try {

            PreparedStatement statement = connection.prepareStatement(findLoanQuery);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                loan = new Loan(rs.getInt(1),
                                new Reader( rs.getInt(2),rs.getString(3)),
                                new Book(rs.getInt(4),rs.getString(5)),
                                rs.getString(6));

            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            System.out.println("Что-то пошло не так"); // =) пофиксить
        }
        return loan;
    }


    @Override
    public boolean updateLoan(String pLoanId) {
        return false;
    }

    @Override
    public Collection<LoanView> selectLoans() {
        Connection connection;
        connection = DBManager.getInstance().getConnection();
        List<LoanView> loans = null ;
        try {

            Statement statement = connection.prepareStatement(selectLoansQuery);
            ResultSet rs = statement.executeQuery(selectLoansQuery);

            loans = new ArrayList<>();

            String userName ;
            String bookTitle;
            String loanType;

            while (rs.next()){

                userName = rs.getString(1);
                bookTitle =rs.getString(2);
                loanType =rs.getString(3);

                loans.add(new LoanView(userName,bookTitle,loanType));
            }

            return loans;

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return Collections.emptyList();
    }
}
