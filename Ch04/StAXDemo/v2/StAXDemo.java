import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

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
         XMLEventReader xmler;
         xmler = xmlif.createXMLEventReader(new FileReader(args[0]));
         while (xmler.hasNext())
         {
            XMLEvent xmle = xmler.nextEvent();
            switch (xmle.getEventType())
            {
               case XMLEvent.START_ELEMENT:
                  System.out.println("START_ELEMENT");
                  System.out.println("  Qname = " + 
                                     ((StartElement) xmle).getName());
                  break;
               case XMLEvent.END_ELEMENT:
                  System.out.println("END_ELEMENT");
                  System.out.println("  Qname = " + 
                                     ((EndElement) xmle).getName());
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