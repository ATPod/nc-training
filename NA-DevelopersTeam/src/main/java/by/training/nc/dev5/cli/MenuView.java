package by.training.nc.dev5.cli;

import java.util.Collection;
import java.util.Scanner;

/**
 * Created by Nikita on 24.03.2017.
 */
public class MenuView implements Runnable {
    private MenuController menuController;
    private boolean stopped;

    public MenuView(MenuController menuController) {
        this.menuController = menuController;
    }

    public void run() {
        Scanner in = new Scanner(System.in);

        System.out.println("Hello");

        while (!stopped) {
            String query;

            System.out.print("> ");
            if (in.hasNextLine()) {
                query = in.nextLine();
            } else {
                break;
            }

            query = query.trim();
            if (query.length() == 0) {
                continue;
            }

            MenuAction action = menuController.getAction(query);

            if (action == null) {
                if ("help".equals(query)) {
                    showHelpMessage();
                } else if ("exit".equals(query)) {
                    stop();
                } else {
                    showErrorMessage();
                }

                continue;
            }

            action.performAction();
        }

        System.out.println("Goodbye");
    }

    public void stop() {
        stopped = true;
    }

    private void showErrorMessage() {
        System.out.println("Incorrect choice");
    }

    private void showHelpMessage() {
        Collection<String> keys = menuController.getKeys();

        int maxWidth = 0;
        String format;

        for (String key : keys) {
            if (key.length() > maxWidth) {
                maxWidth = key.length();
            }
        }

        format = String.format("%%-%ds\t%%s%%n", maxWidth);

        System.out.printf(format, "help", "show this message");
        System.out.printf(format, "exit", "exit the application");
        for (String key : keys) {
            System.out.printf(format, key,
                    menuController.getAction(key).getDescription());
        }
    }
}
