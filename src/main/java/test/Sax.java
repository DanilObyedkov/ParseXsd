package test;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Sax {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("C:\\workspace\\projectRepo\\ParseXSD\\ParseXsd\\src\\main\\resources\\file.xml"));

        Element element = document.getDocumentElement();
        printElements(element.getChildNodes(),0);
        /*for (int i =0; i<nodeList.getLength(); i++){
            if (nodeList.item(i) instanceof Element)
                System.out.println(((Element) nodeList.item(i)).getTagName());
        }*/
    }



    static void printElements(NodeList nodeList, int tabs) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i) instanceof Element) {
                System.out.print((((Element) nodeList.item(i)).getAttribute("value")+((Element) nodeList.item(i)).getAttribute("name")));
                System.out.println(((Element) nodeList.item(i)).getAttribute("name"));
                System.out.print(((Element) nodeList.item(i)).getTagName());
                if (nodeList.item(i).hasChildNodes()) {
                    printElements(nodeList.item(i).getChildNodes(), ++tabs);
                }
            }
        }
    }
    static String getTab (int tabs) {
        String str = "";
        for (int i = 0; i < tabs; i++) {
            str += "\t";
        }
        return str;
    }
}
