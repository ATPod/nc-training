package model;

import java.io.*;
import java.util.*;


public class Library implements Serializable {

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
            sb.append(v.toString()).append(" ").append(k).append("/n"); // not toString( ),but use fields
        });

        bwr.write(sb.toString());
        bwr.flush();
        bwr.close();
    }

    void readReaders(String file) throws IOException {

        /*
        Scanner sc = new Scanner(new FileReader(new File(file)));
        String name ;
        String[] books;
        List<Book> booksList;
        while (sc.hasNext()){
            name = sc.next();
            books = sc.nextLine().split(" ");
            booksList=new ArrayList<>();
            for(String book : books){
                booksList.add(new Book(book));
            }

            this.readers.add(new Reader(name,booksList));

        }
        */

        BufferedReader br = new BufferedReader(new FileReader(new File(file)));
        String reader;
        String[] splitedReader;
        String name;
        List<Book> readerBooks = new ArrayList<>();
        while ((reader = br.readLine()) != null) {

            splitedReader = reader.split(" ");
            name = splitedReader[0];
            for (int i = 1; i < splitedReader.length; ++i) {
                readerBooks.add(new Book(splitedReader[i]));
            }
            this.readers.add(new Reader(name, readerBooks));
        }

        br.close();
    }

    void readCatalog(String file) throws IOException {

        Scanner sc = new Scanner(new FileReader(new File(file)));
        String title;
        int amount;
        Book book;
        while (sc.hasNext()) {

            title = sc.next();
            amount = sc.nextInt();
            book = new Book(title);
            this.catalog.put(book, amount);
        }
    }

    public static Library loadPersonDataFromFile(File file) throws IOException, ClassNotFoundException {

        Library library = null;
        FileReader fr = new FileReader(file);
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream oin = new ObjectInputStream(fis);
        library = (Library) oin.readObject();
        return library;
    }

    public static void savePersonDataToFile(File file, Library library) throws IOException {

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(library);
        oos.flush();
    }

}
