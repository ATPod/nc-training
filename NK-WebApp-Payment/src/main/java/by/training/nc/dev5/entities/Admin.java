package by.training.nc.dev5.entities;

/**
 * Created by AsusPC on 15.03.17.
 */
public class Admin extends Person{
    public Admin (String name,String login,String password) {
        this.login = login;
        this.password = password;
        this.name = name;
        status = true;
    }
    public void unblock(Account account) {
        account.setBlocked(false);
    }
}
