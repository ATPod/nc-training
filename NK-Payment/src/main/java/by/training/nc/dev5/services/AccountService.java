package by.training.nc.dev5.services;

import by.training.nc.dev5.Serialization.Serialization;
import by.training.nc.dev5.classes.Account;

/**
 * Created by AsusPC on 25.03.17.
 * This class describes interaction with account
 * @author NK
 * @version 1.0
 */
public class AccountService {

    /**
     * describes payment from account
     * @param account
     * @param money         -how much money
     */
    public static void payment(Account account,double money) {
        account.setMoney(account.getMoney() - money);
    }

    /**
     * describes refiling account
     * @param account
     * @param money         -how much money
     */
    public static void refill(Account account,double money) {
        account.setMoney(account.getMoney() + money);
    }

    /**
     * prints account status
     * @param account
     */
    public static void viewAccount(Account account){
        if(account.isBlocked()){
            System.out.println("Account is blocked");
        }else {
            System.out.println("Account is active");
        }
        System.out.println("money = " + account.getMoney());

    }

    /**
     * serialize object
     * @param account
     * @param path              -path to file
     */
    public static void serialize(Account account,String path){
        if(Serialization.serialization(account,path)){

        }else{

        }
    }
}
