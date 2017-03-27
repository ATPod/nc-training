package by.training.nc.dev5.ui;

import by.training.nc.dev5.service.LibraryService;

import java.util.Scanner;


public class UIStarter {

    private LibraryService libraryService;

    public void setLibraryService(LibraryService libraryService) {
        this.libraryService = libraryService;
    }



    public static void main(String[] args) {

        UIStarter ui = new UIStarter();

        Scanner sc = new Scanner(System.in);
        int choose = 0;

        while (true){

            switch (choose){
                case 1:

                    //by.training.nc.dev5.ui.setLibraryService();

                    break;
            }
        }
    }


}
