package it.unibs.fp.rovineperdute;

import it.kibo.fp.lib.Menu;
import it.kibo.fp.lib.PrettyStrings;

import java.util.Scanner;

public class UserInterface {
    private static final String ENTER_TO_CONTINUE = "Press Enter to Continue";
    private static final String GENERATING_MAPS = "Generating all the maps";
    private static final String WELCOME = "Welcome to Lost ruins!";
    private static final String VIEW_PATHS = "View the shortest paths?";
    private static final String MAP_CHOICE = "What map do you want to choose?";
    private static final String TEAM_CHOICE = "What team wants to view the shortest path?";
    private static final String[] VISUALIZATION_MENU_VOICES = {"Choose the map to view", "Exit"};
    private static final String[] MAP_CHOICES = {"Map 1", "Map 2", "Map 3", "Map 4", "Map 5", "Map 6", "Exit"};
    private static final String[] TEAM_CHOICES = {"Team Metztli", "Team Tonatiuh"};

/**
 * Welcome message to the program
 * @param scanner to initiate the program (press Enter)
 */
    public static void mapGenerationUI(Scanner scanner) {
        do {
            System.out.println(PrettyStrings.frame(WELCOME, 30, true, true));
            System.out.println(GENERATING_MAPS);
            System.out.println("...");
            System.out.println("...");
            System.out.println(ENTER_TO_CONTINUE);
        } while (!scanner.nextLine().isEmpty());
    }

/**
 * Simple choice to keep viewing maps or exiting the program
 * @param maps the available maps
 */
    public static void visualizationMenu(Map[] maps) {
        Menu menu = new Menu(VIEW_PATHS, VISUALIZATION_MENU_VOICES, false, true, true);
        int choice;

        do {
            choice = menu.choose();

            switch (choice) {
                case 1:
                    visualizationSubMenu(maps);
                    break;

                case 2:
                    break;
            }
        } while(choice != 2);

    }

/**
 * Choosing the desired map
 * @param maps the available maps
 */
    public static void visualizationSubMenu(Map[] maps) {
        Menu menu = new Menu(MAP_CHOICE, MAP_CHOICES, false, true, true);
        int choice = menu.choose();
        if(choice != 7) {
            //choice - 1 to match the index of the chosen map
            teamChoiceSubMenu(maps, choice - 1);
        }
    }

/**
 * Choosing which team wants to view the shortest path
 * @param maps the available maps
 * @param selectedMap the map chosen in the visualizationSubMenu
 */
    public static void teamChoiceSubMenu(Map[] maps, int selectedMap){
        Menu menu = new Menu(TEAM_CHOICE, TEAM_CHOICES, false, true, true);
        int choice = menu.choose();

        switch(choice) {
            case 1:
                maps[selectedMap].showShortestPathMetztli();
                break;

            case 2:
                maps[selectedMap].showShortestPathTonatiuh();
                break;
        }
    }
}
