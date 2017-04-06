package by.training.nc.dev5.cli.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by F1 on 05.04.2017.
 */
public class ValueReaderUtil {
    private static final String MESSAGE_NO_INPUT = "No input provided";
    private static final String MESSAGE_INVALID_INPUT = "Invalid input";
    private static final String MESSAGE_ENTER_NUMBER = "Enter a valid number";
    private static final String MESSAGE_ENTER_DATE =
            "Enter date in format dd.mm.yyyy";

    public static int readInt(String prompt) {
        Scanner in = new Scanner(System.in);

        System.out.println(prompt);
        System.out.print("> ");

        if (!in.hasNext()) {
            System.out.println(MESSAGE_NO_INPUT);
            System.exit(0);
        }

        while (!in.hasNextLine()) {
            System.out.printf("%s. %s%n> ",
                    MESSAGE_INVALID_INPUT, MESSAGE_ENTER_NUMBER);
        }

        int result = in.nextInt();

        in.nextLine();

        return result;
    }

    public static String readString(String prompt) {
        Scanner in = new Scanner(System.in);

        System.out.println(prompt);
        System.out.print("> ");

        if (!in.hasNextLine()) {
            System.out.println(MESSAGE_NO_INPUT);
            System.exit(0);

        }

        return in.nextLine();
    }

    public static Date readDate(String prompt) {
        Scanner in = new Scanner(System.in);

        System.out.println(prompt);

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        while (true) {
            System.out.println(MESSAGE_ENTER_DATE);
            System.out.print("> ");

            if (!in.hasNextLine()) {
                System.out.printf("%s. ", MESSAGE_NO_INPUT);
                System.exit(0);
            }

            try {
                return dateFormat.parse(in.nextLine());
            } catch (ParseException e) {
                System.out.printf("%s%n",
                        MESSAGE_INVALID_INPUT);
            }
        }
    }

    public static double getDouble(String prompt) {
        return 0;
    }
}
