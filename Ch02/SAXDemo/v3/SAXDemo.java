import java.io.FileReader;
import java.io.IOException;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import org.xml.sax.helpers.XMLReaderFactory;

public class SAXDemo
{
   public static void main(String[] args)
   {
      if (args.length < 1 || args.length > 2)
      {
         System.err.println("usage: java SAXDemo xmlfile [v]");
         return;
      }
      try
      {
         XMLReader xmlr = XMLReaderFactory.createXMLReader();
         if (args.length == 2 && args[1].equals("v"))
            xmlr.setFeature("http://xml.org/sax/features/validation", true);
         xmlr.setFeature("http://xml.org/sax/features/namespace-prefixes",
                         true);
         Handler handler = new Handler();
         xmlr.setContentHandler(handler);
         xmlr.setDTDHandler(handler);
         xmlr.setEntityResolver(handler);
         xmlr.setErrorHandler(handler);
         xmlr.setEntityResolver(new LocalRecipeML());
         xmlr.setProperty("http://xml.org/sax/properties/lexical-handler", handler);
         xmlr.parse(new InputSource(new FileReader(args[0])));
      }
      catch (IOException ioe)
      {
         System.err.println("IOE: " + ioe);
      }
      catch (SAXException saxe)
      {
         System.err.println("SAXE: " + saxe);
      }
   }
}