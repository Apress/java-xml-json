import java.util.HashMap;
import java.util.Map;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class LocalRecipeML implements EntityResolver
{
   private Map<String, String> mappings = new HashMap<>();

   LocalRecipeML()
   {
      mappings.put("-//FormatData//DTD RecipeML 0.5//EN", "recipeml.dtd");
   }

   @Override
   public InputSource resolveEntity(String publicId, String systemId)
   {
      if (mappings.containsKey(publicId))
      {
         System.out.println("obtaining cached recipeml.dtd");
         systemId = mappings.get(publicId);
         InputSource localSource = new InputSource(systemId);
         return localSource;
      }
      return null;
   }
}