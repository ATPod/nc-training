package model;

import java.io.*;
import java.util.*;

/**
 * Created by ASUS on 16.03.2017.
 */
public class Library {

    private Map<Book, Integer> catalog;
    private List<Reader> readers;

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


    int findBook(Book book) {

        return catalog.getOrDefault(book, -1);
    }

    void writeReaders(String file) throws IOException {

        BufferedWriter bwr = new BufferedWriter(new FileWriter(new File(file)));
        StringBuilder sb = new StringBuilder();

        this.readers.forEach((e) -> {
            sb.append(e.toString()).append("/n");
        });

        bwr.write(sb.toString());
        bwr.flush();
        bwr.close();
    }

    void writeCatalog(String file) throws IOException {

        BufferedWriter bwr = new BufferedWriter(new FileWriter(new File(file)));
        StringBuilder sb = new StringBuilder();

        this.catalog.forEach((v, k) -> {
            sb.append(v.toString()).append(" ").append(k).append("/n");
        });

        bwr.write(sb.toString()) ;
        bwr.flush();
        bwr.close();
    }

    void readReaders(String file) throws IOException {

        //Scanner sc = new Scanner(new FileReader(new File(file)));

        BufferedReader br = new BufferedReader(new FileReader(new File(file)));
        String reader;
        String[] splitedReader;
        String name ;
        List<Book> readerBooks = new ArrayList<>();
        while ((reader = br.readLine()) != null) {
            splitedReader = reader.split(" ");
            name = splitedReader[0];

            for(int i = 1; i < splitedReader.length ; ++i ){
                readerBooks.add(new Book(splitedReader[i]));
            }
            this.readers.add(new Reader(name, readerBooks ));
        }

    }


}
