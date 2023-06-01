package it.unibs.fp.rovineperdute;

public class MatrixTeamMetztli extends AdjacencyMatrix {

    public MatrixTeamMetztli(int size) {
        super(size);
    }

/**
 * The weight is calculated considering the absolute height difference between the cities
 */
    @Override
    public float calculateWeight(City cityA, City cityB) {
        return Math.abs(cityA.getCoordinates().getH() - cityB.getCoordinates().getH());
    }
}
