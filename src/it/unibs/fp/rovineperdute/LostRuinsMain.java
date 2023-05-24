package it.unibs.fp.rovineperdute;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import static it.unibs.fp.rovineperdute.UserInterface.*;

public class LostRuinsMain {
    private static ArrayList<City> cities = new ArrayList<>();
    private static AdjacencyMatrix matrix = new MatrixTeamMetztli(200);

    public static void main(String[] args) {

        File map1 = new File("inputFiles/PgAr_Map_5.xml");
        File map2 = new File("inputFiles/PgAr_Map_12.xml");
        File map3 = new File("inputFiles/PgAr_Map_50.xml");
        File map4 = new File("inputFiles/PgAr_Map_200.xml");
        File map5 = new File("inputFiles/PgAr_Map_2000.xml");
        File map6 = new File("inputFiles/PgAr_Map_10000.xml");
        
        cities = ReadWriteXML.readCitiesFile(map4, matrix);

        Scanner scanner = new Scanner(System.in);
        mapGenerationUI(scanner);
        visualizationMenu();



        scanner.close();
    }

}