package by.training.nc.dev5.services;

import by.training.nc.dev5.dao.CreditCardMySQLDAO;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;
import by.training.nc.dev5.entities.Account;
import by.training.nc.dev5.entities.Person;
import by.training.nc.dev5.exceptions.NotCorrectIdException;
import by.training.nc.dev5.exceptions.NotCorrectPasswordException;
import by.training.nc.dev5.tools.Serialization;
import by.training.nc.dev5.entities.CreditCard;

import java.io.*;
import java.util.ArrayList;

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
                creditcard = Serialization.deserialization(path);
            }catch(InvalidObjectException e){
                e.printStackTrace();
            }
        }
    }

    public static String moneyOperation(String id,String password, double money,int flag){
        CreditCardMySQLDAO creditCardMySQLDAO = new CreditCardMySQLDAO();
        CreditCard creditCard = new CreditCard(creditCardMySQLDAO.findCreditCard(id));
        if (creditCard != null) {
            if(creditCard.getPassword().equals(password) && !creditCard.getAccount().isBlocked()) {
                switch (flag) {
                    case 1:
                        creditCard.getAccount().setMoney(creditCard.getAccount().getMoney() + money);
                        break;
                    case 2:
                        if(creditCard.getAccount().getMoney() >= money)
                            creditCard.getAccount().setMoney(creditCard.getAccount().getMoney() - money);
                        else return "not enough money";
                        break;
                    default:
                        break;
                }
                creditCardMySQLDAO.updateCreditCard(creditCard);
                return null;
            }
            else return "invalid password or account is blocked";
        }
        return "no succh credit cards";
    }

    public static void creditCardOperation(CreditCard creditcard,String password,int flag){
        if(isPasswordRight(creditcard,password) && creditcard.getAccount().isBlocked() != true) {
            switch (flag) {
                case 1:
                    creditcard.getAccount().setBlocked(true);
                    break;
                case 2:
                   CreditCardService.viewCreditCard(creditcard);
                    break;
            }
        }
    }

    public static void serializeOperation(CreditCard creditcard,String password,String path,int flag)throws Exception{
        if(isPasswordRight(creditcard,password) && creditcard.getAccount().isBlocked() != true) {
            switch (flag) {
                case 1:
                    Serialization.serialization(creditcard,path);
                    break;
                case 2:
                    CreditCardService.deserialize(creditcard,password,path);
                    break;
            }
        }
    }

    public static String blockCreditCard(String id){
        CreditCardMySQLDAO creditCardMySQLDAO = new CreditCardMySQLDAO();
        CreditCard creditCard = creditCardMySQLDAO.findCreditCard(id);
        if(creditCard != null) {
            creditCard.getAccount().setBlocked(true);
            creditCardMySQLDAO.updateCreditCard(creditCard);
            return null;
        }
        else return "no such cards";
    }

    public static void unblockCreditCard(String id){
        CreditCardMySQLDAO creditCardMySQLDAO = new CreditCardMySQLDAO();
        CreditCard creditCard = creditCardMySQLDAO.findCreditCard(id);
        creditCard.getAccount().setBlocked(false);
        creditCardMySQLDAO.updateCreditCard(creditCard);
    }

    public static String deleteCreditCard(String id, Person person){
        CreditCardMySQLDAO creditCardMySQLDAO = new CreditCardMySQLDAO();
        try {
            Account account = new Account(0,false);
            CreditCard creditCard = new CreditCard(id, "1111", account, person.getLogin());
            creditCardMySQLDAO.deleteCreditCard(creditCard);
            return null;
        } catch (NotCorrectIdException e){
            return "invalid id";
        } catch (NotCorrectPasswordException e){
            return "invalid password";
        }
    }

    public static String insertCreditCard(String id, String password,double money, Person person){
        CreditCardMySQLDAO creditCardMySQLDAO = new CreditCardMySQLDAO();
        try {
            Account account = new Account(money,false);
            CreditCard creditCard = new CreditCard(id, password, account , person.getLogin());
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
        list = creditCardMySQLDAO.findAllCreditCardsByClientId(person.getLogin());
        return list;
    }

    public static void viewCreditCard(CreditCard creditcard){
        System.out.println(creditcard.getAccount().getMoney());
        System.out.println(creditcard.getAccount().isBlocked());
        System.out.println(creditcard.getClientLogin());
        System.out.println(creditcard.getId());
        System.out.println(creditcard.getPassword());
    }
}
