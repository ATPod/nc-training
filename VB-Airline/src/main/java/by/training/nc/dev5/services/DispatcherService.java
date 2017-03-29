package by.training.nc.dev5.services;

import by.training.nc.dev5.exception.InputDataException;
import by.training.nc.dev5.model.Brigade;
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

    public Flight addFlight(int number, Brigade brigade, String timeDispatch, String status){
        Flight newFlight = new Flight();
        try {
            newFlight.setNumber(number);
        }catch (InputDataException e){
            System.out.println(e.getMessage());
        }
        newFlight.setBrigade(brigade);
        newFlight.setTimeDispatch(timeDispatch);
        newFlight.setStatus(status);

        return newFlight;
    }
}
