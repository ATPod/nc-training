/**
 * 
 */
package by.training.nc.dev5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import by.training.nc.dev5.dao.factory.MySQLDAOFactory;
import by.training.nc.dev5.entities.Account;
import by.training.nc.dev5.entities.CreditCard;
import by.training.nc.dev5.exceptions.NotCorrectIdException;
import by.training.nc.dev5.exceptions.NotCorrectPasswordException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author nic
 *
 */
public class CreditCardMySQLDAO implements CreditCardDAO {

	private static final String SQL_SELECT = "SELECT F_ID, F_CLIENTLOGIN, F_MONEY," +
            " F_BLOCKED, F_PASSWORD from t_creditcard";
	private static final String SQL_INSERT = "INSERT INTO t_creditcard (F_ID, F_CLIENTLOGIN," +
            " F_MONEY, F_BLOCKED, F_PASSWORD) values(?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE t_creditcard SET F_CLIENTLOGIN = ?," +
            "F_MONEY = ?,F_BLOCKED = ?,F_PASSWORD = ? WHERE t_creditcard.F_ID = ?";
	private static final String SQL_DELETE = "DELETE FROM t_creditcard WHERE t_creditcard.F_ID = ?";
	private static final String SQL_FIND = "SELECT * FROM t_creditcard WHERE F_ID = ?";
	private static final String SQL_FIND_ALL = "SELECT * FROM t_creditcard WHERE F_CLIENTLOGIN = ?";

    // logger for the class
    static Logger logger = LogManager.getLogger(ClientMySQLDAO.class);

	public boolean deleteCreditCard(CreditCard pCreditCard) {

        int success = 0;
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement ptmt = connection.prepareStatement(SQL_DELETE)) {
            ptmt.setString(1,pCreditCard.getId());
            success = ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (success > 0);
	}

	/* (non-Javadoc)
	 * @see by.training.nc.dev5.dao.TrainingDAO#findTraining(java.lang.String)
	 */
	public CreditCard findCreditCard(String pCreditCardId) {
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement ptmt = connection.prepareStatement(SQL_FIND)) {
            ptmt.setString(1, pCreditCardId);
            ResultSet rs = ptmt.executeQuery();
            if (rs != null) {
                rs.next();
                CreditCard creditCard = new CreditCard();
                Account account = new Account();
                creditCard.setId(rs.getString("F_ID"));
                creditCard.setClientLogin(rs.getString("F_CLIENTLOGIN"));
                creditCard.setPassword(rs.getString("F_PASSWORD"));
                account.setMoney(rs.getDouble("F_MONEY"));
                account.setBlocked(rs.getBoolean("F_BLOCKED"));
                creditCard.setAccount(account);
                return creditCard;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NotCorrectPasswordException e){
            e.printStackTrace();
        } catch (NotCorrectIdException e){
            e.printStackTrace();
        }
        return null;
	}

	public ArrayList<CreditCard> findAllCreditCardsByClientId(String pClientLogin){
	    ArrayList<CreditCard> creditCards = new ArrayList<>();
        CreditCard creditCardBean;
        Account accountBean;
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement ptmt = connection.prepareStatement(SQL_FIND_ALL)) {
            ptmt.setString(1,pClientLogin);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                creditCardBean = new CreditCard();
                accountBean = new Account();
                creditCardBean.setId(rs.getString(1));
                creditCardBean.setClientLogin(rs.getString(2));
                creditCardBean.setPassword(rs.getString(3));
                accountBean.setMoney(rs.getDouble(4));
                accountBean.setBlocked(rs.getBoolean(5));
                creditCardBean.setAccount(accountBean);
                creditCards.add(creditCardBean);
                System.out.println("CreditCard:" + creditCardBean.toString());
            }
            return creditCards;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NotCorrectPasswordException e){
            e.printStackTrace();
        } catch (NotCorrectIdException e){
            e.printStackTrace();
        }
        return null;
    }

	/* (non-Javadoc)
	 * @see by.training.nc.dev5.dao.TrainingDAO#insertTraining(by.training.nc.dev5.bean.Training)
	 */
	public int insertCreditCard(CreditCard pCreditCard) {
        int success = 0;
        try(Connection connection = MySQLDAOFactory.getConnection();
            PreparedStatement ptmt = connection.prepareStatement(SQL_INSERT)){
            ptmt.setString(1,pCreditCard.getId());
            ptmt.setString(2,pCreditCard.getClientLogin());
            ptmt.setDouble(3,pCreditCard.getAccount().getMoney());
            ptmt.setBoolean(4,pCreditCard.getAccount().isBlocked());
            ptmt.setString(5,pCreditCard.getPassword());
            success = ptmt.executeUpdate();
        }catch (SQLException ex){
            logger.error(ex.getMessage());
        }
        return success;
	}

	/* (non-Javadoc)
	 * @see by.training.nc.dev5.dao.TrainingDAO#selectTrainings()
	 */
	public Collection<CreditCard> selectCreditCards() {
        try {
            List<CreditCard> creditCards = new ArrayList<CreditCard>();
            CreditCard creditCardBean;
            Account accountBean;
            Connection connection = MySQLDAOFactory.getConnection();
            PreparedStatement ptmt = connection.prepareStatement(SQL_SELECT);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                creditCardBean = new CreditCard();
                accountBean = new Account();
                creditCardBean.setId(rs.getString(1));
                creditCardBean.setClientLogin(rs.getString(2));
                creditCardBean.setPassword(rs.getString(5));
                accountBean.setMoney(rs.getDouble(3));
                accountBean.setBlocked(rs.getBoolean(4));
                creditCardBean.setAccount(accountBean);
                creditCards.add(creditCardBean);
                logger.debug("CreditCard:" + creditCardBean.toString());
            }
            return creditCards;
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            return Collections.emptyList();
        } catch (NotCorrectIdException ex){
            logger.error(ex.getMessage());
            return Collections.emptyList();
        } catch (NotCorrectPasswordException ex){
            logger.error(ex.getMessage());
            return Collections.emptyList();
        }
	}

	/* (non-Javadoc)
	 * @see by.training.nc.dev5.dao.TrainingDAO#updateTraining(java.lang.String)
	 */
	public boolean updateCreditCard(CreditCard pCreditCard) {
        int success = 0;
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement ptmt = connection.prepareStatement(SQL_UPDATE)) {
            ptmt.setString(1, pCreditCard.getClientLogin());
            ptmt.setDouble(2, pCreditCard.getAccount().getMoney());
            ptmt.setBoolean(3,pCreditCard.getAccount().isBlocked());
            ptmt.setString(4, pCreditCard.getPassword());
            ptmt.setString(5, pCreditCard.getId());
            success = ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (success > 0);
	}

}
