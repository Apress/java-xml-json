import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

class StAXDemo
{
   public static void main(String[] args)
   {
      if (args.length != 1)
      {
         System.err.println("usage: java StAXDemo xmlfile");
         return;
      }
      try
      {
         XMLInputFactory xmlif = XMLInputFactory.newFactory();
         XMLStreamReader xmlsr;
         xmlsr = xmlif.createXMLStreamReader(new FileReader(args[0]));
         while (xmlsr.hasNext())
         {
            switch (xmlsr.next())
            {
               case XMLStreamReader.START_ELEMENT:
                  System.out.println("START_ELEMENT");
                  System.out.println("  Qname = " + xmlsr.getName());
                  break;
               case XMLStreamReader.END_ELEMENT:
                  System.out.println("END_ELEMENT");
                  System.out.println("  Qname = " + xmlsr.getName());
            }
         }
      }
      catch (FactoryConfigurationError fce)
      {
         System.err.println("FCE: " + fce);
      }
      catch (FileNotFoundException fnfe)
      {
         System.err.println("FNFE: " + fnfe);
      }
      catch (XMLStreamException xmlse)
      {
         System.err.println("XMLSE: " + xmlse);
      }
   }
}