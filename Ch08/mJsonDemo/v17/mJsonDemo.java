import java.util.List;

import mjson.Json;

public class mJsonDemo
{
   public static void main(String[] args)
   {
      class MyFactory extends Json.DefaultFactory
      {
         @Override
         public Json string(String x)
         {
            // Obtain the StringJson instance.
            final Json json = super.string(x);

            class StringIJson extends Json
            {
               private static final long serialVersionUID = 1L;
		
               String val;

               StringIJson(String val) 
               { 
                  this.val = val; 
               }

               @Override
               public byte asByte() 
               { 
                  return json.asByte();
               }

               @Override
               public char asChar() 
               { 
                  return json.asChar();
               }

               @Override
               public double asDouble() 
               { 
                  return json.asDouble();
               }

               @Override
               public float asFloat() 
               { 
                  return json.asFloat();
               }

               @Override
               public int asInteger() 
               { 
                  return json.asInteger();
               }

               @Override
               public List<Object> asList() 
               { 
                  return json.asList();
               }

               @Override
               public long asLong() 
               { 
                  return json.asLong();
               }

               @Override
               public short asShort() 
               { 
                  return json.asShort();
               }

               @Override
               public String asString() 
               { 
                  return json.asString(); 
               }

               @Override
               public Json dup() 
               { 
                  return json.dup();
               }

               @Override
               public boolean equals(Object x)
               {
                  return x instanceof StringIJson &&
                         ((StringIJson) x).val.equalsIgnoreCase(val);
               }

               @Override
               public Object getValue() 
               { 
                  return json.getValue(); 
               }

               @Override
               public int hashCode() 
               { 
                  return json.hashCode();
               }

               @Override
               public boolean isString() 
               {
                  return json.isString();
               }

               @Override
               public String toString()
               {
                  return json.toString();
               }
            }
            return new StringIJson(x);
         }
      }

      Json.setGlobalFactory(new MyFactory());
      Json json1 = Json.read("\"abc\"");
      Json json2 = Json.read("\"abc\"");
      Json json3 = Json.read("\"Abc\"");
      System.out.println(json1.equals(json2));
      System.out.println(json1.equals(json3));

   }
}