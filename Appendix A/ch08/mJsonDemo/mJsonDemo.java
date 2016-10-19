import mjson.Json;

public class mJsonDemo
{
   public static void main(String[] args)
   {
      Json json1 = Json.read("{\"name\": \"John Doe\"}");
      Json json2 = json1.dup();
      System.out.println(json1);
      System.out.println();
      System.out.println(json2);
      System.out.println();
      System.out.printf("json1 == json2: %b%n", json1 == json2);
      System.out.printf("json1.equals(json2): %b%n", json1.equals(json2));
      System.out.println();
      System.out.println(json1.pad("func"));

      /*
         The following output is generated:

         {"name":"John Doe"}

         {"name":"John Doe"}

         json1 == json2: false
         json1.equals(json2): true

         func({"name":"John Doe"});
      */   
   }
}