import java.util.ArrayList;

public class MatrixTeamTonatiuh extends AdjacencyMatrix {

    public MatrixTeamTonatiuh(int size) {
        super(size);
    }

    public double calculateWeight(City cityA, City cityB) {
        double weightX = Math.pow(cityA.getCoordinates().getX() - cityB.getCoordinates().getX(), 2);
        double weightY = Math.pow(cityA.getCoordinates().getY() - cityB.getCoordinates().getY(), 2);

        return Math.sqrt(weightX + weightY);
    }

}