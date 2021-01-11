package aula12.ex1;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;


public class Text {
	public static void main(String[] args) throws IOException 
	{
		
		HashMap<String, Integer> a= new HashMap<String, Integer>();
		TreeMap<String, Integer> b= new TreeMap<String, Integer>();
		
		ArrayList<String> fileLines = new ArrayList<String>(Files.readAllLines(Paths.get("texto.txt")));
		for(String f: fileLines)
		{
			for(String word: f.split(" ")) 
			{
				word=  word.replaceAll("[^a-zA-Z0-9çáàéíóúãâê]", ""); 
				if(a.containsKey(word)) 
				{
					a.put(word, a.get(word)+1);
					b.put(word, a.get(word)+1);
				}
				else {
					a.put(word,0);
					b.put(word, 0);
				}
			}
		}
		a.forEach((k,v) -> {System.out.println(k + " : " + v);});
		System.out.println("Número total de palavras: "+ a.values().stream().reduce(0, (total, number)->total + number));
		System.out.println("Número de palavras diferentes: " + a.keySet().size());
		System.out.println("----------------------");
		b.keySet().stream().sorted((s1, s2) -> s1.compareTo(s2));
		b.forEach((k,v) -> System.out.println(k + " : " + v));
	}
}
