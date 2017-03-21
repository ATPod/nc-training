package by.training.nc.dev5;

import by.training.nc.dev5.services.AirlineSevice;

public class App
{
    public static void main( String[] args )
    {
        AirlineSevice mainService = new AirlineSevice();
        mainService.init();
        mainService.menu();
    }
}
