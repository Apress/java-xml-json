import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class GsonDemo
{
   static class Date
   {
      int year;
      int month;
      int day;

      Date(int year, int month, int day)
      {
         this.year = year;
         this.month = month;
         this.day = day;
      }
   }

   static class Employee
   {
      String name;
      Date hireDate;
   }

   public static void main(String[] args)
   {
      Employee e = new Employee();
      e.name = "John Doe";
      e.hireDate = new Date(1982, 10, 12);
      GsonBuilder gb = new GsonBuilder();
      class EmployeeSerializer implements JsonSerializer<Employee>
      {
         @Override
         public JsonElement serialize(Employee emp, Type typeOfSrc,
                                      JsonSerializationContext context)
         {
            JsonObject jo = new JsonObject();
            jo.addProperty("emp-name", emp.name);
            jo.add("hire-date", context.serialize(emp.hireDate));
            return jo;
         }
      }
      gb.registerTypeAdapter(Employee.class, new EmployeeSerializer());
      Gson gson = gb.create();
      System.out.printf("%s%n%n", gson.toJson(e));
   }
}