import java.util.Iterator;

import javax.xml.XMLConstants;

import javax.xml.namespace.NamespaceContext;

public class NSContext implements NamespaceContext
{
   @Override
   public String getNamespaceURI(String prefix)
   {
      if (prefix == null)
         throw new IllegalArgumentException("prefix is null");
      else
      if (prefix.equals("tt"))
         return "http://www.tutortutor.ca/";
      else
         return null;
   }

   @Override
   public String getPrefix(String uri)
   {
      return null;
   }

   @Override
   public Iterator getPrefixes(String uri)
   {
      return null;
   }
}