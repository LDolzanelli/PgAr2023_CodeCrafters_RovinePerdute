package it.unibs.fp.rovineperdute;

import java.util.ArrayList;

public class City {
    private String name;
    private Coordinates coordinates;
    private int idNumber;
    private ArrayList<Integer> linkedCitiesID = new ArrayList<>();


    public City(String name, Coordinates coordinates, int idNumber) {
        this.name = name;
        this.coordinates = coordinates;
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public ArrayList<Integer> getLinkedCitiesID() {
        return linkedCitiesID;
    }
}
