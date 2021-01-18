package aula13.reflection;
import aula13.ex2.IPlugin;




public class Root implements IPlugin
{
	public String eleva(String code)
	{
		try
		{
			Integer i = Integer.parseInt(code);
			return "Root -> " + Math.sqrt(i);
		}
		catch(NumberFormatException e)
		{
			System.out.println("Argument provided is not a number");
			System.exit(0);
			return null;
		}
	}
}