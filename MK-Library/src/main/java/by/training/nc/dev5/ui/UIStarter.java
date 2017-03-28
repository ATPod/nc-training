package by.training.nc.dev5.ui;

import by.training.nc.dev5.dao.BookMySQLDAO;
import by.training.nc.dev5.dao.LoanDAO;
import by.training.nc.dev5.dao.LoanMySQLDAO;
import by.training.nc.dev5.model.Book;
import by.training.nc.dev5.model.LoanView;
import by.training.nc.dev5.service.LibraryService;

import java.util.List;
import java.util.Scanner;


public class UIStarter {

    private LibraryService libraryService;

    public void setLibraryService(LibraryService libraryService) {
        this.libraryService = libraryService;
    }


    public static void main(String[] args) {

        /*
        UIStarter ui = new UIStarter();
        LibraryService ls = new LibraryService();
        ui.setLibraryService(ls);
        */

        BookMySQLDAO bookDAO = new BookMySQLDAO();
        LoanMySQLDAO loanDAO = new LoanMySQLDAO();
        Scanner sc = new Scanner(System.in);

        int choose = 0;

        while (true){

            choose = sc.nextInt();

            switch (choose){
                case 1:
                    System.out.println("Book insertion");
                    bookDAO.insertBook(new Book(111,"War and Piece"));
                    break;

                case 2:
                    System.out.println("Select loans");
                    List<LoanView> lw = (List<LoanView>) loanDAO.selectLoans();
                    lw.forEach(System.out::println);
                    break;
            }
        }
    }

}
