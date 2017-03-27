package by.training.nc.dev5.services;

import by.training.nc.dev5.exception.InputDataException;
import by.training.nc.dev5.model.Brigade;
import by.training.nc.dev5.model.Flight;
import by.training.nc.dev5.tools.ConsoleManager;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Created by Valery on 20.03.2017.
 */
public class AirlineSevice {

    private final String FILE_INIT_PATH = "src\\main\\java\\by\\" +
                                            "training\\nc\\dev5\\files" +
                                            "\\input\\flightInit.txt";
    private final String MENU_SEPARATOR = "----------------------------------";

    private List<Flight> flights;

    public void init(){
        flights = new ArrayList<>();

        File file = new File(FILE_INIT_PATH);

        try {
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                Brigade brigade = new Brigade();
                List<String> tmp = new ArrayList<>();
                tmp.add(in.readLine());
                tmp.add(in.readLine());
                brigade.setPilots(tmp);
                brigade.setNavigator(in.readLine());
                brigade.setRadioman(in.readLine());
                tmp = new ArrayList<>();
                tmp.add(in.readLine());
                tmp.add(in.readLine());
                brigade.setStewardesses(tmp);

                Flight flight = new Flight();
                flight.setBrigade(brigade);
                flight.setNumber(Integer.parseInt(in.readLine()));
                flight.setTimeDispatch(in.readLine());
                flight.setStatus(in.readLine());
                flights.add(flight);
            } catch (InputDataException e){
                System.out.println(e.getMessage());
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void menu(){
        DispatcherService dispatcher = DispatcherService.getInctance();
        AdministratorService administrator = AdministratorService.getInctance();
        boolean flag = true;

        System.out.println("Airline System");
        System.out.println(MENU_SEPARATOR);

        while(flag){

            System.out.println("Выберете пользоателя");
            System.out.println(MENU_SEPARATOR);
            System.out.println("1. Диспетчер\n2. Администратор");
            System.out.println(MENU_SEPARATOR);
            System.out.println("0. Завершение работы");

            switch (ConsoleManager.readData.nextInt()){
                case 1:
                    boolean dispFlag = true;
                    while (dispFlag){
                        System.out.println(MENU_SEPARATOR);
                        System.out.println("Выберете действие");
                        System.out.println("1. Добаить рейс\n2. Посмотреть список рейсов\n3. Назад");
                        System.out.println(MENU_SEPARATOR);
                        switch (ConsoleManager.readData.nextInt()){
                            case 1:
                                flights.add(dispatcher.addFlight(ConsoleManager.readNumberFlight(),
                                                                 ConsoleManager.readDataBrigade(),
                                                                 ConsoleManager.readTimeDispatch(),
                                                                 ConsoleManager.readStatus()));
                                break;
                            case 2:
                                for(Flight flight:flights){
                                    System.out.println(flight.toString());
                                }
                                break;
                            case 3:
                                dispFlag = false;
                                break;
                            default:
                                System.out.println("Неверный данные. Повторите ввод...");
                                break;
                        }
                    }
                    break;
                case 2:
                    boolean adminFlag = true;
                    while (adminFlag){
                        System.out.println(MENU_SEPARATOR);
                        System.out.println("Все рейсы:");
                        for(Flight flight:flights) { System.out.println(flight.toString()); }
                        System.out.println(MENU_SEPARATOR);
                        System.out.println("Выберете действие");
                        System.out.println("1. Изменить статус рейса\n2. Отменить рейс\n3. Назад");
                        System.out.println(MENU_SEPARATOR);
                        switch (ConsoleManager.readData.nextInt()){
                            case 1:
                                System.out.print("Введите номер рейса: ");
                                try {
                                    administrator.changeStatus(flights, ConsoleManager.readData.nextInt());
                                }catch(InputMismatchException e){
                                    System.out.println("Неверный ввод. Повторите попытку...");
                                }
                                break;
                            case 2:
                                System.out.print("Введите номер рейса: ");
                                try {
                                    administrator.cancelflight(flights, ConsoleManager.readData.nextInt());
                                }catch(InputMismatchException e){
                                    System.out.println("Неверный ввод. Повторите попытку...");
                                }
                                break;
                            case 3:
                                adminFlag = false;
                                break;
                        }
                    }
                    break;
                case 0:
                    System.out.println("Завершение работы");
                    flag = false;
                    break;
                default:
                    System.out.println("Неверный данные. Повторите ввод...");
                    break;
            }

        }
    }

}
