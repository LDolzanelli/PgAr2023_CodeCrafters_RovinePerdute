package it.unibs.fp.rovineperdute;

public class MatrixTeamMetztli extends AdjacencyMatrix {

    public MatrixTeamMetztli(int size) {
        super(size);
    }


    @Override
    public double calculateWeight(City cityA, City cityB) {
        return Math.abs(cityA.getCoordinates().getH() - cityB.getCoordinates().getH());
    }
}
