package by.training.nc.dev5.entities;

import java.util.ArrayList;

/**
 * Created by AsusPC on 15.03.17.
 */
public class Client extends Person {
    protected ArrayList<CreditCard> list;

    public Client(){
        list = new ArrayList<CreditCard>();
        name = "";
        status = false;
        id = 0;
    }

    public Client(ArrayList<CreditCard> list,String name,int id) {
        this.id = id;
        this.list = list;
        this.name = name;
        status = false;
    }

    public Client(int id,String name,String login,String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        status = false;
    }

    public Client(String name,String login,String password) {
        this.id = 0;
        this.name = name;
        this.login = login;
        this.password = password;
        status = false;
    }

    public Client (Client client) {
        this.list = client.getList();
        this.name = client.getName();
        status = false;
    }

    public ArrayList<CreditCard> getList() {
        return list;
    }

    public void setList(ArrayList<CreditCard> list) {
        this.list = list;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + name.hashCode();
        result = prime * result + list.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if(!super.equals(obj)) return false;
        Client client = (Client) obj;
        return (this.name == client.getName() && this.list == client.getList());
    }

    @Override
    public String toString() {
        return "Client{ name = " + name + ",id = "+id+"status = "+status+'}';
    }
}
