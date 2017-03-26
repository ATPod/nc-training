package by.training.nc.dev5.classes;

import java.util.ArrayList;

/**
 * Created by AsusPC on 25.03.17.
 */
public class Person {
    protected String name;
    protected int id;
    protected boolean status;

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
}
