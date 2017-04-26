package by.training.nc.dev5.model;

import java.io.Serializable;


public class User implements Serializable, Comparable<User> {


    private int id;
    //private String type;
    private String name;

    @Override
    public String toString() {
        return  name;
    }

    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    public User(int id, String name) {

        this.id = id;
        this.name = name;
    }

    public User(String name,String password) {

        this.id = (int)(Math.random()*10000000);
        this.name = name;
        this.password=password;
    }

    @Override
    public int compareTo(User o) {

        int result = this.name.compareTo(o.name);
        if (result != 0)
            return result;

        return result;
    }


}
