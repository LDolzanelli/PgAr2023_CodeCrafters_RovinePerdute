package it.unibs.fp.rovineperdute;

import java.util.ArrayList;
public abstract class AdjacencyMatrix {
    private float[][] matrix;

    public AdjacencyMatrix(int size) {
        matrix = new float[size][size];
    }

    public void assignLinksBetweenCities(int idCurrentCity, int idLinkedCity) {
        matrix[idCurrentCity][idLinkedCity] = 1;
    }

    public void copyLinksBetweenCities(float matrix[][])
    {
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix.length; j++)
            {
                this.matrix[i][j] = matrix[i][j];
            }
        }
    }

    abstract float calculateWeight(City cityA, City cityB);

    public void assignWeightToLinks(ArrayList<City> cities) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = calculateWeight(cities.get(i), cities.get(j));
                }
            }
        }
    }

    public float[][] getMatrix() {
        return matrix;
    }
}
