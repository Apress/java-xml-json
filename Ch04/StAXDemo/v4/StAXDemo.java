import java.io.FileWriter;
import java.io.IOException;

import java.util.Iterator;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;

import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Namespace;
import javax.xml.stream.events.XMLEvent;

class StAXDemo
{
   public static void main(String[] args)
   {
      try
      {
         XMLOutputFactory xmlof = XMLOutputFactory.newFactory();
         XMLEventWriter xmlew;
         xmlew = xmlof.createXMLEventWriter(new FileWriter("recipe.xml"));
         final XMLEventFactory xmlef = XMLEventFactory.newFactory();
         XMLEvent event = xmlef.createStartDocument();
         xmlew.add(event);
         Iterator<Namespace> nsIter;
         nsIter = new Iterator<Namespace>()
         {
            int index = 0;
            Namespace[] ns;
            {
               ns = new Namespace[2];
               ns[0] = xmlef.
                          createNamespace("h",
                                          "http://www.w3.org/1999/xhtml");
               ns[1] = xmlef.
                          createNamespace("r",
                                          "http://www.tutortutor.ca/");
            }
            @Override
            public boolean hasNext()
            {
               return index != 2;
            }
            @Override
            public Namespace next()
            {
               return ns[index++];
            }
            @Override
            public void remove()
            {
               throw new UnsupportedOperationException();
            }
         };
         event = xmlef.createStartElement("h", 
                                          "http://www.w3.org/1999/xhtml",
                                          "html", null, nsIter);
         xmlew.add(event);
         event = xmlef.createStartElement("h", 
                                          "http://www.w3.org/1999/xhtml",
                                          "head");
         xmlew.add(event);
         event = xmlef.createStartElement("h", 
                                          "http://www.w3.org/1999/xhtml",
                                          "title");
         xmlew.add(event);
         event = xmlef.createCharacters("Recipe");
         xmlew.add(event);
         event = xmlef.createEndElement("h", 
                                        "http://www.w3.org/1999/xhtml",
                                        "title");
         xmlew.add(event);
         event = xmlef.createEndElement("h", 
                                        "http://www.w3.org/1999/xhtml",
                                        "head");
         xmlew.add(event);
         event = xmlef.createStartElement("h", 
                                          "http://www.w3.org/1999/xhtml",
                                          "body");
         xmlew.add(event);
         event = xmlef.createStartElement("r", 
                                          "http://www.tutortutor.ca/",
                                          "recipe");
         xmlew.add(event);
         event = xmlef.createStartElement("r", 
                                          "http://www.tutortutor.ca/",
                                          "title");
         xmlew.add(event);
         event = xmlef.createCharacters("Grilled Cheese Sandwich");
         xmlew.add(event);
         event = xmlef.createEndElement("r", 
                                        "http://www.tutortutor.ca/",
                                        "title");
         xmlew.add(event);
         event = xmlef.createStartElement("r", 
                                          "http://www.tutortutor.ca/",
                                          "ingredients");
         xmlew.add(event);
         event = xmlef.createStartElement("h", 
                                          "http://www.w3.org/1999/xhtml",
                                          "ul");
         xmlew.add(event);
         event = xmlef.createStartElement("h", 
                                          "http://www.w3.org/1999/xhtml",
                                          "li");
         xmlew.add(event);
         Iterator<Attribute> attrIter;
         attrIter = new Iterator<Attribute>()
         {
            int index = 0;
            Attribute[] attrs;
            {
               attrs = new Attribute[1];
               attrs[0] = xmlef.createAttribute("qty", "2");
            }
            @Override
            public boolean hasNext()
            {
               return index != 1;
            }
            @Override
            public Attribute next()
            {
               return attrs[index++];
            }
            @Override
            public void remove()
            {
               throw new UnsupportedOperationException();
            }
         };
         event = xmlef.createStartElement("r", 
                                          "http://www.tutortutor.ca/",
                                          "ingredient", attrIter, null);
         xmlew.add(event);
         event = xmlef.createCharacters("bread slice");
         xmlew.add(event);
         event = xmlef.createEndElement("r", 
                                        "http://www.tutortutor.ca/",
                                        "ingredient");
         xmlew.add(event);
         event = xmlef.createEndElement("h", 
                                        "http://www.w3.org/1999/xhtml",
                                        "li");
         xmlew.add(event);
         event = xmlef.createEndElement("h", 
                                        "http://www.w3.org/1999/xhtml",
                                        "ul");
         xmlew.add(event);
         event = xmlef.createEndElement("r", 
                                        "http://www.tutortutor.ca/",
                                        "ingredients");
         xmlew.add(event);
         event = xmlef.createEndElement("r", 
                                        "http://www.tutortutor.ca/",
                                        "recipe");
         xmlew.add(event);
         event = xmlef.createEndElement("h", 
                                        "http://www.w3.org/1999/xhtml",
                                        "body");
         xmlew.add(event);
         event = xmlef.createEndElement("h", 
                                        "http://www.w3.org/1999/xhtml",
                                        "html");
         xmlew.add(event);
         xmlew.flush();
         xmlew.close();
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