package by.training.nc.dev5.model;

import java.io.Serializable;


public class Book implements Serializable, Comparable<Book> {


    private int id;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book(String title) {
        this.title = title;
    }


    public Book() {

    }

    public Book(int id, String title) {

        this.id = id;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        return title.equals(book.title);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + title.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return id + " " + title;
    }

    @Override
    public int compareTo(Book o) {

        int result = Long.compare(id, o.id);
        if (result != 0)
            return result;
        result = this.title.compareTo(o.title);
        if (result != 0)
            return result;

        return result;
    }
}
