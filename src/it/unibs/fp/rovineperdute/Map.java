package it.unibs.fp.rovineperdute;

import java.util.ArrayList;

public class Map {

    private ArrayList<City> cities;
    private MatrixTeamMetztli matrixMetztli;
    private MatrixTeamTonatiuh matrixTonatiuh;
    private ArrayList<Integer> shortestPathMetztli;
    private ArrayList<Integer> shortestPathTonatiuh;
    private float costTonatiuh;
    private float costMetztli;

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

        //Copy the links matrix (Initialized while reading the file) into the matrixs of the teams
        matrixMetztli.copyLinksBetweenCities(matrixLinks);
        matrixTonatiuh.copyLinksBetweenCities(matrixLinks);

        //Assign the weights by adding the distance between the cities that have links
        matrixMetztli.assignWeightToLinks(cities);
        matrixTonatiuh.assignWeightToLinks(cities);

        //find the shortest path for each team
        shortestPathMetztli = PathAlgorithm.findShortestPath(cities.size(), matrixMetztli.getMatrix());
        shortestPathTonatiuh = PathAlgorithm.findShortestPath(cities.size(), matrixTonatiuh.getMatrix());

        //calculate the cost of each shortest pathes 
        costMetztli = calcuateCostMetztli();
        costTonatiuh = calculateCostTonatiuh();
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

    public ArrayList<Integer> getShortestPathMetztli() {
        return shortestPathMetztli;
    }

    public ArrayList<Integer> getShortestPathTonatiuh() {
        return shortestPathTonatiuh;
    }

    public float getCostMetztli() {
        return costMetztli;
    }   

    public float getCostTonatiuh() {
        return costTonatiuh;
    }

    
/**
 * Shows the shortest path of the current Map object according to the Metztli vehicle
 */
    public void showShortestPathMetztli() {

        for (int i : shortestPathMetztli) {
            System.out.printf("%d: %s", i, cities.get(i).getName());
            System.out.println();
        }
    }

/**
 * Shows the shortest path of the current Map object according to the Tonatiuh vehicle
 */
    public void showShortestPathTonatiuh() {
        for (int i : shortestPathTonatiuh) {
            System.out.printf("%d: %s", i, cities.get(i).getName());
            System.out.println();
        }
    }

    /**
     * Calculate the total cost of the Metzli's path by adding the distance between the cities
     * @return the cost of the Metzli's path
    */

    public float calcuateCostMetztli() {

        float costMetztli = 0;
        for (int i = 0; i < shortestPathMetztli.size() - 1; i++) {

            costMetztli += matrixMetztli.getMatrix()[shortestPathMetztli.get(i)][shortestPathMetztli.get(i + 1)];
        }

        return costMetztli;
    }

    /**
     * Calculate the total cost of the Tonatiuh's path by adding the distance between the cities
     * @return the cost of the Tonatiuh's path
    */

    public float calculateCostTonatiuh() {

        float costTonatiuh = 0;
        for (int i = 0; i < shortestPathTonatiuh.size() - 1; i++) {

            costTonatiuh += matrixTonatiuh.getMatrix()[shortestPathTonatiuh.get(i)][shortestPathTonatiuh.get(i + 1)];
        }

        return costTonatiuh;
    }

}
