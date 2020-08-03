import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomExample {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        try {

            File file = new File("C:\\workspace\\projectRepo\\ParseXSD\\ParseXsd\\src\\main\\resources\\file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());


            NodeList nList = doc.getElementsByTagName("xs:element");


            for (int temp = 0; temp < nList.getLength(); temp++) {


                Node nNode = nList.item(temp);


                if (nNode.getNodeType() == Node.ELEMENT_NODE) {


                    Element eElement = (Element) nNode;

                             /*
                  get node name form XSD (example= "zayv_yavl")
                            */

                    String nameNode = eElement.getAttribute("name");
                    String nodenamee = nameNode;
                    nodenamee.indexOf('_');
                    String help = nodenamee;


                           /*
                      get node condition form XSD (example= "zayv_yavl")
                             */

                    String condition = eElement.getAttribute("minOccurs");
                    String conditionValue = condition;

                            /*
                      get node type form XSD (example= "boolean")
                             */

                    String type = eElement.getAttribute("type");
                    String typeValue = type.replaceAll("xs:","");

                    Node documentation = eElement.getElementsByTagName("xs:documentation").item(0);
                    String documentationValue = documentation == null ? "" : documentation.getTextContent();


                             /*
                      get node enumeration form XSD (example= "1,2,3")
                            TODO
                             */
                    Node test = eElement.getElementsByTagName("xs:enumeration").item(0);
                    String testtt = test == null ? "" : test.getTextContent();




                        //  System.out.println(nodename+"  "+conditionValue+"  "+typeValue+"  "+(documentationValue==null?"":documentationValue)+"  ");


                        System.out.println("@ApiModelProperty(value = \"" + documentationValue + "\"," +(("string".equals(typeValue)?"example ="+"\"String"+"\"":"boolean".equals(typeValue)?"example ="+"\"true"+"\"":"example ="+"\"String"+"\"")+
                                (", position ="+(temp+1))+("1".equals(condition)?",  required= true ":"")+""+(test==null?")":"")+
                                (test!=null?", allowableValues=\"\")":"")+
                                "\n"+"@XmlElement(name = \""+nameNode+"\""+")\n"
                                +("1".equals(condition)?"@NotNull\n":"")+
                                "private  "+("string".equals(typeValue)?"String  ":"boolean".equals(typeValue)?"Boolean  ":"String  " )+  nodenamee.replaceAll("_","")+";"+"\n"+
                                " "));



                    }


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}