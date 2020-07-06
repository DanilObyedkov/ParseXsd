
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.*;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
        import javax.xml.bind.JAXBException;
        import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class JAXBExampleConver {
    public static void main(String args[]) {
        try {
            // parse the document
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse (new File("H:\\Try\\src\\main\\resources\\file.xml"));
            NodeList list = (doc.getElementsByTagName("xs:element"));


            //loop to print data
            for(int i = 0 ; i < list.getLength(); i++)
            {
                Node first =  list.item(i);
                if (first.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) first;
                    System.out.println(eElement.getAttribute("name"));
                    System.out.println(eElement.getElementsByTagName("xs:documentation").item(0).getTextContent());
                    System.out.println(eElement.getAttributeNS("xs:enumeration","value"));
                   /* System.out.println(eElement.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println(eElement.getElementsByTagName("nickname").item(0).getTextContent());
                    System.out.println(eElement.getElementsByTagName("marks").item(0).getTextContent());*/
                }
            }


        }
        catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        }
        catch (SAXException e)
        {
            e.printStackTrace();
        }
        catch (IOException ed)
        {
            ed.printStackTrace();
        }
    }
}