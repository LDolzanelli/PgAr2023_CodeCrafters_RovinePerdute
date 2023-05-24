package it.unibs.fp.rovineperdute;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

public class ReadWriteXML {

    public static ArrayList<City> readCitiesFile(File file, AdjacencyMatrix matrix) {
        ArrayList<City> cities = new ArrayList<>();
        XMLInputFactory xmlif = XMLInputFactory.newInstance();
        XMLStreamReader xmlr = null;

        try {
            xmlr = xmlif.createXMLStreamReader(new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8")));;
            
            String id = null;
            String name = null;
            String x = null;
            String y = null;
            String h = null;

            while (xmlr.hasNext()) {

                int event = xmlr.nextTag();

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        String elementName = xmlr.getLocalName();

                        if (elementName.equals("city")) {
                            id = xmlr.getAttributeValue(null, "id");
                            name = xmlr.getAttributeValue(null, "name");
                            x = xmlr.getAttributeValue(null, "x");
                            y = xmlr.getAttributeValue(null, "y");
                            h = xmlr.getAttributeValue(null, "h");

                            cities.add(new City(name,
                                    new Coordinates(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(h)),
                                    Integer.parseInt(id)));
                        } else if (elementName.equals("link")) {

                            String link = xmlr.getAttributeValue(null, "to");
                            matrix.assignLinksBetweenCities(Integer.parseInt(id), Integer.parseInt(link));
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:

                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("Errore durante la lettura del file XML:");
            System.out.println(e.getMessage());
        } finally {
            if (xmlr != null) {
                try {
                    xmlr.close();
                } catch (Exception e) {
                    System.out.println("Errore durante la chiusura del reader XML:");
                    System.out.println(e.getMessage());
                }
            }
        }

        return cities;

    }

}
