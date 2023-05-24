package it.unibs.fp.rovineperdute;

import java.util.ArrayList;
import java.util.Scanner;

import static it.unibs.fp.rovineperdute.UserInterface.*;

public class LostRuinsMain {
    private ArrayList<City> cities = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        mapGenerationUI(scanner);
        visualizationMenu();



        scanner.close();
    }

}