package it.unibs.fp.rovineperdute;

import java.util.Scanner;

import static it.unibs.fp.rovineperdute.UserInterface.*;

public class LostRuinsMain {
    public static void main(String[] args) {

        //All the maps are loaded in an array
        Map[] maps = new Map[6];
        final String[] MAPS_FILE_NAME = {"Routes_Map_5", "Routes_Map_12", "Routes_Map_50", "Routes_Map_200", "Routes_Map_2000", "Routes_Map_10000"};



        maps = MapGenerator.generateMaps();

        for ( int i = 0; i < maps.length; i++)
        {
            WriteXML.writeShortestPath(maps[i], MAPS_FILE_NAME[i]);
        }

        Scanner scanner = new Scanner(System.in);
        mapGenerationUI(scanner);
        visualizationMenu(maps);

        scanner.close();
    }


}