package it.unibs.fp.rovineperdute;

import java.util.ArrayList;
import java.util.Arrays;


public class PathAlgorithm {

    //The source of each map is always its first element
    public static final int SOURCE = 0;

/**
 * Calculates the shortest path between the cities (Dijkstra algorithm)
 * @param size the size of the loaded Map/matrix
 * @param matrix the weighted matrix
 * @return the list of the shortest path found from the matrix
 */
    public static ArrayList<Integer> findShortestPath(int size, float[][] matrix) {
        float[] distance = new float[size];
        int[] previousCities = new int[size];
        boolean[] visitedCities = new boolean[size];
        ArrayList<Integer> shortestPath = new ArrayList<Integer>();

        //Initializes the array to the max values for the algorithm to find the initial minimum values
        Arrays.fill(distance, Float.MAX_VALUE);
        distance[SOURCE] = 0;

        for (int i = 0; i < size - 1; i++) {
            int minNode = findMinDistanceNode(distance, visitedCities, size);
            visitedCities[minNode] = true;

            for (int j = 0; j < size; j++) {
                if (!visitedCities[j] && matrix[minNode][j] != 0 && distance[minNode] != Float.MAX_VALUE) {
                    float newDistance = distance[minNode] + matrix[minNode][j];
                    if (newDistance < distance[j]) {
                        distance[j] = newDistance;
                        previousCities[j] = minNode;
                    }
                }
            }
        }

        int currentCityId = matrix.length - 1;
        shortestPath.add(currentCityId);

        while (shortestPath.get(0) != 0) {
            shortestPath.add(0, previousCities[currentCityId]);
            currentCityId = previousCities[currentCityId];
        }

        return shortestPath;
    }

/**
 * Finds the node with the smallest distance (Dijkstra)
 * @param distance all the distances loaded in an array
 * @param visited all the visited cities so far
 * @param size the size of the map/matrix
 * @return the minimum distance found
 */
    private static int findMinDistanceNode(float[] distance, boolean[] visited, int size) {
        float minDistance = Float.MAX_VALUE;
        int minNode = -1;

        for (int i = 0; i < size; i++) {
            if (!visited[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minNode = i;
            }
        }

        return minNode;
    }
}
