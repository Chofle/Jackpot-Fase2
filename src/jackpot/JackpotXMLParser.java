
package jackpot;

import com.sun.org.apache.xml.internal.serializer.OutputPropertiesFactory;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class JackpotXMLParser {
     private static Document documento;
     
     public static void createXMLEstandar(ArrayList<Jackpot> jackpotsList) {
        try {
            DocumentBuilderFactory fábricaCreadorDocumento = DocumentBuilderFactory.newInstance();
            DocumentBuilder creadorDocumento = fábricaCreadorDocumento.newDocumentBuilder();
            documento = creadorDocumento.newDocument();
            int id = 0;
            Element raiz = documento.createElement("jackpots");
            documento.appendChild(raiz);
                        
            for(Jackpot jackpot: jackpotsList) {
                Element elementJackpot = documento.createElement("jackpot");
                raiz.appendChild(elementJackpot);
                id++;
                addElementData(elementJackpot, "id", String.valueOf(id));
                //addElementData(elementJackpot, "date", person.getName());
                addElementData(elementJackpot, "saldo", String.valueOf(jackpot.getSaldo()));
                addElementData(elementJackpot, "deposito", String.valueOf(jackpot.getDeposito()));
                addElementData(elementJackpot, "premio", String.valueOf(jackpot.getPremio()));
                
            }
            
            //Mostrar en salida estándar el documento XML generado 
            TransformerFactory fábricaTransformador = TransformerFactory.newInstance();
            Transformer transformador = fábricaTransformador.newTransformer();
            transformador.setOutputProperty(OutputKeys.INDENT, "yes");
            transformador.setOutputProperty(OutputPropertiesFactory.S_KEY_INDENT_AMOUNT, "3");            Source origen = new DOMSource(documento);
            Result destino = new StreamResult(System.out);
            transformador.transform(origen, destino);            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(JackpotXMLParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(JackpotXMLParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(JackpotXMLParser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     public static void createXML(ArrayList<Jackpot> jackpotsList, String xmlFileName) {
        try {
            DocumentBuilderFactory fábricaCreadorDocumento = DocumentBuilderFactory.newInstance();
            DocumentBuilder creadorDocumento = fábricaCreadorDocumento.newDocumentBuilder();
            documento = creadorDocumento.newDocument();
            int id = 0;
            Element raiz = documento.createElement("jackpots");
            documento.appendChild(raiz);
                        
            for(Jackpot jackpot: jackpotsList) {
                Element elementJackpot = documento.createElement("jackpot");
                raiz.appendChild(elementJackpot);
                id++;
                addElementData(elementJackpot, "id", String.valueOf(id));
                //addElementData(elementJackpot, "date", );
                addElementData(elementJackpot, "saldo", String.valueOf(jackpot.getSaldo()));
                addElementData(elementJackpot, "deposito", String.valueOf(jackpot.getDeposito()));
                addElementData(elementJackpot, "premio", String.valueOf(jackpot.getPremio()));
                
            }
            
            //Mostrar en salida estándar el documento XML generado 
            TransformerFactory fábricaTransformador = TransformerFactory.newInstance();
            Transformer transformador = fábricaTransformador.newTransformer();
            transformador.setOutputProperty(OutputKeys.INDENT, "yes");
            transformador.setOutputProperty(OutputPropertiesFactory.S_KEY_INDENT_AMOUNT, "3");            Source origen = new DOMSource(documento);
            Result destino = new StreamResult(xmlFileName);
            transformador.transform(origen, destino);            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(JackpotXMLParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(JackpotXMLParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(JackpotXMLParser.class.getName()).log(Level.SEVERE, null, ex);
        }

    } 
     
    private static void addElementData(Element parent, String tag, String value) {
        Element element = documento.createElement(tag);
        parent.appendChild(element);
        Text text = documento.createTextNode(value);
        element.appendChild(text);        
    } 
}
