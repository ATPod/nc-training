package by.training.nc.dev5.classes;

/**
 * Created by AsusPC on 15.03.17.
 */
public class Admin extends Person{
    public Admin (String name) {
        this.name = name;
        status = true;
    }
    public void unblock(Account account) {
        account.setBlocked(false);
    }
}
