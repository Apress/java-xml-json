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
      System.out.printf("First name = %s%n", json.at("firstName"));
      System.out.printf("Last name = %s%n", json.at("lastName"));
      System.out.printf("Is alive = %s%n", json.at("isAlive"));
      System.out.printf("Age = %d%n", json.at("age").asInteger());
      System.out.println("Address");
      Json jsonAddr = json.at("address");
      System.out.printf("   Street address = %s%n", 
                        jsonAddr.at("streetAddress"));
      System.out.printf("   City = %s%n", jsonAddr.at("city"));
      System.out.printf("   State = %s%n", jsonAddr.at("state"));
      System.out.printf("   Postal code = %s%n",
                        jsonAddr.at("postalCode"));
      System.out.println("Phone Numbers");
      Json jsonPhone = json.at("phoneNumbers");
      System.out.printf("   Type = %s%n", jsonPhone.at(0).at("type"));
      System.out.printf("   Number = %s%n", jsonPhone.at(0).at("number"));
      System.out.println();
      System.out.printf("   Type = %s%n", jsonPhone.at(1).at("type"));
      System.out.printf("   Number = %s%n", jsonPhone.at(1).at("number"));
      Json jsonChildren = json.at("children");
      System.out.printf("Children = %s%n", jsonChildren);
      System.out.printf("Spouse = %s%n", json.at("spouse"));
   }
}