package by.training.nc.shop.utils;

import by.training.nc.shop.entities.Administrator;
import by.training.nc.shop.entities.Client;
import by.training.nc.shop.entities.Ordering;
import by.training.nc.shop.entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataKeeper {

    public static List <Product> products;
    public static List <Client> clients;
    public static List <Ordering> orderings;
    public static List <Administrator> administrators;

    public static void initialize() throws IOException, ClassNotFoundException{

        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("clients.dat"));
            clients = (List<Client>) ois.readObject();
            ois.close();
        }
        catch (EOFException ex){
            clients = new ArrayList<Client>();
        }

        try {
            ois = new ObjectInputStream(new FileInputStream("products.dat"));
            products = (List<Product>) ois.readObject();
            ois.close();
        }
        catch (EOFException ex){
            products = new ArrayList<Product>();
        }

        try {
            ois = new ObjectInputStream(new FileInputStream("orderings.dat"));
            orderings = (List<Ordering>) ois.readObject();
        }
        catch (EOFException ex){
            orderings = new ArrayList<Ordering>();
        }

        try {
            ois = new ObjectInputStream(new FileInputStream("administrators.dat"));
            administrators = (List<Administrator>) ois.readObject();
            ois.close();
        }
        catch (EOFException ex){
            administrators = new ArrayList<Administrator>();
        }
    }

    public static void saveData() throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("clients.dat"));
        oos.writeObject(clients);
        oos.close();

        oos = new ObjectOutputStream(new FileOutputStream("products.dat"));
        oos.writeObject(products);
        oos.close();

        oos = new ObjectOutputStream(new FileOutputStream("orderings.dat"));
        oos.writeObject(orderings);
        oos.close();

        oos = new ObjectOutputStream(new FileOutputStream("administrators.dat"));
        oos.writeObject(administrators);
        oos.close();
    }

}
