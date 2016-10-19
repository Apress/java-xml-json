import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;

import javax.xml.transform.dom.DOMSource;

import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class XSLTDemo
{
   public static void main(String[] args)
   {
      try
      {
         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
         DocumentBuilder db = dbf.newDocumentBuilder();
         Document doc = db.newDocument();
         doc.setXmlStandalone(true);
         // Create the root element.
         Element root = doc.createElement("movie");
         doc.appendChild(root);
         // Create name child element and add it to the root.
         Element name = doc.createElement("name");
         root.appendChild(name);
         // Add a text element to the name element.
         Text text = 
           doc.createTextNode("Le Fabuleux Destin d'Amélie Poulain");
         name.appendChild(text);
         // Create language child element and add it to the root.
         Element language = doc.createElement("language");
         root.appendChild(language);
         // Add a text element to the language element.
         text = doc.createTextNode("français");
         language.appendChild(text);
         // Use a transformer to output this tree with ISO-8859-1 encoding
         // to the standard output stream.
         TransformerFactory tf = TransformerFactory.newInstance();
         Transformer t = tf.newTransformer();
         t.setOutputProperty(OutputKeys.METHOD, "xml");
         t.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
         t.setOutputProperty(OutputKeys.INDENT, "yes");
         t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", 
                             "3");
         Source source = new DOMSource(doc);
         Result result = new StreamResult(System.out);
         t.transform(source, result);
      }
      catch (FactoryConfigurationError fce)
      {
         System.err.println("FCE: " + fce);
      }
      catch (ParserConfigurationException pce)
      {
         System.err.println("PCE: " + pce);
      }
      catch (TransformerConfigurationException tce)
      {
         System.err.println("TCE: " + tce);
      }
      catch (TransformerException te)
      {
         System.err.println("TE: " + te);
      }
      catch (TransformerFactoryConfigurationError tfce)
      {
         System.err.println("TFCE: " + tfce);
      }
   }
}