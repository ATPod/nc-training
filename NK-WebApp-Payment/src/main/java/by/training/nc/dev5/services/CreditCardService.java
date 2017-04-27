package by.training.nc.dev5.services;

import by.training.nc.dev5.tools.Serialization;
import by.training.nc.dev5.entities.CreditCard;

import java.io.*;
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

    public static void moneyOperation(CreditCard creditcard,String password, double money,int flag){
        if(isPasswordRight(creditcard,password) && creditcard.getAccount().isBlocked() != true) {
            switch (flag) {
                case 1:
                    AccountService.refill(creditcard.getAccount(),money);
                    break;
                case 2:
                    AccountService.payment(creditcard.getAccount(),money);
                    break;
                default:

            }
        }
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

    public static void viewCreditCard(CreditCard creditcard){
        System.out.println(creditcard.getAccount().getMoney());
        System.out.println(creditcard.getAccount().isBlocked());
        System.out.println(creditcard.getClientId());
        System.out.println(creditcard.getId());
        System.out.println(creditcard.getPassword());
    }
}
