package it.unibs.fp.rovineperdute;

import java.util.ArrayList;
import java.util.Arrays;

public class PathAlgorithm {

    public PathAlgorithm() {

    }

    public static ArrayList<Integer> findShortestPath(int vertices, float[][] graph, int source, int target) {
        float[] distance = new float[vertices];
        int[] previous = new int[vertices];
        boolean[] visited = new boolean[vertices];
        ArrayList<Integer> path = new ArrayList<Integer>();

        Arrays.fill(distance, Float.MAX_VALUE);
        distance[source] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            int minVertex = findMinDistanceVertex(distance, visited, vertices);
            visited[minVertex] = true;

            for (int j = 0; j < vertices; j++) {
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

    private static int findMinDistanceVertex(float[] distance, boolean[] visited, int vertices) {
        float minDistance = Float.MAX_VALUE;
        int minVertex = -1;

        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minVertex = i;
            }
        }

        return minVertex;
    
    }
}
