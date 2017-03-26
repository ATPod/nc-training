package by.training.nc.dev5.classes;


import by.training.nc.dev5.exceptions.NotCorrectIdException;
import by.training.nc.dev5.exceptions.NotCorrectPasswordException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

/**
 * Created by AsusPC on 15.03.17.
 */
public class CreditCard {
    private Account account;
    private int id[];
    private int password[];

    public CreditCard(){
        this.id = new int [16];
        this.password = new int [4];
        account = new Account();
    }

    public CreditCard(int []id,int []password,Account account) throws NotCorrectPasswordException, NotCorrectIdException {
        this.id = new int [16];
        this.password = new int [4];
        this.account = account;
        if(id.length == 16 && password.length == 4) {
            this.id = id;
            this.password = password;
        }else if(id.length != 16){
            throw new NotCorrectIdException("Incorrect Id");
        }else throw new NotCorrectPasswordException("Incorrect Pass");
    }

    public int[] getPassword() {
        return password;
    }

    public Account getAccount() {
        return account;
    }

    public int[] getId() {
        return id;
    }

    public void setPassword(int[] password) throws NotCorrectPasswordException {
        if(password.length == 4){
            this.password = password;
        }else throw new NotCorrectPasswordException("Incorrect Pass");
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setId(int[] id) throws NotCorrectIdException {
        if(id.length == 16){
            this.id = id;
        }else throw new NotCorrectIdException("Incorrect Id");
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if(!super.equals(obj)) return false;
        CreditCard creditcard = (CreditCard) obj;
        return (this.id == creditcard.getId() && this.password == creditcard.getPassword() &&
                this.account == creditcard.getAccount());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + id.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CreditCard{id = " + Arrays.toString(id) + ",password = " + Arrays.toString(password) + "}";
    }
}
