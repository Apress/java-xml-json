import java.io.FileReader;
import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class RunScript
{
   public static void main(String[] args)
   {
      if (args.length != 1)
      {
         System.err.println("usage: java RunScript script");
         return;
      }
      ScriptEngineManager manager = new ScriptEngineManager();
      ScriptEngine engine = manager.getEngineByName("nashorn");
      try
      {
         engine.eval(new FileReader(args[0]));
      }
      catch (ScriptException se)
      {
         System.err.println(se.getMessage());
      }
      catch (IOException ioe)
      {
         System.err.println(ioe.getMessage());
      }      
   }
}