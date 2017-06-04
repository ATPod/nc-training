package by.training.nc.dev5.tools;

import by.training.nc.dev5.entities.CreditCard;
import sun.util.resources.cldr.ebu.CalendarData_ebu_KE;

import java.io.*;

/**
 * Created by AsusPC on 24.03.17.
 */
public class Serialization implements Serializable {

    public static boolean serialization(CreditCard creditCard, String path){
        boolean result = false;
        File fr = new File(path);
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream(fr);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(creditCard);
            oos.flush();
            oos.close();
            result = true;
        }catch(FileNotFoundException e){

        }catch (NotSerializableException e){

        }catch(IOException e){

        }finally{
            try{
                if(oos != null){
                    oos.close();
                }
            }catch(IOException e){

            }
        }
        return result;
    }

    public static CreditCard deserialization(String path) throws InvalidObjectException{
        File fr = new File(path);
        ObjectInputStream oin = null;
        try {
            FileInputStream fis = new FileInputStream(fr);
            oin = new ObjectInputStream(fis);
            CreditCard creditCard  = (CreditCard) oin.readObject();
            return creditCard;
        }catch (FileNotFoundException e){
            System.out.println("File not found " + e);
        }catch (IOException e) {
            System.out.println("I/O error " + e);
        }catch (ClassNotFoundException e){

        }finally {
            try {
                if (oin != null) {
                    oin.close();
                }
            }catch(IOException e){

            }
        }
        throw new InvalidObjectException("Can't deserialize object");
    }

}
