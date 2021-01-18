package aula13.reflection;
import aula13.ex2.IPlugin;



public class Square implements IPlugin
{
	public String eleva(String code)
	{
		try
		{
			Integer i = Integer.parseInt(code);
			return "Squared -> " + Math.pow(i, 2);
		}
		catch(NumberFormatException e)
		{
			System.out.println("Argument provided is not a number");
			System.exit(0);
			return null;
		}
	}
}