import com.google.gson.Gson;

public class GsonDemo
{
   public static void main(String[] args)
   {
      Gson gson = new Gson();
      String name = gson.fromJson("\"John Doe\"", String.class);
      System.out.println(name);
      gson.toJson(256, System.out);
   }
}