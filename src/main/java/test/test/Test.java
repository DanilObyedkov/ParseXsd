package test.test;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File file = new File("D:\\WorkSpaceSmSoft\\ParseXsd\\src\\main\\resources\\file.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        Element emplyersElement = (Element) document.getElementsByTagName("emplyers");

        String department = emplyersElement.getAttribute("department");

        NodeList emloyeeNodeList = document.getElementsByTagName("employee");

        List<Employe> employeList = new ArrayList<>();

        for (int i = 0; 1<emloyeeNodeList.getLength(); i++){
            if (emloyeeNodeList.item(i).getNodeType()== Node.ELEMENT_NODE) {
                Element employeeElement = (Element) emloyeeNodeList.item(i);

                Employe employe = new Employe();
                employe.setDepartment(department);
                employe.setNumber(Integer.valueOf(employeeElement.getAttribute("number")));

                NodeList childNods = employeeElement.getChildNodes();
                for (int j = 0; j<childNods.getLength(); j++){
                    if (childNods.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        Element childElement = (Element) childNods.item(j);

                        switch (childElement.getNodeName()) {
                            case "name": {
                                employe.setName(childElement.getTextContent());

                            } break;

                                case "age": {
                                    employe.getAge(Integer.valueOf(childElement.getTextContent()));
                                }break;
                            case "salary": {
                                employe.getSallary().setValue(Double.valueOf(childElement.getTextContent()));
                                employe.getSallary().setCurrency(childElement.getAttribute("currency"));
                            }break;
                            }
                                }
                            }

                employeList.add (employe);
                        }
                    }
        System.out.println();
                }

            }


class Employe {
    private String department;
    private Integer number;
    private String name;
    private Integer age;
    private Sallary sallary = new Sallary();




    public static class Sallary {

        private double value;
        private String currency;

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge(Integer integer) {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Sallary getSallary() {
        return sallary;
    }



    @Override
    public String toString() {
        return "Employe{" +
                "department='" + department + '\'' +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sallary=" + sallary.getValue()+" "+sallary.getCurrency() +
                '}';
    }
}