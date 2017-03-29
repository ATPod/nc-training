package by.training.nc.dev5.users;

import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.services.ClientService;

import java.util.Scanner;

public class ClientConsole {

    private static int id = 1;
    private static Scanner sc = new Scanner(System.in);

    private static void printMenu(){
        System.out.println("Choose operation:");
        System.out.println("1 - registration");
        System.out.println("2 - update login");
        System.out.println("3 - update password");
        System.out.println("4 - check black list");

        System.out.println("5 - make ordering");
        System.out.println("6 - pay for ordering");

        System.out.println("7 - show all products");
        System.out.println("8 - show all my orderings");

        System.out.println("0 - exit");
    }

    private static void registration() throws DAOException{
        System.out.print("Enter the login: ");
        String login = sc.nextLine();
        System.out.print("Enter the password: ");
        String password = sc.nextLine();
        ClientService.addClient(login, password);
        //id = ClientService.findClientByParameters(login, password);
    }

    private static void updateLogin() throws DAOException, NotFoundException{
        System.out.print("Enter the new login: ");
        String login = sc.nextLine();
        ClientService.updateClientLogin(id, login);
    }

    private static void updatePassowrd() throws DAOException, NotFoundException{
        System.out.print("Enter the new password: ");
        String password = sc.nextLine();
        ClientService.updateClientPassword(id, password);
    }

    private static void checkBlackList() throws DAOException, NotFoundException{
        boolean result = ClientService.checkBlackList(id);
        if (result == true){
            System.out.println("You are in black list!");
        }
        else {
            System.out.println("You are NOT in black list.");
        }
    }

    public static void main (String [] args){

        System.out.print("Welcome to console for client!");

        Scanner sc = new Scanner(System.in);

        int choice = -1;

        while (choice != 0){
            printMenu();

            System.out.println("Your choice: ");
            choice = sc.nextInt();
            if (choice < 0 || choice > 8){
                System.out.print("Error! Repeat input!");
            }

            try {
                switch (choice) {
                    case 1:
                        registration();
                        break;
                    case 2:
                        updateLogin();
                        break;
                    case 3:
                        updatePassowrd();
                        break;
                    case 4:
                        checkBlackList();
                        break;
                    /*case 5:
                        makeOrdering();
                        break;
                    case 6:
                        pay();
                        break;
                    case 7:
                        showAllProducts();
                        break;
                    case 8:
                        showMyOrderings();
                        break;*/
                    default:
                        break;
                }
            }
            catch (DAOException |NotFoundException e){
                e.printStackTrace();
            }
        }
    }
}
