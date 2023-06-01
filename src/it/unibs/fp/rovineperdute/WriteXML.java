package it.unibs.fp.rovineperdute;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

public class WriteXML {

    /**
     * Write tha two pathes (team Tonatiuh and team Metztli) in the XML file 
     * @param map the map of the lost ruins
     * @param fileName the name of the file in which is going to be written the path
     */

    public static void writeShortestPath(Map map, String fileName) {

        File file = createFile(String.format("outputFiles/%s.xml", fileName));

        XMLOutputFactory xmlof = null;
        XMLStreamWriter xmlw = null;

        // Writing xml file

        try {

            

            xmlof = XMLOutputFactory.newInstance();
            xmlw = xmlof.createXMLStreamWriter(new FileOutputStream(file.getAbsolutePath()), "utf-8");

            // start document
            xmlw.writeStartDocument("utf-8", "1.0");

            // start routs
            xmlw.writeStartElement("routs");

            // start route Tonatiuh
            xmlw.writeStartElement("route");
            xmlw.writeAttribute("team", "Tonathiu");
            xmlw.writeAttribute("cost", String.format("%.2f", map.getCostTonatiuh()));
            xmlw.writeAttribute("cities", String.format("%d", map.getShortestPathTonatiuh().size()));

            // write cities in the path
            for (int i = 0; i < map.getShortestPathTonatiuh().size(); i++) {
                xmlw.writeStartElement("city");
                xmlw.writeAttribute("id", String.format("%d", map.getShortestPathTonatiuh().get(i)));
                xmlw.writeAttribute("name", map.getCities().get(map.getShortestPathTonatiuh().get(i)).getName());
                xmlw.writeEndElement(); // end city

            }
            xmlw.writeEndElement(); // end Tonatiuh route

            // start route Metztli
            xmlw.writeStartElement("route");
            xmlw.writeAttribute("team", "Metztli");
            xmlw.writeAttribute("cost", String.format("%.2f", map.getCostMetztli()));
            xmlw.writeAttribute("cities", String.format("%d", map.getShortestPathMetztli().size()));

            // write cities in the path
            for (int i = 0; i < map.getShortestPathMetztli().size(); i++) {
                xmlw.writeStartElement("city");
                xmlw.writeAttribute("id", String.format("%d", map.getShortestPathMetztli().get(i)));
                xmlw.writeAttribute("name", map.getCities().get(map.getShortestPathMetztli().get(i)).getName());
                xmlw.writeEndElement(); // end city

            }
            xmlw.writeEndElement(); // end Metztli route

            xmlw.writeEndElement();// end routs

            xmlw.writeEndDocument();// end document

            xmlw.flush();
            xmlw.close();

        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del writer:");
            System.out.println(e.getMessage());
        }

    }

    /**
     * Creating a new file with the name of the map if not already existing
     * @param filePath the path to the file
     * @return the new file
     */
    private static File createFile(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                System.out.println("Error occurred while creating the file");
            }
        }

        return file;

    }
}
