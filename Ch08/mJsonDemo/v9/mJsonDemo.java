import mjson.Json;

public class mJsonDemo
{
   public static void main(String[] args)
   {
      String jsonStr =
      "{" +
      "\"propName\": \"propValue\"," +
      "\"propArray\":" +
      "[" +
      "{" +
      "\"element1\": \"value1\"" +
      "}," +
      "{" +
      "\"element2\": \"value2\"" +
      "}" +
      "]" +
      "}";
      Json json = Json.read(jsonStr);
      Json jsonElement1 = json.at("propArray").at(0);
      System.out.println(jsonElement1);
      System.out.println();
      System.out.println(jsonElement1.up());
      System.out.println();
      System.out.println(jsonElement1.up().up());
      System.out.println();
      System.out.println(jsonElement1.up().up().up());
   }
}