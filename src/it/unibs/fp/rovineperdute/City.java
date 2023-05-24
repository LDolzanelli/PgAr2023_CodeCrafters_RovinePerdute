package it.unibs.fp.rovineperdute;

public class City {
    private String name;
    private Coordinates coordinates;
    private int idNumber;

    
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
}
