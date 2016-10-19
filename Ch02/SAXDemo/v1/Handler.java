import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXParseException;

import org.xml.sax.ext.DefaultHandler2;

public class Handler extends DefaultHandler2
{
   private Locator locator;

   @Override
   public void characters(char[] ch, int start, int length)
   {
      System.out.print("characters() [");
      for (int i = start; i < start + length; i++)
         System.out.print(ch[i]);
      System.out.println("]");
   }

   @Override
   public void comment(char[] ch, int start, int length)
   {
      System.out.print("characters() [");
      for (int i = start; i < start + length; i++)
         System.out.print(ch[i]);
      System.out.println("]");
   }

   @Override
   public void endCDATA()
   {
      System.out.println("endCDATA()");
   }

   @Override
   public void endDocument()
   {
      System.out.println("endDocument()");
   }

   @Override
   public void endDTD()
   {
      System.out.println("endDTD()");
   }

   @Override
   public void endElement(String uri, String localName, String qName)
   {
      System.out.print("endElement() ");
      System.out.print("uri=[" + uri + "], ");
      System.out.print("localName=[" + localName + "], ");
      System.out.println("qName=[" + qName + "]");
   }

   @Override
   public void endEntity(String name)
   {
      System.out.print("endEntity() ");
      System.out.println("name=[" + name + "]");
   }

   @Override
   public void endPrefixMapping(String prefix)
   {
      System.out.print("endPrefixMapping() ");
      System.out.println("prefix=[" + prefix + "]");
   }

   @Override
   public void error(SAXParseException saxpe)
   {
      System.out.println("error() " + saxpe);
   }

   @Override
   public void fatalError(SAXParseException saxpe)
   {
      System.out.println("fatalError() " + saxpe);
   }

   @Override
   public void ignorableWhitespace(char[] ch, int start, int length)
   {
      System.out.print("ignorableWhitespace() [");
      for (int i = start; i < start + length; i++)
         System.out.print(ch[i]);
      System.out.println("]");
   }

   @Override
   public void notationDecl(String name, String publicId, String systemId)
   {
      System.out.print("notationDecl() ");
      System.out.print("name=[" + name + "]");
      System.out.print("publicId=[" + publicId + "]");
      System.out.println("systemId=[" + systemId + "]");
   }

   @Override
   public void processingInstruction(String target, String data)
   {
      System.out.print("processingInstruction() [");
      System.out.println("target=[" + target + "]");
      System.out.println("data=[" + data + "]");
   }

   @Override
   public InputSource resolveEntity(String publicId, String systemId)
   {
      System.out.print("resolveEntity() ");
      System.out.print("publicId=[" + publicId + "]");
      System.out.println("systemId=[" + systemId + "]");
      // Do not perform a remapping.
      InputSource is = new InputSource();
      is.setPublicId(publicId);
      is.setSystemId(systemId);
      return is;
   }

   @Override
   public void setDocumentLocator(Locator locator)
   {
      System.out.print("setDocumentLocator() ");
      System.out.println("locator=[" + locator + "]");
      this.locator = locator;
   }

   @Override
   public void skippedEntity(String name)
   {
      System.out.print("skippedEntity() ");
      System.out.println("name=[" + name + "]");
   }

   @Override
   public void startCDATA()
   {
      System.out.println("startCDATA()");
   }

   @Override
   public void startDocument()
   {
      System.out.println("startDocument()");
   }

   @Override
   public void startDTD(String name, String publicId, String systemId)
   {
      System.out.print("startDTD() ");
      System.out.print("name=[" + name + "]");
      System.out.print("publicId=[" + publicId + "]");
      System.out.println("systemId=[" + systemId + "]");
   }

   @Override
   public void startElement(String uri, String localName, String qName,
                            Attributes attributes)
   {
      System.out.print("startElement() ");
      System.out.print("uri=[" + uri + "], ");
      System.out.print("localName=[" + localName + "], ");
      System.out.println("qName=[" + qName + "]");
      for (int i = 0; i < attributes.getLength(); i++)
         System.out.println("  Attribute: " + attributes.getLocalName(i) + 
                            ", " + attributes.getValue(i));
      System.out.println("Column number=[" + locator.getColumnNumber() + 
                         "]");
      System.out.println("Line number=[" + locator.getLineNumber() + "]");
   }

   @Override
   public void startEntity(String name)
   {
      System.out.print("startEntity() ");
      System.out.println("name=[" + name + "]");
   }

   @Override
   public void startPrefixMapping(String prefix, String uri)
   {
      System.out.print("startPrefixMapping() ");
      System.out.print("prefix=[" + prefix + "]");
      System.out.println("uri=[" + uri + "]");
   }

   @Override
   public void unparsedEntityDecl(String name, String publicId,
                                  String systemId, String notationName)
   {
      System.out.print("unparsedEntityDecl() ");
      System.out.print("name=[" + name + "]");
      System.out.print("publicId=[" + publicId + "]");
      System.out.print("systemId=[" + systemId + "]");
      System.out.println("notationName=[" + notationName + "]");
   }

   @Override
   public void warning(SAXParseException saxpe)
   {
      System.out.println("warning() " + saxpe);
   }
}