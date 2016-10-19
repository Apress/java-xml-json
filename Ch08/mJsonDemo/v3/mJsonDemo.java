import mjson.Json;

public class mJsonDemo
{
   public static void main(String[] args)
   {
      Json jsonAddress = 
         Json.object("streetAddress", "21 2nd Street",
                     "city", "New York",
                     "state", "NY",
                     "postalCode", "10021-3100");
      Json jsonPhone1 =
         Json.object("type", "home",
                     "number", "212 555-1234");
      Json jsonPhone2 = 
         Json.object("type", "office",
                     "number", "646 555-4567");
      Json jsonPerson =
         Json.object("firstName", "John",
                     "lastName", "Smith",
                     "isAlive", true,
                     "age", 25,
                     "address", jsonAddress,
                     "phoneNumbers", Json.array(jsonPhone1, jsonPhone2),
                     "children", Json.array(),
                     "spouse", Json.nil());
      System.out.println(jsonPerson);
   }
}