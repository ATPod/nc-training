package by.training.nc.dev5;

import by.training.nc.dev5.beans.test.TestContainer;
import by.training.nc.dev5.tools.ConsoleOperations;
import by.training.nc.dev5.tools.InitializationManager;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        InitializationManager.fillTests("Tests");
        //System.out.println(TestContainer.INSTANCE.getTests());
        ConsoleOperations.consoleMenu();
    }
}

