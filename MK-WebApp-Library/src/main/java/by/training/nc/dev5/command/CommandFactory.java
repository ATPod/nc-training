package by.training.nc.dev5.command;

import by.training.nc.dev5.command.commandimpl.*;
import by.training.nc.dev5.command.commandimpl.navigation.*;

public class CommandFactory {

    public static Command newInstance(String command){

        switch (command){
            case "login":
                return new LoginCommand();
            //break;
            case "toSignup":
                return new ToSignupCommand();
            case  "toLogin":
                return new ToLoginCommand();
            case "signup":
                return new SignupCommand();
            case "toLogout":
                return new ToLogoutCommand();
            case "logout":
                return new LogoutCommand();
            case "toLoans":
                return new ToLoansCommand();
            case "loans":
                return new LoansCommand();
            case "loan":
                return new LoanCommand();
            case "users":
                return new UsersCommand();
            case "books":
                return new BooksCommand();
            case "book":
                return new BookCommand();
            case "toAddBook":
                return new ToAddBookCommand();
            case "toAddLoan":
                return new ToAddLoanCommand();
        }
        return null;
    }
}
