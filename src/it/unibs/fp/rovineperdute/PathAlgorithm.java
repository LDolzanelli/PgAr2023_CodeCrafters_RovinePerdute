package it.unibs.fp.rovineperdute;

import java.util.ArrayList;
import java.util.Arrays;


public class PathAlgorithm {

    public static final int SOURCE = 0;

    public static ArrayList<Integer> findShortestPath(int size, float[][] graph) {
        float[] distance = new float[size];
        int[] previous = new int[size];
        boolean[] visited = new boolean[size];
        ArrayList<Integer> path = new ArrayList<Integer>();

        Arrays.fill(distance, Float.MAX_VALUE);
        distance[SOURCE] = 0;

        for (int i = 0; i < size - 1; i++) {
            int minVertex = findMinDistanceVertex(distance, visited, size);
            visited[minVertex] = true;

            for (int j = 0; j < size; j++) {
                if (!visited[j] && graph[minVertex][j] != 0 && distance[minVertex] != Float.MAX_VALUE) {
                    float newDistance = distance[minVertex] + graph[minVertex][j];
                    if (newDistance < distance[j]) {
                        distance[j] = newDistance;
                        previous[j] = minVertex;
                    }
                }
            }
        }

        int currentCityId = graph.length - 1;
        path.add(currentCityId);

        while (path.get(0) != 0) {
            path.add(0, previous[currentCityId]);
            currentCityId = previous[currentCityId];
        }

        return path;
    }

    private static int findMinDistanceVertex(float[] distance, boolean[] visited, int size) {
        float minDistance = Float.MAX_VALUE;
        int minVertex = -1;

        for (int i = 0; i < size; i++) {
            if (!visited[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minVertex = i;
            }
        }

        return minVertex;
    
    }
}
