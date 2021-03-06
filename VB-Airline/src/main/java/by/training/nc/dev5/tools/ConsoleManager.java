package by.training.nc.dev5.tools;

import by.training.nc.dev5.model.Brigade;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Valery on 21.03.2017.
 */
public class ConsoleManager {
    public static Scanner readData = new Scanner(System.in);

    public static int readNumberFlight(){
        int number = -1;
        System.out.print("Введите номер рейса: ");
        try {
            number = readData.nextInt();
            ConsoleManager.readData.nextLine();
        }catch (InputMismatchException e){
            e.printStackTrace();
        }

        return number;
    }

    public static Brigade readDataBrigade(){
        Brigade brigade = new Brigade();
        List<String> tmp = new ArrayList<>();
        System.out.println("Введите имена членов лётной бригады: ");
        System.out.print("1 пилот: ");
        tmp.add(readData.nextLine());
        System.out.print("2 пилот: ");
        tmp.add(readData.nextLine());
        brigade.setPilots(tmp);
        System.out.print("Штурман: ");
        brigade.setNavigator(readData.nextLine());
        System.out.print("Радист: ");
        brigade.setRadioman(readData.nextLine());
        tmp = new ArrayList<>();
        System.out.print("1 стюардесса: ");
        tmp.add(readData.nextLine());
        System.out.print("2 стюардесса: ");
        tmp.add(readData.nextLine());
        brigade.setStewardesses(tmp);

        return brigade;
    }

    public static String readStatus(){
        System.out.print("Введите статус рейса: ");
        return readData.nextLine();
    }

    public static String readTimeDispatch(){
        System.out.print("Введите дату и время отпрвки рейса: ");
        return readData.nextLine();
    }
}
