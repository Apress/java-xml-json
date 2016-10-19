import java.io.FileReader;
import java.io.IOException;

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
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;

import org.xml.sax.SAXException;

public class XSLTDemo
{
   public static void main(String[] args)
   {
      try
      {
         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
         DocumentBuilder db = dbf.newDocumentBuilder();
         Document doc = db.parse("recipe.xml");
         TransformerFactory tf = TransformerFactory.newInstance();
         StreamSource ssStyleSheet;
         ssStyleSheet = new StreamSource(new FileReader("recipe.xsl"));
         Transformer t = tf.newTransformer(ssStyleSheet);
         t.setOutputProperty(OutputKeys.METHOD, "html");
         t.setOutputProperty(OutputKeys.INDENT, "yes");
         Source source = new DOMSource(doc);
         Result result = new StreamResult(System.out);
         t.transform(source, result);
      }
      catch (IOException ioe)
      {
         System.err.println("IOE: " + ioe);
      }
      catch (FactoryConfigurationError fce)
      {
         System.err.println("FCE: " + fce);
      }
      catch (ParserConfigurationException pce)
      {
         System.err.println("PCE: " + pce);
      }
      catch (SAXException saxe)
      {
         System.err.println("SAXE: " + saxe);
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