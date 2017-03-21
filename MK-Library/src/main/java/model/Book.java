package model;

import java.io.Serializable;


public class Book implements Serializable,Comparable<Book> {

    private String title;

    public Book(String title) {
        this.title = title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        return title != null ? title.equals(book.title) : book.title == null;
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }

    @Override
    public String toString() {
        return  title ;
    }

    @Override
    public int compareTo(Book o) {

        int result = this.title.compareTo(o.title);
        if(result!=0)
            return result;

        return result;
    }
}
