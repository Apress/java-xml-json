import java.io.FileWriter;
import java.io.IOException;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

class StAXDemo
{
   public static void main(String[] args)
   {
      try
      {
         XMLOutputFactory xmlof = XMLOutputFactory.newFactory();
         XMLStreamWriter xmlsw;
         xmlsw = xmlof.createXMLStreamWriter(new FileWriter("recipe.xml"));
         xmlsw.writeStartDocument();
         xmlsw.setPrefix("h", "http://www.w3.org/1999/xhtml");
         xmlsw.writeStartElement("http://www.w3.org/1999/xhtml", "html");
         xmlsw.writeNamespace("h", "http://www.w3.org/1999/xhtml");
         xmlsw.writeNamespace("r", "http://www.tutortutor.ca/");
         xmlsw.writeStartElement("http://www.w3.org/1999/xhtml", "head");
         xmlsw.writeStartElement("http://www.w3.org/1999/xhtml", "title");
         xmlsw.writeCharacters("Recipe");
         xmlsw.writeEndElement();
         xmlsw.writeEndElement();
         xmlsw.writeStartElement("http://www.w3.org/1999/xhtml", "body");
         xmlsw.setPrefix("r", "http://www.tutortutor.ca/");
         xmlsw.writeStartElement("http://www.tutortutor.ca/", "recipe");
         xmlsw.writeStartElement("http://www.tutortutor.ca/", "title");
         xmlsw.writeCharacters("Grilled Cheese Sandwich");
         xmlsw.writeEndElement();
         xmlsw.writeStartElement("http://www.tutortutor.ca/", 
                                 "ingredients");
         xmlsw.setPrefix("h", "http://www.w3.org/1999/xhtml");
         xmlsw.writeStartElement("http://www.w3.org/1999/xhtml", "ul");
         xmlsw.writeStartElement("http://www.w3.org/1999/xhtml", "li");
         xmlsw.setPrefix("r", "http://www.tutortutor.ca/");
         xmlsw.writeStartElement("http://www.tutortutor.ca/", "ingredient");
         xmlsw.writeAttribute("qty", "2");
         xmlsw.writeCharacters("bread slice");
         xmlsw.writeEndElement();
         xmlsw.setPrefix("h", "http://www.w3.org/1999/xhtml");
         xmlsw.writeEndElement();
         xmlsw.writeEndElement();
         xmlsw.setPrefix("r", "http://www.tutortutor.ca/");
         xmlsw.writeEndElement();
         xmlsw.writeEndDocument();
         xmlsw.flush();
         xmlsw.close();
      }
      catch (FactoryConfigurationError fce)
      {
         System.err.println("FCE: " + fce);
      }
      catch (IOException ioe)
      {
         System.err.println("IOE: " + ioe);
      }
      catch (XMLStreamException xmlse)
      {
         System.err.println("XMLSE: " + xmlse);
      }
   }
}