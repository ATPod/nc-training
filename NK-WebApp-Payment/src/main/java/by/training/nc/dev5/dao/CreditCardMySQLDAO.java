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
import by.training.nc.dev5.dao.util.AbstractDAO;
import by.training.nc.dev5.entities.Account;
import by.training.nc.dev5.entities.CreditCard;
import by.training.nc.dev5.entities.Person;
import by.training.nc.dev5.exceptions.NotCorrectIdException;
import by.training.nc.dev5.exceptions.NotCorrectPasswordException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author nic
 *
 */
public class CreditCardMySQLDAO extends AbstractDAO<String, CreditCard> implements CreditCardDAO {

	private static final String SQL_SELECT = "SELECT crditcard_id, client_id, money," +
            " account_status, pass from creditcard";
	private static final String SQL_INSERT = "INSERT INTO creditcard (crditcard_id, client_id," +
            " money, account_status, pass) values(?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE creditcard SET client_id = ?," +
            "money = ?,account_status = ?,pass = ? WHERE creditcard.crditcard_id = ?";
	private static final String SQL_DELETE = "DELETE FROM creditcard WHERE creditcard.crditcard_id = ?";
	private static final String SQL_FIND = "SELECT * FROM creditcard WHERE crditcard_id = ?";
	private static final String SQL_FIND_ALL = "SELECT * FROM creditcard WHERE client_id = ?";

    // logger for the class
    static Logger logger = LogManager.getLogger(ClientMySQLDAO.class);
    private Class<CreditCard> persistentCreditCard;

    public CreditCardMySQLDAO(){
        super(CreditCard.class);
    }

	public void deleteCreditCard(CreditCard pCreditCard) {
        delete(pCreditCard.getId());
	}


	public CreditCard findCreditCard(String pCreditCardId) {
        return findByKey(pCreditCardId);
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
                creditCardBean.setPassword(rs.getString(5));
                accountBean.setMoney(rs.getDouble(3));
                accountBean.setBlocked(rs.getBoolean(4));
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

	public void insertCreditCard(CreditCard pCreditCard) {
        insert(pCreditCard);
	}


	public Collection<CreditCard> selectCreditCards() {
        return getAll();
	}


	public void updateCreditCard(CreditCard pCreditCard) {
        update(pCreditCard);
	}

}
