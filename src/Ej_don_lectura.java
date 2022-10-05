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
        try {
            //Obtenemos el documento a analizar y le decimos como lo queremos sacar los datos
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("Becario.xml"));
            document.getDocumentElement().normalize();

            //Mostramos el elemento raiz del xml
            System.out.printf("Elemento raiz: %s %n", document.getDocumentElement().getNodeName());

            //Obtenemos el nodo becario y mostramos cuantos objetos becarios tenemos
            NodeList listaBecarios = document.getElementsByTagName("becario");
            System.out.printf("Nodos Becarios a recorrer: %d %n", listaBecarios.getLength());

            //Recorremos los diferentes becarios que tiene el xml
            for (int i = 0; i < listaBecarios.getLength(); i++) {
                //Obtenemos el nodo becario de la posicion indicada
                Node nodoBecario = listaBecarios.item(i);

                //Si es un elemento entonces lo obtenemos
                if (nodoBecario.getNodeType() == Node.ELEMENT_NODE) {
                    //Obtenemos el elemento y extramos los datos
                    Element elementoBecario = (Element) nodoBecario;
                    System.out.printf("Nombre completo del becario: %s %n",
                            elementoBecario.getElementsByTagName("nombreCompleto").item(0).getTextContent());
                    System.out.printf("Sexo del becario: %s %n",
                            elementoBecario.getElementsByTagName("sexo").item(0).getTextContent());
                    System.out.printf("Edad del becario: %s %n",
                            elementoBecario.getElementsByTagName("edad").item(0).getTextContent());
                    System.out.printf("Numero de suspensos del curso anterior del becario: %s %n",
                            elementoBecario.getElementsByTagName("numSuspensos").item(0).getTextContent());
                    System.out.printf("Residencia familiar del becario: %s %n",
                            elementoBecario.getElementsByTagName("residenciaFamiliar").item(0).getTextContent());
                    System.out.printf("Ingresos anuales de la familia del becario: %s %n %n",
                            elementoBecario.getElementsByTagName("ingresosAnuales").item(0).getTextContent());
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
