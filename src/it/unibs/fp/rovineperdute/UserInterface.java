package it.unibs.fp.rovineperdute;

import it.kibo.fp.lib.Menu;
import it.kibo.fp.lib.PrettyStrings;

import java.util.Scanner;

public class UserInterface {
    private static final String WELCOME = "Welcome to Lost ruins!";
    private static final String VIEW_PATHS = "View the shortest paths?";
    private static final String MAP_CHOICE = "What map do you want to choose?";
    private static final String[] VISUALIZATION_MENU_VOICES = {"Choose the map to view", "Exit"};
    private static final String[] MAP_CHOICES = {"Map 1", "Map 2", "Map 3", "Map 4", "Map 5", "Exit"};


    public static void mapGenerationUI() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(PrettyStrings.frame(WELCOME, 30, true, true));
            System.out.println("Generating all the maps");

            //GENERATE ALL THE MAPS
            System.out.println("...");
            System.out.println("...");
            System.out.println("Press Enter to Continue");
        } while (!scanner.nextLine().isEmpty());
    }
    public static void visualizationMenu() {
        Menu menu = new Menu(VIEW_PATHS, VISUALIZATION_MENU_VOICES, false, true, true);
        int choice;

        do {
            choice = menu.choose();

            switch (choice) {
                case 1:
                    visualizationSubMenu();
                    break;

                case 2:
                    break;
            }
        } while(choice != 2);

    }
    public static void visualizationSubMenu() {
        Menu menu = new Menu(MAP_CHOICE, MAP_CHOICES, false, true, true);
        int choice = menu.choose();

        switch (choice) {
            case 1:
                //TODO
                break;
            case 2:
                //TODO
                break;
            case 3:
                //TODO
                break;
            case 4:
                //TODO
                break;
            case 5:
                //TODO
                break;
            case 6:
                break;
        }
    }
}
