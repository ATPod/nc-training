package model;

import java.io.Serializable;
import java.util.List;


public class Reader implements Serializable, Comparable<Reader> {

    private int id;
    private String name;

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

    public Reader() {

    }

    public Reader(String name) {

        this.name = name;
    }

    public Reader(int id, String name) {

        this.id = id;
        this.name = name;
    }


    @Override
    public int compareTo(Reader o) {

        int result = this.name.compareTo(o.name);
        if (result != 0)
            return result;

        return result;
    }
}
