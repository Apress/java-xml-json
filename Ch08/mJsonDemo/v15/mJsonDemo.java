import mjson.Json;

public class mJsonDemo
{
   public static void main(String[] args)
   {
      // A simple schema that accepts only JSON objects with a mandatory 
      // property 'id'.
      Json.Schema schema = Json.schema(Json.object("type", "object", 
                                                   "required",
                                                   Json.array("id")));
      System.out.println(schema.validate(Json.object("id", 666, "name", 
                                                     "Britlan")));
      System.out.println(schema.validate(Json.object("ID", 666, "name", 
                                                     "Britlan")));
   }
}