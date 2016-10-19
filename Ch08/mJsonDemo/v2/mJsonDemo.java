import mjson.Json;

public class mJsonDemo
{
   public static void main(String[] args)
   {
      Json json = Json.read("[4, 5, {}, true, null, \"ABC\", 6]");
      System.out.println(json);
   }
}