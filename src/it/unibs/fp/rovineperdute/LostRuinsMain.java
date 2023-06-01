package it.unibs.fp.rovineperdute;

import java.util.Scanner;

import static it.unibs.fp.rovineperdute.UserInterface.*;

public class LostRuinsMain {
    public static void main(String[] args) {

        //All the maps are loaded in an array
        Map[] maps = new Map[6];

        maps = MapGenerator.generateMaps();

        Scanner scanner = new Scanner(System.in);
        mapGenerationUI(scanner);
        visualizationMenu(maps);

        scanner.close();
    }


}