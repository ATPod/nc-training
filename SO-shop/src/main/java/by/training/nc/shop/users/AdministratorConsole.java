package by.training.nc.shop.users;

import by.training.nc.shop.exceptions.IdRepeatException;
import by.training.nc.shop.exceptions.NotFoundException;
import by.training.nc.shop.services.ProductService;
import by.training.nc.shop.utils.DataKeeper;

import java.io.IOException;
import java.util.Scanner;

public class AdministratorConsole {

    private static Scanner sc = new Scanner(System.in);

    private static int getID(){
        System.out.print("Enter the ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        return id;
    }

    private static void addProduct() throws IdRepeatException{
        int id = getID();
        System.out.print("Enter the title: ");
        String title = sc.nextLine();
        System.out.print("Enter the price: ");
        int price = sc.nextInt();
        sc.nextLine();
        ProductService.addProduct(id, title, price);
        System.out.println("DONE!");
    }

    private static void removeProduct() throws NotFoundException{
        int id = getID();
        ProductService.removeProduct(id);
        System.out.println("DONE!");
    }

    private static void printMenu(){
        System.out.println("Choose operation:");
        System.out.println("1 - add product to catalog");
        System.out.println("2 - remove product from catalog");
        System.out.println("3 - update product in catalog");

        System.out.println("4 - add client to black list");
        System.out.println("5 - remove client from black list");

        System.out.println("6 - show all products");
        System.out.println("7 - show all clients");
        System.out.println("8 - show all orderings");

        System.out.println("9 - change password");
        System.out.println("10 - change name");

        System.out.println("0 - exit");
    }

    private static void showAllProducts(){
        System.out.println(ProductService.getAllProducts());
    }
    public static void main (String [] args) throws IOException, ClassNotFoundException, IdRepeatException, NotFoundException{
        DataKeeper.initialize();

        System.out.print("Welcome to console for administrator!");

        int choice = -1;

        while (choice != 0){
            printMenu();

            System.out.println("Your choice: ");
            choice = sc.nextInt();
            if (choice < 0 || choice > 10){
                System.out.print("Error! Repeat input!");
            }

            switch (choice){
                case 1:
                    addProduct();
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    showAllProducts();
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                default:
            }
        }

        DataKeeper.saveData();
    }
}
