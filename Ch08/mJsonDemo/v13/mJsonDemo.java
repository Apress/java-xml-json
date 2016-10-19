import mjson.Json;

public class mJsonDemo
{
   public static void main(String[] args)
   {
      String jsonStr =
      "{" +
      "\"firstName\": \"John\"," +
      "\"lastName\": \"Doe\"," +
      "\"courses\":" +
      "[\"English\", \"French\", \"Spanish\"]" +
      "}";
      Json json = Json.read(jsonStr);
      System.out.println(json);
      System.out.println();
      json.delAt("lastName");
      System.out.println(json);
      System.out.println();
      json.at("courses").delAt(1);
      System.out.println(json);
   }
}