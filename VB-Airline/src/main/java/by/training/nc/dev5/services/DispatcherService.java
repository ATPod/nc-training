package by.training.nc.dev5.services;

import by.training.nc.dev5.model.Flight;
import by.training.nc.dev5.tools.ConsoleManager;

import java.util.InputMismatchException;

/**
 * Created by Valery on 21.03.2017.
 */
public class DispatcherService {

    private DispatcherService(){};

    private static DispatcherService inctance = null;

    public static DispatcherService getInctance() {
        if(inctance == null)
            return inctance = new DispatcherService();
        return inctance;
    }

    public Flight addFlight(){
        Flight newFlight = new Flight();
        System.out.print("Номер рейса: ");
        try {
            newFlight.setNumber(ConsoleManager.readData.nextInt());
            ConsoleManager.readData.nextLine();
        }catch (InputMismatchException e){
            e.printStackTrace();
        }
        newFlight.setBrigade(ConsoleManager.readDataBrigade());
        System.out.print("Время отправки: ");
        newFlight.setTimeDispatch(ConsoleManager.readData.nextLine());
        System.out.print("Статус: ");
        newFlight.setStatus(ConsoleManager.readData.nextLine());

        return newFlight;
    }
}
