package Service;

import model.Book;
import model.Library;
import model.Reader;

import java.util.List;


/**
 * Created by ASUS on 16.03.2017.
 */
public class LibaryService {

    private Library library = new Library();


    int getBook (Reader reader, Book book) {

        int result = library.getCatalog().getOrDefault(book, -1);
        if (result == -1 || result == 0) {
            return result;
        } else {
            result = library.getCatalog().compute(book, (k, v) -> --v);
            List<Reader> readers = library.getReaders();
            readers.get(readers.indexOf(reader)).addBook(book);
        }
        return result;
    }

    int findBook(Book book) {

        return library.getCatalog().getOrDefault(book, -1);
    }


}
