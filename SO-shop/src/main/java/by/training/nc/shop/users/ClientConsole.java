package by.training.nc.shop.users;

import java.util.Scanner;

public class ClientConsole {

    private static void printMenu(){
        System.out.println("Choose operation:");
        System.out.println("1 - registration");
        System.out.println("2 - update name");
        System.out.println("3 - update password");
        System.out.println("4 - check black list");

        System.out.println("5 - make ordering");
        System.out.println("6 - pay for ordering");

        System.out.println("7 - show all products");
        System.out.println("8 - show all my orderings");

        System.out.println("0 - exit");
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

            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                default:
                    break;
            }
        }
    }
}
