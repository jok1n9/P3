package aula11.c;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;



public class TextCount {
	public static void main(String[] args) throws IOException 
	{
		
		
		HashMap<String, Integer> a= new HashMap<String, Integer>();
		
		ArrayList<String> fileLines = new ArrayList<String>(Files.readAllLines(Paths.get("Policarpo.txt")));
		for(String f: fileLines)
		{
			for(String word: f.split(" ")) 
			{
				word=  word.replaceAll("[^a-zA-Z0-9Á·‡ÈÌÛ˙„‚Í]", ""); 
				if(a.containsKey(word)) a.replace(word, a.get(word)+1) ;
				else a.put(word, 1);
		
			}
		}
		
		System.out.println("Contagem de palavras");
		
		//descomentar para ordenar alfabÈticamente(Alpha) e por quantidade
		
		for(String p: a.keySet()) 
		{
			System.out.printf("%25s: %5d\n", p, a.get(p));
		}
		printSortedAlpha(a);
		printSorted(a);
		
		
	}
	public static void printSortedAlpha(HashMap<String, Integer> a) 
	{
		ArrayList<String> lista = new ArrayList<String>(a.keySet()) ; 
		Collections.sort(lista);
		System.out.println("Ordenadas por ordem alfabÈtica");
		for(String p: lista) 
		{
			System.out.printf("%10s: %5d\n", p, a.get(p));
		}
	}
	public static void printSorted(HashMap<String, Integer> a) 
	{
		ArrayList<String> lista = new ArrayList<String>(a.keySet()) ; 
		Collections.sort(lista, new Comparator<String>() {
		    @Override
		    public int compare(String lhs, String rhs) {
		        return a.get(lhs) > a.get(rhs) ? -1 : (a.get(lhs) < a.get(rhs)) ? 1 : 0;
		    }
		});
		
		System.out.println("Ordenadas por quantidade");
		for(String p: lista) 
		{
			System.out.printf("%10s: %5d\n", p, a.get(p));
		}
	}
	
}