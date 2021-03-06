package by.training.nc.dev5.entities;

/**
 * Created by AsusPC on 25.03.17.
 */
public class Person {
    protected String name;
    protected boolean status;
    protected String password;
    protected String login;

    public Person(){
        this.name = null;
        this.login = null;
        this.password = null;
        this.status = false;
    }

    public Person(String name, String login, String password){
        this.name = name;
        this.login = login;
        this.password = password;
        this.status = false;
    }

    public Person (Person person){
        this.name = person.getName();
        this.login = person.getLogin();
        this.password = person.getPassword();
        this.status = person.isStatus();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
