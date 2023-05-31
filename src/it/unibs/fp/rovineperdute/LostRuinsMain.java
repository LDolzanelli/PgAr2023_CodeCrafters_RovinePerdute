package it.unibs.fp.rovineperdute;

import java.io.File;
import java.util.ArrayList;
import java.util.Stack;
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

        // map1 = generateMap(map1File, 5);

        // map2 = generateMap(map2File, 13);

        // map3 = generateMap(map3File, 50);
        /*
         * map4 = generateMap(map4File, 200);
         * map5 = generateMap(map5File, 2000);
         */
        map6 = generateMap(map6File, 10000);

        ArrayList<Integer> path = new ArrayList<Integer>();

        int source = 0;
        int target = 10000 - 1;
        path = PathAlgorithm.findShortestPath(10000, map6.getMatrixMetztli().getMatrix(), source, target);

        for (int i = 0; i < path.size(); i++) {
            System.out.printf("%s -> ", map6.getCities().get(path.get(i)).getName());
        }

        /*
         * for (int i = 0; i < map1.getMatrixMetztli().getMatrix().length; i++) {
         * for (int j = 0; j < map1.getMatrixMetztli().getMatrix().length; j++) {
         * float matrix[][] = map1.getMatrixMetztli().getMatrix();
         * System.out.printf("%10.2f", matrix[i][j]);
         * }
         * System.out.println();
         * }
         * 
         * System.out.println();
         * 
         * for (int i = 0; i < map1.getMatrixTonatiuh().getMatrix().length; i++) {
         * for (int j = 0; j < map1.getMatrixTonatiuh().getMatrix().length; j++) {
         * float matrix[][] = map1.getMatrixTonatiuh().getMatrix();
         * System.out.printf("%10.2f", matrix[i][j]);
         * }
         * System.out.println();
         * }
         * 
         */
    }

    public static Map generateMap(File mapFile, int size) {

        ArrayList<City> cities = new ArrayList<>();
        AdjacencyMatrix matrix = new MatrixTeamMetztli(size);

        cities = ReadWriteXML.readCitiesFile(mapFile, matrix);

        Map map = new Map(cities, matrix.getMatrix());

        return map;
    }

}