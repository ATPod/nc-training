package by.training.nc.dev5.entities;

/**
 * Created by AsusPC on 25.03.17.
 */
public class Person {
    protected String name;
    protected int id;
    protected boolean status;
    protected String password;
    protected String login;

    public Person(){
        this.name = null;
        this.id = 0;
        this.login = null;
        this.password = null;
        this.status = false;
    }



    public Person (Person person){
        this.name = person.getName();
        this.id = person.getId();
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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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