package by.training.nc.dev5.services;

import by.training.nc.dev5.model.Flight;
import by.training.nc.dev5.tools.ConsoleManager;

import java.util.List;

/**
 * Created by Valery on 21.03.2017.
 */
public class AdministratorService {
    private AdministratorService(){};

    private static AdministratorService inctance = null;

    public static AdministratorService getInctance() {
        if(inctance == null)
            return inctance = new AdministratorService();
        return inctance;
    }

    public void cancelflight(List<Flight> flights, int number){
        for(Flight flight:flights){
            if(flight.getNumber() == number) {
                flights.remove(flight);
                return;
            }
        }
    }

    public void changeStatus(List<Flight> flights, int number){
        for(Flight flight:flights){
            if(flight.getNumber() == number) {
                flight.setStatus(ConsoleManager.readData.next());
                return;
            }
        }
    }
}
