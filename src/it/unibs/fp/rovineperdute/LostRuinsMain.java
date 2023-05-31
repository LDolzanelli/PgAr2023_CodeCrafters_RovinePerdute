package it.unibs.fp.rovineperdute;

import java.util.Scanner;

import static it.unibs.fp.rovineperdute.UserInterface.*;

public class LostRuinsMain {
    public static void main(String[] args) {

        MapGenerator maps = new MapGenerator();
    
        Scanner scanner = new Scanner(System.in);
        mapGenerationUI(scanner);
        visualizationMenu(maps.getMapList());

        scanner.close();
    }


}