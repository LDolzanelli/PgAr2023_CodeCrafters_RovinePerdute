package it.unibs.fp.rovineperdute;

import java.util.ArrayList;

public class Map {

    private ArrayList<City> cities;
    private MatrixTeamMetztli matrixMetztli;
    private MatrixTeamTonatiuh matrixTonatiuh;

    public Map(ArrayList<City> cities, float matrixLinks[][])
    {
        this.cities = cities;

        matrixMetztli = new MatrixTeamMetztli(cities.size());
        matrixTonatiuh = new MatrixTeamTonatiuh(cities.size());

        matrixMetztli.copyLinksBetweenCities(matrixLinks);
        matrixTonatiuh.copyLinksBetweenCities(matrixLinks);

        matrixMetztli.assignWeightToLinks(cities);
        matrixTonatiuh.assignWeightToLinks(cities);
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


    
    
}
