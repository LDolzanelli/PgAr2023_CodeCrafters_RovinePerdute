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

        }
        return closestCityId;
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

    public static Stack<Integer> calculatePathDijkstraMetztli(Map map) {
        Stack<Integer> pathDijkstra = new Stack<Integer>();

        ArrayList<City> visitedCities = new ArrayList<City>();
        ArrayList<City> unvisitedCities = new ArrayList<City>();

        ArrayList<Float> shortestDistance = new ArrayList<Float>();
        int[] previousCityId = new int[map.getCities().size()];

        shortestDistance.add((float) 0);

        unvisitedCities.addAll(map.getCities());
        for (int i = 1; i < map.getCities().size(); i++) {
            shortestDistance.add(Float.MAX_VALUE);
    private void printShortestPath(float[] distance, int[] previous, int target) {
        System.out.println("Vertex\tDistance from Source\tPath");

        for (int i = 0; i < vertices; i++) {
            System.out.print(i + "\t\t" + distance[i] + "\t\t");
            printPath(previous, i);
            System.out.println();
        }

        int currentCityId = map.getCities().get(0).getIdNumber();

        while (visitedCities.size() != map.getCities().size() && currentCityId != map.getCities().size() - 1) {
            ArrayList<Integer> linkedCities = map.getCities().get(currentCityId).getLinkedCitiesID();
            for (int i = 0; i < linkedCities.size(); i++) {
                if (map.getMatrixMetztli().getMatrix()[currentCityId][linkedCities.get(i)] < shortestDistance
                        .get(linkedCities.get(i))) {

                    if (shortestDistance.get(linkedCities.get(i)) == Float.MAX_VALUE) {
                        shortestDistance.set(linkedCities.get(i),
                                map.getMatrixMetztli().getMatrix()[currentCityId][linkedCities.get(i)]);
                    } else {
                        shortestDistance.set(linkedCities.get(i), shortestDistance.get(linkedCities.get(i))
                                + map.getMatrixMetztli().getMatrix()[currentCityId][linkedCities.get(i)]);
                    }
                    previousCityId[linkedCities.get(i)] = currentCityId;
                }
        System.out.print("Shortest Path from 0 to " + target + ": ");
        printPath(previous, target);
        System.out.println();
    }

            }

            float minCurrentDistance = Float.MAX_VALUE;

            if (!visitedCities.contains(map.getCities().get(currentCityId))) {
                visitedCities.add(map.getCities().get(currentCityId));
            }

            unvisitedCities.remove(map.getCities().get(currentCityId));

            int counter = 0;

            for (int i = 0; i < linkedCities.size(); i++) {

                if (shortestDistance.get(linkedCities.get(i)) < minCurrentDistance
                        && !visitedCities.contains(map.getCities().get(linkedCities.get(i)))) {
                    minCurrentDistance = shortestDistance.get(linkedCities.get(i));
                    currentCityId = linkedCities.get(i);
                    counter++;
                }

            }
            int c = 3;
            if (counter == 0 && unvisitedCities.size() != 0 && currentCityId != map.getCities().size() - 1) {
                currentCityId = previousCityId[currentCityId];
            }
        }

        printShortestPath(distance, previous, target);
    }

        }

        // Last city id is always the last element in the array of cities
        currentCityId = map.getCities().size() - 1;


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
        // first city id is always the first element in the array of cities
        while (currentCityId != 0) {
            pathDijkstra.push(previousCityId[currentCityId]);
            currentCityId = previousCityId[currentCityId];
        }

        return pathDijkstra;
    }

}
