import java.lang.reflect.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;

import java.util.Arrays;
import java.util.List;

public class GsonDemo
{
   static 
   class Vehicle<T>
   {
      T vehicle;

      T get()
      {
         return vehicle;
      }

      void set(T vehicle)
      {
         this.vehicle = vehicle;
      }

      @Override
      public String toString()
      {
         System.out.printf("Class of vehicle: %s%n", vehicle.getClass());
         return "Vehicle: " + vehicle.toString();
      }
   }

   static
   class Truck
   {
      String make;
      String model;

      Truck(String make, String model)
      {
         this.make = make;
         this.model = model;
      }

      @Override
      public String toString()
      {
         return "Make: " + make + " Model: " + model;
      }
   }

   public static void main(String[] args)
   {
      Gson gson = new Gson();

      // ...

      System.out.printf("PART 1%n");
      System.out.printf("------%n%n");

      List<String> weekdays = Arrays.asList("Sun", "Mon", "Tue", "Wed", 
                                            "Thu", "Fri", "Sat");
      String json = gson.toJson(weekdays);
      System.out.printf("%s%n%n", json);
      try
      {
         System.out.printf("%s%n%n", 
                           gson.fromJson(json, weekdays.getClass()));
      }
      catch (ClassCastException cce)
      {
         cce.printStackTrace();
         System.out.println();
      }
      Type listType = new TypeToken<List<String>>() {}.getType();
      System.out.printf("Type = %s%n%n", listType);
      try
      {
         System.out.printf("%s%n%n", gson.fromJson(json, listType));
      }
      catch (ClassCastException cce)
      {
         cce.printStackTrace();
         System.out.println();
      }
      System.out.printf("%s%n%n", (List) gson.fromJson(json, listType));

      // ...

      System.out.printf("PART 2%n");
      System.out.printf("------%n%n");
   
      Truck truck = new Truck("Ford", "F150");
      Vehicle<Truck> vehicle = new Vehicle<>();
      vehicle.set(truck);

      json = gson.toJson(vehicle);
      System.out.printf("%s%n%n", json);
      System.out.printf("%s%n%n", gson.fromJson(json, vehicle.getClass()));

      // ...

      System.out.printf("PART 3%n");
      System.out.printf("------%n%n");

      Map<String, String> map = new HashMap<String, String>() 
      {
         {
            put("key", "value");
         }
      };
      System.out.printf("Map = %s%n%n", map);
      System.out.printf("%s%n%n", gson.toJson(map));
      System.out.printf("%s%n%n", gson.fromJson(gson.toJson(map), 
                                                map.getClass()));

      // ...

      System.out.printf("PART 4%n");
      System.out.printf("------%n%n");

      Type vehicleType = new TypeToken<Vehicle<Truck>>() {}.getType();
      json = gson.toJson(vehicle, vehicleType);
      System.out.printf("%s%n%n", json);
      System.out.printf("%s%n%n", 
                        (Vehicle) gson.fromJson(json, vehicleType));

      Type mapType = new TypeToken<Map<String,String>>() {}.getType();
      System.out.printf("%s%n%n", gson.toJson(map, mapType));
      System.out.printf("%s%n%n", 
                        (Map) gson.fromJson(gson.toJson(map, mapType), 
                                            mapType));
   }
}