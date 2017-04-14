package by.training.nc.dev5;

import by.training.nc.dev5.tools.ConsoleOperations;
import by.training.nc.dev5.tools.InitializationManager;

public class App {
    public static void main(String[] args) {
        InitializationManager.fillTests("Tests");
        ConsoleOperations.consoleMenu();
    }
}

