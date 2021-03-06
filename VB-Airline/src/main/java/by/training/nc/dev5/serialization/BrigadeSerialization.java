package by.training.nc.dev5.serialization;

import by.training.nc.dev5.model.Brigade;

import java.io.*;

/**
 * Created by Valery on 26.03.2017.
 */
public class BrigadeSerialization {
    private final String SERIALIZATION_FILES_PATH = "src\\main\\java\\by\\" +
            "training\\nc\\dev5\\files" +
            "\\output\\";

    public boolean serialization(Brigade brigade, String filename){
        boolean mark = false;
        ObjectOutputStream out = null;
        try{
            FileOutputStream fos = new FileOutputStream(new File(SERIALIZATION_FILES_PATH + filename));
            if(fos != null){
                out = new ObjectOutputStream(fos);
                out.writeObject(brigade);
                mark = true;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NotSerializableException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }

        return mark;
    }

    public Brigade deserialization(String filename) throws InvalidObjectException{
        ObjectInputStream in = null;
        try{
            FileInputStream fis = new FileInputStream(new File(SERIALIZATION_FILES_PATH + filename));
            in = new ObjectInputStream(fis);
            Brigade flight = (Brigade) in.readObject();
            return  flight;
        }  catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        throw new InvalidObjectException("Объект не восстановлен");
    }
}
