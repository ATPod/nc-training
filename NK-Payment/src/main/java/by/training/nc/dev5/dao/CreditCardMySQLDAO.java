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

	private static final String SQL_SELECT = "SELECT crditcard_id, client_id, money," +
            " account_status, pass from creditcard";
	private static final String SQL_INSERT = "INSERT INTO creditcard (crditcard_id, client_id," +
            " money, account_status, pass values(?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE creditcard SET client_id = ?," +
            "money = ?,account_status = ?,pass = ?, WHERE creditcard.crditcard_id = ?";
	private static final String SQL_DELETE = "DELETE FROM creditcard WHERE creditcard.crditcard_id = ?";
	private static final String SQL_FIND = "SELECT * FROM creditcard WHERE crditcard_id = ?";

    // logger for the class
    static Logger logger = LogManager.getLogger(ClientMySQLDAO.class);

    private String convertArrayToString(int [] arr){
        StringBuffer str = null;
        for(int temp : arr){
            str.append(temp-48);
        }
        return str.toString();
    }

    private int[] convertStringToArray(String str){
        int[] arr = new int[str.length()];
        for(int i = 0;i<str.length();i++){
            arr[i] = str.charAt(i)-48;
        }
        return arr;
    }

	public boolean deleteCreditCard(CreditCard pCreditCard) {

        int success = 0;
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement ptmt = connection.prepareStatement(SQL_DELETE)) {
            ptmt.setString(1, convertArrayToString(pCreditCard.getId()));
            success = ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (success > 0);
	}

	/* (non-Javadoc)
	 * @see by.training.nc.dev5.dao.TrainingDAO#findTraining(java.lang.String)
	 */
	public CreditCard findCreditCard(int[] pCreditCardId) {
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement ptmt = connection.prepareStatement(SQL_FIND)) {
            ptmt.setString(1, convertArrayToString(pCreditCardId));
            ResultSet rs = ptmt.executeQuery();
            if(rs != null){
                rs.next();
                CreditCard creditCard = new CreditCard();
                Account account = new Account();
                creditCard.setClientId(rs.getInt("client_id"));
                creditCard.setPassword(convertStringToArray(rs.getString("pass")));
                account.setMoney(rs.getDouble("money"));
                account.setBlocked(rs.getBoolean("account_status"));
                creditCard.setAccount(account);
                return creditCard;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NotCorrectPasswordException e){
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
            ptmt.setString(1,convertArrayToString(pCreditCard.getId()));
            ptmt.setInt(2,pCreditCard.getClientId());
            ptmt.setDouble(3,pCreditCard.getAccount().getMoney());
            ptmt.setBoolean(4,pCreditCard.getAccount().isBlocked());
            ptmt.setString(5,convertArrayToString(pCreditCard.getPassword()));
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
                creditCardBean.setId(convertStringToArray(rs.getString(1)));
                creditCardBean.setClientId(rs.getInt(2));
                creditCardBean.setPassword(convertStringToArray(rs.getString(5)));
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
            ptmt.setInt(1, pCreditCard.getClientId());
            ptmt.setDouble(2, pCreditCard.getAccount().getMoney());
            ptmt.setBoolean(3,pCreditCard.getAccount().isBlocked());
            ptmt.setString(4, convertArrayToString(pCreditCard.getPassword()));
            ptmt.setString(5, convertArrayToString(pCreditCard.getId()));
            success = ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (success > 0);
	}

}
