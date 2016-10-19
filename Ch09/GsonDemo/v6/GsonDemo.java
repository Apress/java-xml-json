import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class GsonDemo
{
   public static void main(String[] args)
   {
      class BookSerializer implements JsonSerializer<Book>
      {
         @Override
         public JsonElement serialize(Book src, Type typeOfSrc, 
                                      JsonSerializationContext context)
         {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("title", src.getTitle());
            jsonObject.addProperty("lead-author", src.getAuthors()[0]);
            JsonArray jsonOtherAuthors = new JsonArray();
            for (int i = 1; i < src.getAuthors().length; i++)
            {
               JsonPrimitive jsonAuthor = 
                  new JsonPrimitive(src.getAuthors()[i]);
               jsonOtherAuthors.add(jsonAuthor);
            }
            jsonObject.add("other-authors", jsonOtherAuthors);
            jsonObject.addProperty("isbn-10", src.getIsbn10());
            jsonObject.addProperty("isbn-13", src.getIsbn13());
            return jsonObject;
         }
      }
      GsonBuilder gsonBuilder = new GsonBuilder();
      gsonBuilder.registerTypeAdapter(Book.class, new BookSerializer());
      Gson gson = gsonBuilder.setPrettyPrinting().create();
      Book book = new Book("PHP and MySQL Web Development, Second Edition",
                           new String[] { "Luke Welling",
                                          "Laura Thomson" },
                           "067232525X", "075-2063325254");
      System.out.println(gson.toJson(book));
   }
}