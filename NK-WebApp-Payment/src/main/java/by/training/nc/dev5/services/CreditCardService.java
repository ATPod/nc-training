package by.training.nc.dev5.services;

import by.training.nc.dev5.commands.user.ShowYourCreditCards;
import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.dao.CreditCardMySQLDAO;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;
import by.training.nc.dev5.entities.Account;
import by.training.nc.dev5.entities.Person;
import by.training.nc.dev5.exceptions.NotCorrectIdException;
import by.training.nc.dev5.exceptions.NotCorrectPasswordException;
import by.training.nc.dev5.tools.Serialization;
import by.training.nc.dev5.entities.CreditCard;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by AsusPC on 25.03.17.
 */
public class CreditCardService {

    private static boolean isPasswordRight(CreditCard creditcard,String password){
        if(creditcard.getPassword().equals(password)){
            return true;
        }
        else return false;
    }

    private static void deserialize(CreditCard creditcard,String password, String path) throws Exception{
        if(isPasswordRight(creditcard,password)) {
            try{
                creditcard.setAccount(Serialization.deserialization(path));
            }catch(InvalidObjectException e){

            }
        }
    }

    public static String moneyOperation(String id,String password, double money,int flag){
        MySQLDAOFactory factory = new MySQLDAOFactory();
        CreditCardMySQLDAO creditCardMySQLDAO = new CreditCardMySQLDAO();
        CreditCard creditCard = new CreditCard(creditCardMySQLDAO.findCreditCard(id));
        if (creditCard != null) {
            if(creditCard.getPassword().equals(password) && !creditCard.getAccount().isBlocked()) {
                switch (flag) {
                    case 1:
                        AccountService.refill(creditCard.getAccount(), money);
                        break;
                    case 2:
                        AccountService.payment(creditCard.getAccount(), money);
                        break;
                    default:
                        break;
                }
                creditCardMySQLDAO.updateCreditCard(creditCard);
                return null;
            }
            else return "not enough money";
        }
        return "invalid password";
    }

    public static void creditCardOperation(CreditCard creditcard,String password,int flag){
        if(isPasswordRight(creditcard,password) && creditcard.getAccount().isBlocked() != true) {
            switch (flag) {
                case 1:
                    creditcard.getAccount().setBlocked(true);
                    break;
                case 2:
                    AccountService.viewAccount(creditcard.getAccount());
                    break;
            }
        }
    }

    public static void serializeOperation(CreditCard creditcard,String password,String path,int flag)throws Exception{
        if(isPasswordRight(creditcard,password) && creditcard.getAccount().isBlocked() != true) {
            switch (flag) {
                case 1:
                    AccountService.serialize(creditcard.getAccount(),path);
                    break;
                case 2:
                    CreditCardService.deserialize(creditcard,password,path);
                    break;
            }
        }
    }

    public static String blockCreditCard(String id,String password){
        MySQLDAOFactory factory = new MySQLDAOFactory();
        CreditCardMySQLDAO creditCardMySQLDAO = new CreditCardMySQLDAO();
        CreditCard creditCard = creditCardMySQLDAO.findCreditCard(id);
        if(creditCard != null) {
            if (creditCard.getPassword().equals(password)) {
                creditCard.getAccount().setBlocked(true);
                creditCardMySQLDAO.updateCreditCard(creditCard);
                return null;
            }
            else return "invalid password";
        }
        else return "no such cards";
    }

    public static void unblockCreditCard(String id){
        MySQLDAOFactory factory = new MySQLDAOFactory();
        CreditCardMySQLDAO creditCardMySQLDAO = new CreditCardMySQLDAO();
        CreditCard creditCard = creditCardMySQLDAO.findCreditCard(id);
        creditCard.getAccount().setBlocked(false);
        creditCardMySQLDAO.updateCreditCard(creditCard);
    }

    public static String deleteCreditCard(String id, String password, Person person){
        MySQLDAOFactory factory = new MySQLDAOFactory();
        CreditCardMySQLDAO creditCardMySQLDAO = new CreditCardMySQLDAO();
        try {
            CreditCard creditCard = new CreditCard(id, password, null, person.getId());
            creditCardMySQLDAO.deleteCreditCard(creditCard);
            return null;
        } catch (NotCorrectIdException e){
            return "invalid id";
        } catch (NotCorrectPasswordException e){
            return "invalid password";
        }
    }

    public static String insertCreditCard(String id, String password,double money, Person person){
        MySQLDAOFactory factory = new MySQLDAOFactory();
        CreditCardMySQLDAO creditCardMySQLDAO = new CreditCardMySQLDAO();
        Account account = new Account(money,false);
        try {
            CreditCard creditCard = new CreditCard(id, password, account, person.getId());
            creditCardMySQLDAO.insertCreditCard(creditCard);
            return null;
        } catch (NotCorrectIdException e){
            return "invalid id";
        } catch (NotCorrectPasswordException e){
            return "invalid password";
        }
    }

    public static ArrayList<CreditCard> showYourCreditCards(Person person){
        MySQLDAOFactory factory = new MySQLDAOFactory();
        CreditCardMySQLDAO creditCardMySQLDAO = new CreditCardMySQLDAO();
        ArrayList<CreditCard> list = new ArrayList<>();
        list = creditCardMySQLDAO.findAllCreditCardsByClientId(person.getId());
        return list;
    }

    public static void viewCreditCard(CreditCard creditcard){
        System.out.println(creditcard.getAccount().getMoney());
        System.out.println(creditcard.getAccount().isBlocked());
        System.out.println(creditcard.getClientId());
        System.out.println(creditcard.getId());
        System.out.println(creditcard.getPassword());
    }
}
