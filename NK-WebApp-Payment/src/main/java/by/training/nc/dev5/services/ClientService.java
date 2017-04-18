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

    private static boolean isIdRight(String id1, String id2){
        if(id1.equals(id2)){
            return true;
        }
        else return false;
    }

    private static String generatePath(String id){
        String path = new String();
        path += "src\\main\\resources\\"+id+".out";
        return path;
    }

    public static void addCreditCard (Client client,CreditCard creditcard) {
        ArrayList<CreditCard> list = client.getList();
        list.add(creditcard);
        client.setList(list);
    }

    public static void creditCardOperation (Client client,String id,String password,int flag) {
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

    public static void moneyOperation (Client client,String id,String password,double money,int flag){
        for (int i = 0; i < client.getList().size(); i++) {
            if (isIdRight(client.getList().get(i).getId(), id)) {
                CreditCardService.moneyOperation(client.getList().get(i),password, money,flag);
            }
        }
    }

    public static void serializeOperation(Client client,String id, String password,int flag)throws Exception{
        for (int i = 0; i < client.getList().size(); i++) {
            if (isIdRight(client.getList().get(i).getId(), id)) {
                CreditCardService.serializeOperation(client.getList().get(i),password,
                        ClientService.generatePath(client.getList().get(i).getId()),flag);
            }
        }
    }
}
