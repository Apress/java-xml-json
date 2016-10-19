import java.text.ParsePosition;
import java.text.SimpleDateFormat;

import java.util.List;

import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathFunctionException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Date implements XPathFunction
{
   private final static ParsePosition POS = new ParsePosition(0);

   private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

   @Override
   public Object evaluate(List args) throws XPathFunctionException
   {
      if (args.size() != 1)
         throw new XPathFunctionException("Invalid number of arguments");
      String value;
      Object o = args.get(0);
      if (o instanceof NodeList)
      {
         NodeList list = (NodeList) o;
         value = list.item(0).getTextContent();
      }
      else
      if (o instanceof String)
         value = (String) o;
      else
         throw new XPathFunctionException("Cannot convert argument type");
      POS.setIndex(0);
      return sdf.parse(value, POS).getTime();
   }
}