package by.training.nc.dev5.dao;

import by.training.nc.dev5.dbmanager.DBManager;
import by.training.nc.dev5.model.Loan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

@SuppressWarnings("Duplicates")

public class LoanMySQLDAO implements LoanDAO {

    private final static  Logger logger = LogManager.getLogger(LoanMySQLDAO.class);

    private static String insertLoanQuery = "INSERT INTO mk-library.loans (id,id_reader,id_book,loan_type) VALUES (?,?,?,?)";
    private static String findLoan = "SELECT name,title,loan_type FROM `mk-library`.loans  \n" +
            "INNER JOIN `mk-library`.books ON id_book=`mk-library`.books.id\n" +
            "INNER JOIN `mk-library`.readers ON id_reader=`mk-library`.readers.id\n" +
            "WHERE `mk-library`.loans.id = ?";


    @Override
    public int insertLoan(Loan loan) {

        Connection connection;
        connection = DBManager.getInstance().getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(insertLoanQuery);
            statement.setInt(1, loan.getId());
            statement.setInt(2, loan.getReaderID());
            statement.setInt(3, loan.getBookID());
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
    public boolean deleteLoan(String pLoan) {
        return false;
    }


    @Override
    public Loan findLoan(int id) {

        Connection connection;
        connection = DBManager.getInstance().getConnection();
        Loan loan = null;
        try {

            PreparedStatement statement = connection.prepareStatement(insertLoanQuery);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                loan = new Loan(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4));
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
    public Collection<Loan> selectLoans() {
        return null;
    }
}
