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
      System.out.println("Value = " + json.getValue());
      System.out.println();
      classify(json);
   }

   static void classify(Json jsonObject)
   {
      if (jsonObject.isArray())
         System.out.println("Array");
      else
      if (jsonObject.isBoolean())
         System.out.println("Boolean");
      else
      if (jsonObject.isNull())
         System.out.println("Null");
      else
      if (jsonObject.isNumber())
         System.out.println("Number");
      else
      if (jsonObject.isObject())
         System.out.println("Object");
      else
      if (jsonObject.isString())
         System.out.println("String");
      if (jsonObject.isPrimitive())
         System.out.println("Primitive");
   }
}