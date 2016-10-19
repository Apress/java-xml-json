import mjson.Json;

public class mJsonDemo
{
   public static void main(String[] args)
   {
      String jsonStr =
      "{" +
      "\"firstName\": \"John\"," +
      "\"courses\":" +
      "[\"English\"]" +
      "}";
      Json json = Json.read(jsonStr);
      System.out.println(json);
      System.out.println();
      Json jsono = Json.read("{\"initial\": \"P\", \"lastName\": \"Doe\"}");
      Json jsona = Json.read("[\"French\", \"Spanish\"]");
      json.with(jsono);
      System.out.println(json);
      System.out.println();
      json.at("courses").with(jsona);
      System.out.println(json);
   }
}