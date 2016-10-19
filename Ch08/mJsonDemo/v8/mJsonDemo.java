import mjson.Json;

public class mJsonDemo
{
   public static void main(String[] args)
   {
      String jsonStr =
      "{" +
      "\"firstName\": \"John\"," +
      "\"lastName\": \"Smith\"," +
      "\"isAlive\": true," +
      "\"age\": 25," +
      "\"address\":" +
      "{" +
      "\"streetAddress\": \"21 2nd Street\"," +
      "\"city\": \"New York\"," +
      "\"state\": \"NY\"," +
      "\"postalCode\": \"10021-3100\"" +
      "}," +
      "\"phoneNumbers\":" +
      "[" +
      "{" +
      "\"type\": \"home\"," +
      "\"number\": \"212 555-1234\"" +
      "}," +
      "{" +
      "\"type\": \"office\"," +
      "\"number\": \"646 555-4567\"" +
      "}" +
      "]," +
      "\"children\": []," +
      "\"spouse\": null" +
      "}";
      Json json = Json.read(jsonStr);
      Json jsonChildren = json.at("children");
      System.out.printf("Children = %s%n", jsonChildren);
      System.out.printf("Array length = %d%n", jsonChildren.asList().size());
      // The following code throws IndexOutOfBoundsException.
//      System.out.println(jsonChildren.at(0));
      System.out.println(json.has("firstName"));
      System.out.println(json.has("middleName"));
   }
}