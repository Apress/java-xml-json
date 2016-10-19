import java.io.FileReader;
import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class DumpUserInfo
{
   public static void main(String[] args)
   {
      try
      {
         XMLReader xmlr = XMLReaderFactory.createXMLReader();
         Handler handler = new Handler();
         xmlr.setContentHandler(handler);
         xmlr.parse(new InputSource(new FileReader("tomcat-users.xml")));
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

class Handler extends DefaultHandler
{
   @Override
   public void startElement(String uri, String localName, String qName,
                            Attributes attributes)
   {
      if (localName.equals("user"))
      {
         for (int i = 0; i < attributes.getLength(); i++)
            System.out.printf("%s = %s%n", attributes.getLocalName(i),
                              attributes.getValue(i));
         System.out.println();
      }
   }
}