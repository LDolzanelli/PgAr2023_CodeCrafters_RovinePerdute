package it.unibs.fp.rovineperdute;

import java.io.File;
import java.util.ArrayList;

public class MapGenerator {

/**
 * Generates all the maps reading the XML files, and puts them in an array where they are easily accessible via the index
 * @return the array of generated maps
 */
    public static Map[] generateMaps() {
        Map[] maps = new Map[6];
        final int[]  MAP_SIZES = {5, 13, 50, 200, 2000, 10000};

        File map1File = new File("inputFiles/PgAr_Map_5.xml");
        File map2File = new File("inputFiles/PgAr_Map_12.xml");
        File map3File = new File("inputFiles/PgAr_Map_50.xml");
        File map4File = new File("inputFiles/PgAr_Map_200.xml");
        File map5File = new File("inputFiles/PgAr_Map_2000.xml");
        File map6File = new File("inputFiles/PgAr_Map_10000.xml");

        File[] files = {map1File, map2File, map3File, map4File, map5File, map6File};

        for(int i = 0; i < 6; i++) {
            maps[i] = generateMap(files[i], MAP_SIZES[i]);
        }

        return maps;
    }

/**
 * generates the single map from the XML file
 * @param mapFile the XML file
 * @param size the amount of maps conatined in the file
 * @return the Map object
 */
    public static Map generateMap(File mapFile, int size) {

        ArrayList<City> cities = new ArrayList<>();
        AdjacencyMatrix matrix = new MatrixTeamMetztli(size);

        cities = ReadXML.readCitiesFile(mapFile, matrix);

        Map map = new Map(cities, matrix.getMatrix());

        return map;
    }
    
}
