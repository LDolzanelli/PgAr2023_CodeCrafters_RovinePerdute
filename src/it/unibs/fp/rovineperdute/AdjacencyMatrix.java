package it.unibs.fp.rovineperdute;

import java.util.ArrayList;
public abstract class AdjacencyMatrix {
    private float[][] matrix;

    public AdjacencyMatrix(int size) {
        matrix = new float[size][size];
        }
    

/**
 * In the reading phase of the XML, it creates and adjiacency matrix that indicates the links between citites
 * @param idCurrentCity the city it is reading
 * @param idLinkedCity the links to that city
 */
    public void assignLinksBetweenCities(int idCurrentCity, int idLinkedCity) {
        matrix[idCurrentCity][idLinkedCity] = 1;
    }

/**
 * Creates a copy of the matrix, to assign it to the 2 teams (as they have different weighted values)
 * @param matrix the matrix it is copying
 */
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

/**
 * Abstract method, calculates the weight of the links between the cities using different formulas according to which team uses it
 * @param cityA the starting city
 * @param cityB the connected city
 * @return the weighted value to travel to cityB
 */
    abstract float calculateWeight(City cityA, City cityB);

/**
 * Assigns the calculated weight to the matrix
 * @param cities all the cities in the map
 */
    public void assignWeightToLinks(ArrayList<City> cities) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                //If the cities are linked, the matrix is connected. If the value is 0, the cities are not connected.
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
