package it.unibs.fp.rovineperdute;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import static it.unibs.fp.rovineperdute.UserInterface.*;

public class LostRuinsMain {

    private static Map map1;
    private static Map map2;
    private static Map map3;
    private static Map map4;
    private static Map map5;
    private static Map map6;

    public static void main(String[] args) {

        generateMaps();

        Scanner scanner = new Scanner(System.in);
        mapGenerationUI(scanner);
        visualizationMenu();

        scanner.close();
    }

    public static void generateMaps() {
        File map1File = new File("inputFiles/PgAr_Map_5.xml");
        File map2File = new File("inputFiles/PgAr_Map_12.xml");
        File map3File = new File("inputFiles/PgAr_Map_50.xml");
        File map4File = new File("inputFiles/PgAr_Map_200.xml");
        File map5File = new File("inputFiles/PgAr_Map_2000.xml");
        File map6File = new File("inputFiles/PgAr_Map_10000.xml");

    
        map1 = generateMap(map1File, 5);
        map2 = generateMap(map2File, 13);
        map3 = generateMap(map3File, 50);
        map4 = generateMap(map4File, 200);
        map5 = generateMap(map5File, 2000);
        map6 = generateMap(map6File, 10000);


        

    }

    public static Map generateMap(File mapFile, int size) {

        ArrayList<City> cities = new ArrayList<>();
        AdjacencyMatrix matrix = new MatrixTeamMetztli(size);

        cities = ReadWriteXML.readCitiesFile(mapFile, matrix);

        Map map = new Map(cities, matrix.getMatrix());

        return map;
    }

}