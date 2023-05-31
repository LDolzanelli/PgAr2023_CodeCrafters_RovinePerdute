package it.unibs.fp.rovineperdute;

import java.util.Scanner;

import static it.unibs.fp.rovineperdute.UserInterface.*;

public class LostRuinsMain {
    public static void main(String[] args) {

        Map[] maps = new Map[6];

        maps = MapGenerator.generateMaps();

        Scanner scanner = new Scanner(System.in);
        mapGenerationUI(scanner);
        visualizationMenu(maps);

        scanner.close();
    }


}