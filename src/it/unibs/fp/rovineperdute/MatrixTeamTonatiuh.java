package it.unibs.fp.rovineperdute;

public class MatrixTeamTonatiuh extends AdjacencyMatrix {

    public MatrixTeamTonatiuh(int size) {
        super(size);
    }

/**
 * The weight is calculated according to the X and Y coordinates, does not consider the change in height
 */
    @Override
    public float calculateWeight(City cityA, City cityB) {
        double weightX = Math.pow(cityA.getCoordinates().getX() - cityB.getCoordinates().getX(), 2);
        double weightY = Math.pow(cityA.getCoordinates().getY() - cityB.getCoordinates().getY(), 2);

        return (float)Math.sqrt(weightX + weightY);
    }

}