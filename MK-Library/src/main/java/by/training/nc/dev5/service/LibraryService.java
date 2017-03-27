package by.training.nc.dev5.service;

import by.training.nc.dev5.model.Book;
import by.training.nc.dev5.model.Library;
import by.training.nc.dev5.model.Loan;
import by.training.nc.dev5.model.Reader;

import java.io.*;
import java.util.List;
import java.util.Scanner;


public class LibraryService {

    private Library library;

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }


    public LibraryService() {
        library = new Library();
    }

    public LibraryService(Library library) {
        this.library = library;
    }


    boolean loanBook(Reader reader, Book book) {

        boolean result = (findBook(book) != -1) && (findReader(reader) != 1);

        if (result == false) {
            return result;
        } else {

            this.library.getLoans().add(new Loan()); ////
        }
        return result;
    }

    int findBook(Book book) {

        return library.getBooks().indexOf(book);
    }

    int findReader(Reader reader) {

        return library.getReaders().indexOf(reader);
    }


    void writeReaders(String file) throws IOException {

        BufferedWriter bwr = new BufferedWriter(new FileWriter(new File(file)));
        StringBuilder sb = new StringBuilder();

        this.library.getReaders().forEach((reader) -> {
            sb.append(reader.getId()).append(" ").append(reader.getName()).append("/n");
        });

        bwr.write(sb.toString());
        bwr.flush();
        bwr.close();
    }

    void writeCatalog(String file) throws IOException {

        BufferedWriter bwr = new BufferedWriter(new FileWriter(new File(file)));
        StringBuilder sb = new StringBuilder();

        this.library.getBooks().forEach((book)->{
            sb.append(book.getId()).append(" ").append(book.getTitle()).append("/n");
        });

        bwr.write(sb.toString());
        bwr.flush();
        bwr.close();
    }

    void readReaders(String file) throws IOException {

        Scanner sc = new Scanner(new FileReader(new File(file)));

        int id;
        String name;

        List<Book> booksList;
        while (sc.hasNext()){
            id = sc.nextInt();
            name = sc.next();
            this.library.getReaders().add(new Reader(id,name));
        }

        sc.close();
    }

    void readBooks(String file) throws IOException {

        Scanner sc = new Scanner(new FileReader(new File(file)));
        int id;
        String title;

        while (sc.hasNext()) {
            id = sc.nextInt();
            title = sc.next();
            this.library.getBooks().add(new Book(id,title));

        }
    }

    public Library loadLibraryDataFromFile(File file) throws IOException, ClassNotFoundException {  // переделать

        Library library = null;
        FileReader fr = new FileReader(file);
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream oin = new ObjectInputStream(fis);
        library = (Library) oin.readObject();
        return library;
    }

    public void saveLibraryDataToFile(File file) throws IOException {

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.library);
        oos.flush();
    }


}
