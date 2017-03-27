package by.training.nc.dev5;

import by.training.nc.dev5.tools.InitializationManager;

public class App {
    public static void main(String[] args) {
        InitializationManager.readFromFile("Tests");
        InitializationManager.menu();
    }
}

