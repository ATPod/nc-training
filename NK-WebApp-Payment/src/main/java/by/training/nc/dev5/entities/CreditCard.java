package by.training.nc.dev5.entities;


import by.training.nc.dev5.exceptions.NotCorrectIdException;
import by.training.nc.dev5.exceptions.NotCorrectPasswordException;


/**
 * Created by AsusPC on 15.03.17.
 */
public class CreditCard {
    private Account account;
    private String id;
    private String password;
    String clientLogin;

    public CreditCard(){
        this.id = new String();
        this.password = new String();
        account = new Account();
        clientLogin = new String();
    }

    public CreditCard(CreditCard creditCard){
        this.id = creditCard.getId();
        this.password = creditCard.getPassword();
        this.account = creditCard.getAccount();
        this.clientLogin = creditCard.getClientLogin();
    }

    public CreditCard(String id,String password,Account account, String clientLogin)
            throws NotCorrectPasswordException, NotCorrectIdException {
        this.id = new String();
        this.password = new String();
        this.account = account;
        this.clientLogin = clientLogin;
        if(id.length() == 16 && password.length() == 4) {
            this.id = id;
            this.password = password;
        }else if(id.length() != 16){
            throw new NotCorrectIdException("Incorrect Id");
        }else throw new NotCorrectPasswordException("Incorrect Pass");
    }

    public String getPassword() {
        return password;
    }

    public Account getAccount() {
        return account;
    }

    public String getId() {
        return id;
    }

    public String getClientLogin() {
        return clientLogin;
    }

    public void setClientLogin(String clientLogin) {
        this.clientLogin = clientLogin;
    }

    public void setPassword(String password) throws NotCorrectPasswordException {
        if(password.length() == 4){
            this.password = password;
        }else throw new NotCorrectPasswordException("Incorrect Pass");

    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setId(String id) throws NotCorrectIdException {
        if(id.length() == 16){
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
                this.account == creditcard.getAccount() && this.clientLogin == creditcard.getClientLogin());
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
        return "CreditCard{id = " + this.id + ",password = " + this.password + "}";
    }
}
