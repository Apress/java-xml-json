import mjson.Json;

public class mJsonDemo
{
   public static void main(String[] args)
   {
      String jsonStr =
      "{" +
      "\"name\": null," +
      "\"courses\":" +
      "[]" +
      "}";
      Json json = Json.read(jsonStr);
      System.out.println(json);
      System.out.println();
      json.set("name", "John Doe");
      Json jsonCourses = json.at("courses");
      jsonCourses.add("English");
      jsonCourses.add("French");
      System.out.println(json);
      System.out.println();
      jsonCourses.remove("English");
      System.out.println(json);
   }
}