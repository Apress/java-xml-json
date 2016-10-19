import java.io.FileReader;
import java.io.IOException;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class ParseXMLDoc
{
   public static void main(String[] args)
   {
      if (args.length != 1)
      {
         System.err.println("usage: java ParseXMLDoc pathname");
         return;
      }
      XMLInputFactory xmlif = XMLInputFactory.newFactory();
      XMLStreamReader xmlsr = null;
      try (FileReader fr = new FileReader(args[0]))
      {
         xmlsr = xmlif.createXMLStreamReader(fr);
         int item = xmlsr.getEventType();
         if (item != XMLStreamReader.START_DOCUMENT)
         {
            System.err.println("START_DOCUMENT expected");
            return;
         }
         while ((item = xmlsr.next()) != XMLStreamReader.END_DOCUMENT)
            switch (item)
            {
               case XMLStreamReader.ATTRIBUTE:
                  System.out.println("ATTRIBUTE");
                  break;
               case XMLStreamReader.CDATA:
                  System.out.println("CDATA");
                  break;
               case XMLStreamReader.CHARACTERS:
                  System.out.println("CHARACTERS");
                  break;
               case XMLStreamReader.COMMENT:
                  System.out.println("COMMENT");
                  break;
               case XMLStreamReader.DTD:
                  System.out.println("DTD");
                  break;
               case XMLStreamReader.END_ELEMENT:
                  System.out.println("END_ELEMENT");
                  break;
               case XMLStreamReader.ENTITY_DECLARATION:
                  System.out.println("ENTITY_DECLARATION");
                  break;
               case XMLStreamReader.ENTITY_REFERENCE:
                  System.out.println("ENTITY_REFERENCE");
                  break;
               case XMLStreamReader.NAMESPACE:
                  System.out.println("NAMESPACE");
                  break;
               case XMLStreamReader.NOTATION_DECLARATION:
                  System.out.println("NOTATION_DECLARATION");
                  break;
               case XMLStreamReader.PROCESSING_INSTRUCTION:
                  System.out.println("PROCESSING_INSTRUCTION");
                  break;
               case XMLStreamReader.SPACE:
                  System.out.println("SPACE");
                  break;
               case XMLStreamReader.START_ELEMENT:
                  System.out.println("START_ELEMENT");
                  System.out.println("Name = " + xmlsr.getName());
                  System.out.println("Local name = " + 
                                     xmlsr.getLocalName());
                  int nAttrs = xmlsr.getAttributeCount();
                  for (int i = 0; i < nAttrs; i++)
                     System.out.println("Attribute [" + 
                                        xmlsr.getAttributeLocalName(i) + 
                                        ", " +
                                        xmlsr.getAttributeValue(i) + "]");
            }
      }
      catch (IOException ioe)
      {
         ioe.printStackTrace();
      }
      catch (XMLStreamException xmlse)
      {
         xmlse.printStackTrace();
      }
      finally
      {
         if (xmlsr != null)
            try 
            { 
               xmlsr.close(); 
            } 
            catch (XMLStreamException xmlse) 
            {
            }
      }
   }
}