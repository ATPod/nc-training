package by.training.nc.dev5;

import by.training.nc.dev5.entities.Client;
import by.training.nc.dev5.entities.CreditCard;
import by.training.nc.dev5.entities.Account;
import by.training.nc.dev5.exceptions.NotCorrectIdException;
import by.training.nc.dev5.exceptions.NotCorrectPasswordException;
import by.training.nc.dev5.services.ClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by AsusPC on 15.03.17.
 */

public class App {
    private static ArrayList<Client> clientlist;
    private static int arrid[],arrpass[];
    static Logger logger = LogManager.getLogger(App.class);
    static Client tempClient;

    public static void getIdAndPass(){
        Scanner in = new Scanner(System.in);
        String temp;
        arrid = new int [16];
        arrpass = new int [4];
        System.out.println("Enter id");
        temp = in.nextLine();
        if(temp.length() == 16){
            for(int i = 0;i<16;i++){
                arrid[i] = Character.getNumericValue(temp.charAt(i));
            }
        }
        System.out.println("Enter password");
        temp = in.nextLine();
        if(temp.length() == 4){
            for(int i = 0;i<4;i++){
                arrpass[i] = Character.getNumericValue(temp.charAt(i));
            }
        }
    }

    public static String getName(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name");
        return in.nextLine();
    }

    public static CreditCard addCreditCard(){
        CreditCard creditcard;
        getIdAndPass();
        Account account = new Account();
        try {
            creditcard = new CreditCard(arrid, arrpass, account,tempClient.getId());
            arrid = null;
            arrpass = null;
            return creditcard;
        }catch (NotCorrectPasswordException e){
            e.printStackTrace();
        }catch (NotCorrectIdException e){
            e.printStackTrace();
        }
        return new CreditCard();
    }

    public static Client addClient(){
        String temp;
        Scanner in = new Scanner(System.in);
        Client client = new Client();
        int count;
        client.setName(getName());
        System.out.println("If u want to add Credit Card enter yes else no");
        temp = in.nextLine();
        if(temp.equals("yes")){
            System.out.println("How many?");
            count = in.nextInt();
            for(int i = 0;i<count;i++){
                ClientService.addCreditCard(client,addCreditCard());
            }
        }else if(temp.equals("no")){
            return client;
        }else {
            System.out.println("Incorrect enter");
        }
        tempClient = client;
        return client;
    }

    public static void refilAccount(){
        Double tempmoney;
        Client client = new Client();
        Scanner in = new Scanner(System.in);
        String temp;
        temp = getName();
        for(int i = 0;i<clientlist.size();i++) {
            if (temp.equals(clientlist.get(i).getName())) {
                client = clientlist.get(i);
            }
        }
        getIdAndPass();
        System.out.println("How much money?");
        tempmoney = in.nextDouble();
        ClientService.moneyOperation(client,arrid,arrpass,tempmoney,1);
        arrid = null;
        arrpass = null;
    }

    public static void makePayment(){
        Double tempmoney;
        Client client = new Client();
        Scanner in = new Scanner(System.in);
        String temp;
        temp = getName();
        for(int i = 0;i<clientlist.size();i++){
            if(temp.equals(clientlist.get(i).getName())){
                client = clientlist.get(i);
            }
        }
        getIdAndPass();
        System.out.println("How much money?");
        tempmoney = in.nextDouble();
        ClientService.moneyOperation(client,arrid,arrpass,tempmoney,2);
        arrid = null;
        arrpass = null;
    }

    public static void viewCreditCard(){
        Client client = new Client();
        String temp;
        temp = getName();
        for(int i = 0;i<clientlist.size();i++){
            if(temp.equals(clientlist.get(i).getName())){
                client = clientlist.get(i);
            }
        }
        getIdAndPass();
        ClientService.creditCardOperation(client,arrid,arrpass,2);
        arrid = null;
        arrpass = null;
    }

    public static void serialize() throws IOException{
        Client client = new Client();
        String temp;
        temp = getName();
        for(int i = 0;i<clientlist.size();i++){
            if(temp.equals(clientlist.get(i).getName())){
                client = clientlist.get(i);
            }
        }
        getIdAndPass();
        try {
            ClientService.serializeOperation(client, arrid, arrpass, 1);
        }catch (Exception e){

        }
        arrid = null;
        arrpass = null;
    }

    public static void deserialize() throws Exception{
        Client client = new Client();
        String temp;
        temp = getName();
        for(int i = 0;i<clientlist.size();i++){
            if(temp.equals(clientlist.get(i).getName())){
                client = clientlist.get(i);
            }
        }
        getIdAndPass();
        try {
            ClientService.serializeOperation(client, arrid, arrpass, 2);
        }catch (Exception e){

        }
        arrid = null;
        arrpass = null;
    }

    public static void block(){
        Client client = new Client();
        String temp;
        temp = getName();
        for(int i = 0;i<clientlist.size();i++){
            if(temp.equals(clientlist.get(i).getName())){
                client = clientlist.get(i);
            }
        }
        getIdAndPass();
        ClientService.creditCardOperation(client,arrid,arrpass,1);
        arrid = null;
        arrpass = null;
    }

    public static void importClientFromFile(){

    }

    public static void main(String []args) throws Exception {
        clientlist = new ArrayList<Client>();
        Scanner in = new Scanner(System.in);
        while(true) {
            switch (in.nextInt()) {
                case 1:
                    clientlist.add(addClient());
                    break;
                case 2:
                    refilAccount();
                    break;
                case 3:
                    makePayment();
                    break;
                case 4:
                    viewCreditCard();
                    break;
                case 5:
                    serialize();
                    break;
                case 6:
                    deserialize();
                    break;
                case 7:
                    block();
                    break;
                case 8:
                    importClientFromFile();
                    break;
                case 9:
                    logger.info("addClient,refilAccount,makePayment,viewCreditCard,serialize,deserialize,end");
                    break;
                case 10:
                    System.exit(0);
            }
        }
    }
}

