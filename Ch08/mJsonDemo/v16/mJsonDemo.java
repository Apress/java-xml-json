import java.net.URI;
import java.net.URISyntaxException;

import mjson.Json;

public class mJsonDemo
{
   public static void main(String[] args) throws URISyntaxException
   {
      Json.Schema schema = 
         Json.schema(new URI("http://tutortutor.ca/schema.json"));
      Json json = Json.read("{\"name\": \"John Doe\", \"age\": 35}");
      System.out.println(schema.validate(json));
      json = Json.read("{\"name\": \"John Doe\", \"age\": 65}");
      System.out.println(schema.validate(json));
      json = Json.read("{\"name\": \"John Doe\", \"age\": \"35\"}");
      System.out.println(schema.validate(json));
      json = Json.read("{\"age\": 35}");
      System.out.println(schema.validate(json));
   }
}