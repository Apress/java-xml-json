import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.SAXException;

public class DOMSearch
{
   public static void main(String[] args)
   {
      if (args.length != 1)
      {
         System.err.println("usage: java DOMSearch publisher");
         return;
      }

      try
      {
         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
         DocumentBuilder db = dbf.newDocumentBuilder();
         Document doc = db.parse("books.xml");
         class BookItem
         {
            String title;
            String isbn;
         }
         List<BookItem> bookItems = new ArrayList<BookItem>();
         NodeList books = doc.getElementsByTagName("book");
         for (int i = 0; i < books.getLength(); i++)
         {
            Element book = (Element) books.item(i);
            NodeList children = book.getChildNodes();
            String title = "";
            for (int j = 0; j < children.getLength(); j++)
            {
               Node child = children.item(j);
               if (child.getNodeType() == Node.ELEMENT_NODE)
               {
                  if (child.getNodeName().equals("title"))
                     title = child.getFirstChild().getNodeValue().trim();
                  else
                  if (child.getNodeName().equals("publisher"))
                  {
                     // Compare publisher name argument (args[0]) with text 
                     // of publisher's child text node. The trim() method 
                     // call removes whitespace that would interfere with 
                     // the comparison.
                     if (args[0].equals(child.getFirstChild().
                                        getNodeValue().trim()))
                     {
                        BookItem bookItem = new BookItem();
                        bookItem.title = title;
                        NamedNodeMap nnm = book.getAttributes();
                        Node isbn = nnm.getNamedItem("isbn");
                        bookItem.isbn = isbn.getNodeValue();
                        bookItems.add(bookItem);
                        break;
                     }
                  }
               }
            }
         }
         for (BookItem bookItem: bookItems)
            System.out.println("title = " + bookItem.title + ", isbn = " +
                               bookItem.isbn);
      }
      catch (IOException ioe)
      {
         System.err.println("IOE: " + ioe);
      }
      catch (SAXException saxe)
      {
         System.err.println("SAXE: " + saxe);
      }
      catch (FactoryConfigurationError fce)
      {
         System.err.println("FCE: " + fce);
      }
      catch (ParserConfigurationException pce)
      {
         System.err.println("PCE: " + pce);
      }
   }
}