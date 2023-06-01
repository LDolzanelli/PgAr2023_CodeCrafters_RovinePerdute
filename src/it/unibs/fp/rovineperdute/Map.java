package it.unibs.fp.rovineperdute;

import java.util.ArrayList;

public class Map {

    private ArrayList<City> cities;
    private MatrixTeamMetztli matrixMetztli;
    private MatrixTeamTonatiuh matrixTonatiuh;
    private ArrayList<Integer> shortestPathMetztli;
    private ArrayList<Integer> shortestPathTonatiuh;

/**
 * Each Map contains all the cities loaded from the XML file, their respective weighted matrices indicating the links
 * and the necessary fuel to reach each city, and the shortest path calculated according to the two teams
 * @param cities all the cities that have been loaded from the xml file
 * @param matrixLinks the matrix which indicates the links between the cities
 */
    public Map(ArrayList<City> cities, float matrixLinks[][]) {
        this.cities = cities;

        matrixMetztli = new MatrixTeamMetztli(cities.size());
        matrixTonatiuh = new MatrixTeamTonatiuh(cities.size());

        matrixMetztli.copyLinksBetweenCities(matrixLinks);
        matrixTonatiuh.copyLinksBetweenCities(matrixLinks);

        matrixMetztli.assignWeightToLinks(cities);
        matrixTonatiuh.assignWeightToLinks(cities);

        shortestPathMetztli = PathAlgorithm.findShortestPath(cities.size(), matrixMetztli.getMatrix());
        shortestPathTonatiuh = PathAlgorithm.findShortestPath(cities.size(), matrixTonatiuh.getMatrix());
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public MatrixTeamMetztli getMatrixMetztli() {
        return matrixMetztli;
    }

    public MatrixTeamTonatiuh getMatrixTonatiuh() {
        return matrixTonatiuh;
    }

/**
 * Shows the shortest path of the current Map object according to the Metztli vehicle
 */
    public void showShortestPathMetztli() {
        for(int i : shortestPathMetztli) {
            System.out.printf("%d: %s", i, cities.get(i).getName());
            System.out.println();
        }
    }

/**
 * Shows the shortest path of the current Map object according to the Tonatiuh vehicle
 */
    public void showShortestPathTonatiuh() {
        for(int i : shortestPathTonatiuh) {
            System.out.printf("%d: %s", i, cities.get(i).getName());
            System.out.println();
        }
    }    
    
}
