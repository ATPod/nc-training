package by.training.nc.dev5.classes;

import java.io.IOException;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

/**
 * Created by AsusPC on 15.03.17.
 * This class describes entity <b>Account</b>
 * @author NK
 * @version 1.0
 */
public class Account implements Serializable {
    private double money;
    private boolean blocked;

    /**
     *  Create new object and initialize it
     *  @param money                -account money
     *  @param blocked              -account status
     */
    public Account(double money,boolean blocked) {
        this.money = money;
        this.blocked = blocked;
    }

    /**
     * Create new object and initialize it
     */
    public Account(){
        money = 0;
        blocked = false;
    }

    /**
     * return status
     */
    public boolean isBlocked() {
        return blocked;
    }

    /**
     * return money
     */
    public double getMoney() {
        return money;
    }

    /**
     * @param money             -sets account money
     */
    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * @param blocked             -sets account status
     */
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if(!super.equals(obj)) return false;
        Account account = (Account) obj;
        return (this.money == account.getMoney() && this.blocked == account.isBlocked());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + (int)money;
        return result;
    }

    @Override
    public String toString() {
        StringBuffer sb = null;
        sb.append("Account{money = " + money);
        if(blocked){
            sb.append(", account is blocked}");
        }else{
            sb.append(", account is active}");
        }
            return sb.toString();
    }
}
