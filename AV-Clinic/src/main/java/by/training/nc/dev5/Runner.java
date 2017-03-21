package by.training.nc.dev5;


import by.training.nc.dev5.tools.Logger;

import java.util.NoSuchElementException;

/**
 * Starts the application
 *
 * @author varchenko
 * @version 1.0
 *
 */
public class Runner {
    public static void main(String[] args) {
        try{
            Manager.initialization();
            Manager.mainMenu();
        }
        catch(NoSuchElementException e){
            Logger.log(e);
            System.out.println("ОШИБКА. Проверьте корректность файлов и перезапустите приложение.");
        }

    }
}
