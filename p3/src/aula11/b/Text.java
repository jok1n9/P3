package aula11.b;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Text {
	public static void main(String[] args) throws IOException 
	{
		String word;
		int nrepetidas=0;
		int total=0;
		File file = new File("texto.txt");
		HashSet<String> a= new HashSet<String>();
		Scanner input= new Scanner(file);
		while(input.hasNext()) 
		{
			word= input.next();
			
			if(a.contains(word)) total++;
			else 
			{
				total++;
				a.add(word);
				nrepetidas++;
			}
		}
		System.out.println("Número total de palavras: "+ total);
		System.out.println("Número de palavras diferentes: " +nrepetidas);
		
		input.close();
	}
}
