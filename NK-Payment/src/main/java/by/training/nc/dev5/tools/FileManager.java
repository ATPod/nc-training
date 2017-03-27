package by.training.nc.dev5.tools;

import by.training.nc.dev5.entities.Account;
import by.training.nc.dev5.entities.Client;
import by.training.nc.dev5.entities.CreditCard;
import by.training.nc.dev5.exceptions.NotCorrectIdException;
import by.training.nc.dev5.exceptions.NotCorrectPasswordException;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by AsusPC on 26.03.17.
 */
public class FileManager {
    private static String getPathForFile(String filename){
        return "src\\main\\resources\\"+filename;
    }

    public static Client fileReader(String filename){
        ArrayList<CreditCard> list = new ArrayList<CreditCard>();
        Client client = null;
        String path = getPathForFile(filename);
        File fr = new File(path);
        Scanner scanner = null;
        try {
            scanner = new Scanner(fr);
        } catch (FileNotFoundException e) {

        }
        while(!scanner.hasNext()) {
            scanner.findWithinHorizon("Name : ",0);
            String clientname = scanner.next();
            scanner.findWithinHorizon("Id : ",0);
            int clientid = scanner.nextInt();
            scanner.findWithinHorizon("Status : ",0);
            boolean clientstatus = scanner.nextBoolean();
            scanner.findWithinHorizon("NumOfCreditCards : ",0);
            int numofcreditcards = scanner.nextInt();
            for(int i = 0;i < numofcreditcards;i++){
                scanner.findWithinHorizon("CreditCardId : ",0);
                int []arrid = new int [16];
                for(int j = 0; j<16;j++){
                    arrid[j] = scanner.nextInt(1);
                }
                scanner.findWithinHorizon("CreditCardPass : ",0);
                int []arrpass = new int [4];
                for(int j = 0; j<4;j++){
                    arrpass[j] = scanner.nextInt(1);
                }
                scanner.findWithinHorizon("AccountMoney : ",0);
                int money = scanner.nextInt();
                scanner.findWithinHorizon("IsBlocked : ",0);
                boolean accountstatus = scanner.nextBoolean();
                Account account = new Account(money,accountstatus);
                try {
                    CreditCard creditcard = new CreditCard(arrid, arrpass, account);
                    list.add(creditcard);
                }catch (NotCorrectPasswordException e){
                    e.printStackTrace();
                }catch (NotCorrectIdException e){
                    e.printStackTrace();
                }
            }
            client = new Client(list,clientname,clientid);
        }
        return client;
    }

    public static void fileWriter(Client client,String filename){
        String path = getPathForFile(filename);
        try{
            PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter(new File(filename))));
            printer.println("Name : " + client.getName());
            printer.println("Id : " + client.getId());
            printer.println("Status : " + client.isStatus());
            printer.println("NumOfCreditCards : " + client.getList().size());
            for(CreditCard creditCard : client.getList()){
                printer.print("CreditCardId : ");
                for(int i = 0;i<creditCard.getId().length;i++){
                    printer.print(creditCard.getId()[i]);
                }
                printer.print("\n");
                printer.print("CreditCardPass : ");
                for(int i = 0;i<creditCard.getPassword().length;i++){
                    printer.print(creditCard.getPassword()[i]);
                }
                printer.print("\n");
                printer.println("AccountMoney : " + creditCard.getAccount().getMoney());
                printer.println("IsBlocked : " + creditCard.getAccount().isBlocked());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
