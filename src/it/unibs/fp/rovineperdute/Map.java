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

    public ArrayList<Integer> getShortestPathMetztli() {
        return shortestPathMetztli;
    }

    public ArrayList<Integer> getShortestPathTonatiuh() {
        return shortestPathTonatiuh;
    }

    public void showShortestPathMetztli() {

        for (int i : shortestPathMetztli) {
            System.out.printf("%d: %s", i, cities.get(i).getName());
            System.out.println();
        }
    }

    public void showShortestPathTonatiuh() {
        for (int i : shortestPathTonatiuh) {
            System.out.printf("%d: %s", i, cities.get(i).getName());
            System.out.println();
        }
    }

    public float getCostMetztli() {

        costMetztli = 0;
        for (int i= 0 ; i< shortestPathMetztli.size() - 1 ; i++) {

            costMetztli += matrixMetztli.getMatrix()[shortestPathMetztli.get(i)][shortestPathMetztli.get(i+1)];
        }

        return costMetztli;
    }

    public float getCostTonatiuh() {

        costTonatiuh = 0;
        for (int i= 0 ; i< shortestPathTonatiuh.size() - 1 ; i++) {

            costTonatiuh += matrixTonatiuh.getMatrix()[shortestPathTonatiuh.get(i)][shortestPathTonatiuh.get(i+1)];
        }

        return costTonatiuh;
    }

}
