package by.training.nc.dev5;

import org.apache.log4j.Logger;
import java.util.NoSuchElementException;

/**
 * Starts the application
 *
 * @author varchenko
 * @version 1.0
 *
 */
public class Runner {
    private static final Logger log = Logger.getLogger(Runner.class);
    public static void main(String[] args) {
        try{
            Manager.initialization();
            Manager.mainMenu();
        }
        catch(NoSuchElementException e){
            log.error(e.getMessage(), e);
            log.info("ОШИБКА. Проверьте корректность файлов и перезапустите приложение.");
        }

    }
}
