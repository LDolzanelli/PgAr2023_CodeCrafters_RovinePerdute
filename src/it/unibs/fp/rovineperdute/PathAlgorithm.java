package it.unibs.fp.rovineperdute;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import javax.lang.model.util.ElementScanner14;

import java.util.Arrays;

import java.util.Arrays;

class DijkstraAlgorithm {
    private int vertices;
    private float[][] graph;

    public DijkstraAlgorithm(int vertices, float[][] graph) {
        this.vertices = vertices;
        this.graph = graph;
    }

    public void findShortestPath(int source, int target) {
        float[] distance = new float[vertices];
        int[] previous = new int[vertices];
        boolean[] visited = new boolean[vertices];

        Arrays.fill(distance, Float.MAX_VALUE);
        distance[source] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            int minVertex = findMinDistanceVertex(distance, visited);
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

        printShortestPath(distance, previous, target);
    }


    private int findMinDistanceVertex(float[] distance, boolean[] visited) {
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

    private void printShortestPath(float[] distance, int[] previous, int target) {
        System.out.println("Vertex\tDistance from Source\tPath");

        for (int i = 0; i < vertices; i++) {
            System.out.print(i + "\t\t" + distance[i] + "\t\t");
            printPath(previous, i);
            System.out.println();
        }

        System.out.print("Shortest Path from 0 to " + target + ": ");
        printPath(previous, target);
        System.out.println();
    }

    private void printPath(int[] previous, int vertex) {
        if (vertex == 0) {
            System.out.print("0");
            return;
        }

        printPath(previous, previous[vertex]);
        System.out.print(" -> " + vertex);
    }

}
