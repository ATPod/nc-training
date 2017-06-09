package by.training.nc.dev5.controller;

import by.training.nc.dev5.entity.Book;
import by.training.nc.dev5.exception.DbException;
import by.training.nc.dev5.jpaservice.BookService;
import by.training.nc.dev5.jpaservice.LoanService;
import by.training.nc.dev5.util.Attributes;
import by.training.nc.dev5.util.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    BookService bookService;
    @Autowired
    LoanService loanService;

    @RequestMapping(value = {"","/all"})
    String getBooks(HttpServletRequest request, Model model){
        try {
            List<Book> books = bookService.selectBooks();
            model.addAttribute(Attributes.BOOKS,books);
            return Pages.BOOKS_PAGE;
        } catch (DbException e) {
            e.printStackTrace();
        }
        return Pages.BOOKS_PAGE;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    String addBook(HttpServletRequest request, @RequestParam("book-title")String title , Model model){
        Book book = new Book();
        book.setTitle(title);
        List<Book> books = Collections.emptyList();
        try {
            bookService.insertBook(book);
            books = bookService.selectBooks();
        } catch (DbException e) {
            e.printStackTrace();
        }
        model.addAttribute(Attributes.BOOKS,books);
        return Pages.BOOKS_PAGE ;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    String deleteBook(HttpServletRequest request, @RequestParam("book-delete-id")int id , Model model){


        List<Book> books = Collections.EMPTY_LIST;
        try {
            loanService.deleteByBook(id);
            bookService.deleteBook(id);
            books = bookService.selectBooks();
        } catch (DbException e) {
            e.printStackTrace();
        }
        model.addAttribute(Attributes.BOOKS,books);
        return Pages.BOOKS_PAGE;
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    String showAddBook(){

        return Pages.ADD_BOOK_PAGE;
    }

}
