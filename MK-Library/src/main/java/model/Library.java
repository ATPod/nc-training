package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ASUS on 16.03.2017.
 */
public class Library {

    private  Map<Book,Integer> catalog ;
    private  List<Reader> readers  ;

    public Map<Book, Integer> getCatalog() {
        return catalog;
    }

    public void setCatalog(Map<Book, Integer> catalog) {
        this.catalog = catalog;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    public Library() {
        this.catalog = new TreeMap<>();
        this.readers = new ArrayList<>();  // or TreeSet()

    }

    /*
    static {
        catalog = new TreeMap<>();
        readers = new ArrayList<>();
    }
    */


    int findBook(Book book){

        return catalog.getOrDefault(book,-1);
    }


}
