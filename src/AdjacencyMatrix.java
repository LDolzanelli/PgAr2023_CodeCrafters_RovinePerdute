import java.util.ArrayList;
public abstract class AdjacencyMatrix {
    private int size;
    private double[][] matrix;

    public AdjacencyMatrix(int size) {
        this.size = size;
        matrix = new double[size][size];
    }

    public void assignLinksBetweenCities(int idCurrentCity, int idLinkedCity) {
        matrix[idCurrentCity][idLinkedCity] = 1;
    }

    abstract double calculateWeight(City cityA, City cityB);

    public void assignWeightToLinks(ArrayList<City> cities) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = calculateWeight(cities.get(i), cities.get(j));
                }
            }
        }
    }




}
