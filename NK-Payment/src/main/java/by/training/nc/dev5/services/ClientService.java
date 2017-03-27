package by.training.nc.dev5.services;

import by.training.nc.dev5.entities.Client;
import by.training.nc.dev5.entities.CreditCard;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by AsusPC on 24.03.17.
 */



public class ClientService {

    private static String fileReader(String path)throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        File file = new File(path);
        exists(path);

        try {
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException(file.getName());
        }
    }

    private static boolean isIdRight(int[] id1, int[] id2){
        int count = 0;
        for(int i = 0;i<id1.length;i++){
            if(id1[i]==id2[i]){
                count++;
            }
        }
        if(count == id1.length){
            return true;
        }
        else return false;
    }

    private static String generatePath(int[] id){
        String path = new String();
        path += "src\\main\\resources\\";
        for(int i = 0;i<id.length;i++){
            path += id[i];
        }
        path += ".out";
        return path;
    }

    public static void addCreditCard (Client client,CreditCard creditcard) {
        ArrayList<CreditCard> list = client.getList();
        list.add(creditcard);
        client.setList(list);
    }

    public static void creditCardOperation (Client client,int[] id,int[] password,int flag) {
        for(int i = 0;i<client.getList().size();i++) {
            if(isIdRight(client.getList().get(i).getId(),id)) {
                switch (flag) {
                    case 1:
                    case 2:
                        CreditCardService.creditCardOperation(client.getList().get(i), password, flag);
                    break;
                    case 3:
                        client.getList().remove(i);
                        break;
                    default:

                        break;
                }
            }
        }
    }

    public static void moneyOperation (Client client,int []id, int []password,double money,int flag){
        for (int i = 0; i < client.getList().size(); i++) {
            if (isIdRight(client.getList().get(i).getId(), id)) {
                CreditCardService.moneyOperation(client.getList().get(i),password, money,flag);
            }
        }
    }

    public static void serializeOperation(Client client,int[] id, int[] password,int flag)throws Exception{
        for (int i = 0; i < client.getList().size(); i++) {
            if (isIdRight(client.getList().get(i).getId(), id)) {
                CreditCardService.serializeOperation(client.getList().get(i),password,
                        ClientService.generatePath(client.getList().get(i).getId()),flag);
            }
        }
    }
}
