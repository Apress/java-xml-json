import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class GsonDemo
{
   static class Person
   {
      String name;
      int age;

      Person(String name, int age)
      {
         this.name = name;
         this.age = age;
      }

      @Override
      public String toString()
      {
         return name + ": " + age;
      }
   }

   public static void main(String[] args)
   {
      class PersonDeserializer implements JsonDeserializer<Person>
      {
         @Override
         public Person deserialize(JsonElement json, Type typeOfT, 
                                   JsonDeserializationContext context) 
         {
            JsonObject jsonObject = json.getAsJsonObject();
            String firstName = jsonObject.get("first-name").getAsString();
            String lastName = jsonObject.get("last-name").getAsString();
            int age = jsonObject.getAsJsonPrimitive("age").getAsInt();
            String address = jsonObject.get("address").getAsString();
            return new Person(firstName + " " + lastName, 45);
         }
      }
      GsonBuilder gsonBuilder = new GsonBuilder();
      gsonBuilder.registerTypeAdapter(Person.class, 
                                      new PersonDeserializer());
      Gson gson = gsonBuilder.create();
      String json = "{ first-name: \"John\", last-name: \"Doe\", " +
                    "age: 45, address: \"Box 1\" }";
      Person person = gson.fromJson(json, Person.class);
      System.out.println(person);
   }
}