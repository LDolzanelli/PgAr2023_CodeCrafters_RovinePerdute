package it.unibs.fp.rovineperdute;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import javax.lang.model.util.ElementScanner14;

public class PathAlgorithm {
    public static float calculateHeuristic(City currentCity, City lostRuins) {
        double weightX = Math.pow(currentCity.getCoordinates().getX() - lostRuins.getCoordinates().getX(), 2);
        double weightY = Math.pow(currentCity.getCoordinates().getY() - lostRuins.getCoordinates().getY(), 2);

        return (float) Math.sqrt(weightX + weightY);
    }

    public static int getClosestCityID(float[][] matrix, int currentCityID, ArrayList<City> cities,
            ArrayList<Integer> visitedCitiesID) {
        int minValue = Integer.MAX_VALUE;
        int closestCityId = 0;

        for (int i = 0; i < cities.get(currentCityID).getLinkedCitiesID().size(); i++) {
            int linkedCityID = cities.get(currentCityID).getLinkedCitiesID().get(i);
            float calculatedValue = matrix[currentCityID][linkedCityID]
                    + calculateHeuristic(cities.get(linkedCityID), cities.get(cities.size() - 1));
            if (calculatedValue < minValue && (!visitedCitiesID.contains(cities.get(linkedCityID).getIdNumber()))) {
                minValue = (int) calculatedValue;
                closestCityId = linkedCityID;
            }

        }
        return closestCityId;
    }

    public static ArrayList<Integer> calculatePathMetztli(Map map) {

        ArrayList<Integer> visitedCitiesID = new ArrayList<>();
        int lostRuinsID = map.getCities().get(map.getCities().size() - 1).getIdNumber();
        int lastVisitedCityId = 0;
        visitedCitiesID.add(map.getCities().get(0).getIdNumber());
        while (lastVisitedCityId != lostRuinsID) {
            visitedCitiesID.add(getClosestCityID(map.getMatrixMetztli().getMatrix(), lastVisitedCityId, map.getCities(),
                    visitedCitiesID));
            lastVisitedCityId = visitedCitiesID.get(visitedCitiesID.size() - 1);
        }
        return visitedCitiesID;
    }

    public static ArrayList<Integer> calculatePathTonatiuh(Map map) {
        ArrayList<Integer> visitedCitiesID = new ArrayList<>();
        int lostRuinsID = map.getCities().get(map.getCities().size() - 1).getIdNumber();
        int lastVisitedCityId = 0;
        visitedCitiesID.add(map.getCities().get(0).getIdNumber());
        while (lastVisitedCityId != lostRuinsID) {
            visitedCitiesID.add(getClosestCityID(map.getMatrixTonatiuh().getMatrix(), lastVisitedCityId,
                    map.getCities(), visitedCitiesID));
            lastVisitedCityId = visitedCitiesID.get(visitedCitiesID.size() - 1);
        }

        return visitedCitiesID;
    }

    public static Stack<Integer> calculatePathDijkstraMetztli(Map map) {
        Stack<Integer> pathDijkstra = new Stack<Integer>();
        
        ArrayList<City> vistedCities = new ArrayList<City>();

        ArrayList<Float> shortestDistance = new ArrayList<Float>();
        int[] previousCityId = new int[map.getCities().size()];

        shortestDistance.add((float) 0);

        for (int i = 1; i < map.getCities().size(); i++) {
            shortestDistance.add(Float.MAX_VALUE);
        }

        int currentCityId = map.getCities().get(0).getIdNumber();

        while (vistedCities.size() != map.getCities().size()) {
            ArrayList<Integer> linkedCities = map.getCities().get(currentCityId).getLinkedCitiesID();
            for (int i = 0; i < linkedCities.size(); i++) {
                if (map.getMatrixMetztli().getMatrix()[currentCityId][linkedCities.get(i)] < shortestDistance.get(linkedCities.get(i))) {

                    if (shortestDistance.get(linkedCities.get(i)) == Float.MAX_VALUE)
                    {
                        shortestDistance.set(linkedCities.get(i), map.getMatrixMetztli().getMatrix()[currentCityId][linkedCities.get(i)]);
                    }
                    else
                    {
                        shortestDistance.set(linkedCities.get(i),shortestDistance.get(linkedCities.get(i)) + map.getMatrixMetztli().getMatrix()[currentCityId][linkedCities.get(i)]);
                    }
                    previousCityId[linkedCities.get(i)] = currentCityId;
                }

            }

            float minCurrentDistance = Float.MAX_VALUE;

            vistedCities.add(map.getCities().get(currentCityId));


            for (int i = 0; i < linkedCities.size(); i++) {

                
                if (shortestDistance.get(linkedCities.get(i)) < minCurrentDistance && !vistedCities.contains(map.getCities().get(linkedCities.get(i)))) {
                    minCurrentDistance = shortestDistance.get(linkedCities.get(i));
                    currentCityId = linkedCities.get(i);
                }
            }

            
        }

        //Last city id is always the last element in the array of cities
        currentCityId = map.getCities().size() - 1;

        pathDijkstra.push(currentCityId);

        //first city id is always the first element in the array of cities
        while (currentCityId != 0)
        {
            pathDijkstra.push(previousCityId[currentCityId]);
            currentCityId = previousCityId[currentCityId];
        }


        return pathDijkstra;
    }

}
