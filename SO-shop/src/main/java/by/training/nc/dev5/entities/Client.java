package by.training.nc.dev5.entities;

import java.io.Serializable;

public class Client extends Entity implements Serializable{

    private String login;
    private String password;
    private boolean isInBlackList;

    public Client(int id, String login, String password) {
        super(id);
        this.login = login;
        this.password = password;
        this.isInBlackList = false;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isInBlackList() {
        return isInBlackList;
    }

    public void setInBlackList(boolean inBlackList) {
        isInBlackList = inBlackList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (getId() != client.getId()) return false;
        if (isInBlackList() != client.isInBlackList()) return false;
        if (!getLogin().equals(client.getLogin())) return false;
        return getPassword().equals(client.getPassword());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getLogin().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + (isInBlackList() ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + this.getId() +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", isInBlackList=" + isInBlackList +
                '}';
    }
}
