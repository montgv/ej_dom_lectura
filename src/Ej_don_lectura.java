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

public class Ej_don_lectura {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("Becario.xml"));
            document.getDocumentElement().normalize();

            System.out.printf("Elemento raiz: %s %n", document.getDocumentElement().getNodeName());

            NodeList becarios = document.getElementsByTagName("becario");
            System.out.printf("Nodos becarios a recorrer: %d %n", becarios.getLength());

            for (int i = 0; i < becarios.getLength(); i++) {
                Node becario = becarios.item(i);

                if (becario.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) becario;
                    System.out.printf("Nombre completo del becario: %s %n",
                            element.getElementsByTagName("nombreCompleto").item(0).getTextContent());
                    System.out.printf("Sexo del becario: %s %n",
                            element.getElementsByTagName("sexo").item(0).getTextContent());
                    System.out.printf("Edad del becario: %s %n",
                            element.getElementsByTagName("edad").item(0).getTextContent());
                    System.out.printf("Numero de suspensos del curso anterior del becario: %s %n",
                            element.getElementsByTagName("numSuspensos").item(0).getTextContent());
                    System.out.printf("Residencia familiar del becario: %s %n",
                            element.getElementsByTagName("residenciaFamiliar").item(0).getTextContent());
                    System.out.printf("Ingresos anuales de la familia del becario: %s %n %n",
                            element.getElementsByTagName("ingresosAnuales").item(0).getTextContent());
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
