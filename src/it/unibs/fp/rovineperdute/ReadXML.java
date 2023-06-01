package it.unibs.fp.rovineperdute;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

public class ReadXML {

    /**
     * Read the cities from the xml file and save them in an arraylist
     * @param file the xml file containing the cities
     * @param matrix the matrix in which will be saved the connections between the cities (1 if they are connected, 0 otherwise)
     * @return
     */

    public static ArrayList<City> readCitiesFile(File file, AdjacencyMatrix matrix) {
        ArrayList<City> cities = new ArrayList<>();
        XMLInputFactory xmlif = XMLInputFactory.newInstance();
        XMLStreamReader xmlr = null;

        try {

            xmlr = xmlif.createXMLStreamReader(new FileReader(file));

            String name = null;
            int id = 0;
            int x;
            int y;
            int h;

            while (xmlr.hasNext()) {

                int event = xmlr.next();

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:

                        String elementName = xmlr.getLocalName();

                        switch (elementName) {

                            case "city":


                                name = xmlr.getAttributeValue(null, "name");

                                id = Integer.parseInt(xmlr.getAttributeValue(null, "id"));
                                x = Integer.parseInt(xmlr.getAttributeValue(null, "x"));
                                y = Integer.parseInt(xmlr.getAttributeValue(null, "y"));
                                h = Integer.parseInt(xmlr.getAttributeValue(null, "h"));

                                cities.add(new City(name, new Coordinates(x, y, h), id));

                                break;

                            case "link":

                                // assassination of the connections between the cities (1 if they are connected, 0 otherwise)
                                int link = Integer.parseInt(xmlr.getAttributeValue(null, "to"));
                                matrix.assignLinksBetweenCities(id, link);
                                cities.get(id).getLinkedCitiesID().add(link);

                                break;

                        }

                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        break;

                    case XMLStreamConstants.END_DOCUMENT:
                        break;

                    default:
                        break;

                }
            }

        } catch (Exception e) {
            System.out.println("Error occurred while processing XML document: ");
            System.out.println(e.getMessage());
        } finally {
            if (xmlr != null) {
                try {
                    xmlr.close();
                } catch (Exception e) {
                    System.out.println("Error occurred while closing the XML document: ");
                    System.out.println(e.getMessage());
                }
            }
        }

        return cities;

    }

}
