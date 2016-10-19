import java.io.FileReader;
import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import org.xml.sax.helpers.XMLReaderFactory;

public class SAXSearch
{
   public static void main(String[] args)
   {
      if (args.length != 1)
      {
         System.err.println("usage: java SAXSearch publisher");
         return;
      }

      try
      {
         XMLReader xmlr = XMLReaderFactory.createXMLReader();
         Handler handler = new Handler(args[0]);
         xmlr.setContentHandler(handler);
         xmlr.setErrorHandler(handler);
         xmlr.setProperty("http://xml.org/sax/properties/lexical-handler", 
                          handler);
         xmlr.parse(new InputSource(new FileReader("books.xml")));
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