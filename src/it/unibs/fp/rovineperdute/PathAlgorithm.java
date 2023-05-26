package it.unibs.fp.rovineperdute;

import java.util.ArrayList;

public class PathAlgorithm {
    public static float calculateHeuristic(City currentCity, City lostRuins) {
        double weightX = Math.pow(currentCity.getCoordinates().getX() - lostRuins.getCoordinates().getX(), 2);
        double weightY = Math.pow(currentCity.getCoordinates().getY() - lostRuins.getCoordinates().getY(), 2);

        return (float)Math.sqrt(weightX + weightY);
    }

    public static int getClosestCityID(float[][] matrix, int currentCityID, ArrayList<City> cities) {
        int minValue = Integer.MAX_VALUE;
        int closestCityId = 0;

        for(int i = 0; i < cities.get(currentCityID).getLinkedCitiesID().size(); i++) {
            int linkedCityID = cities.get(currentCityID).getLinkedCitiesID().get(i);
            float calculatedValue = matrix[currentCityID][linkedCityID]
                    + calculateHeuristic(cities.get(linkedCityID), cities.get(cities.size() - 1));
            if (calculatedValue < minValue) {
                minValue = (int)calculatedValue;
                closestCityId = linkedCityID;
            }

        }
        return closestCityId;
    }

    public static ArrayList<Integer> calculatePathMetztli(Map map) {
        ArrayList<Integer> visitedCitiesID = new ArrayList<>();
        int lostRuinsID = map.getCities().get(map.getCities().size()-1).getIdNumber();
        int lastVisitedCityId = 0;
        visitedCitiesID.add(map.getCities().get(0).getIdNumber());
        while(lastVisitedCityId != lostRuinsID)
        {
            visitedCitiesID.add(getClosestCityID(map.getMatrixMetztli().getMatrix(), lastVisitedCityId, map.getCities()));
            lastVisitedCityId = visitedCitiesID.get(visitedCitiesID.size() -1);
        }
        return visitedCitiesID;
    }

    public static ArrayList<Integer> calculatePathTonatiuh(Map map) {
        ArrayList<Integer> visitedCitiesID = new ArrayList<>();
        int lostRuinsID = map.getCities().get(map.getCities().size()-1).getIdNumber();
        int lastVisitedCityId = 0;
        visitedCitiesID.add(map.getCities().get(0).getIdNumber());
        while(lastVisitedCityId != lostRuinsID)
        {
            visitedCitiesID.add(getClosestCityID(map.getMatrixTonatiuh().getMatrix(), lastVisitedCityId, map.getCities()));
            lastVisitedCityId = visitedCitiesID.get(visitedCitiesID.size() -1);
        }

        return visitedCitiesID;
    }


}
