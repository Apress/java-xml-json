import com.google.gson.Gson;

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
      Gson gson = new Gson();
      String json = "{ name: \"John Doe\", age: 45 }";
      Person person = gson.fromJson(json, Person.class);
      System.out.println(person);
   }
}