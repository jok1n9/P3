package aula1;

import java.util.Scanner;

public class ex11 {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		String f= s.nextLine();
		int a, u, l, w;
		a=0;
		u=0;
		l=0;
		w=0;
		boolean word=false;
		for(int i=0; i<f.length(); i++) 
		{
			if(i==(f.length()-1)&& word)
			{
				w++;
			}
			if(Character.isDigit(f.charAt(i)))
			{
				a++;
				word= true;
			}
			else if((Character.isUpperCase(f.charAt(i))))
			{
				u++;
				word=true;
			}
			else if((Character.isLowerCase(f.charAt(i))))
			{
				l++;
				word=true;
			}
			else if(Character.isWhitespace(f.charAt(i)) && word)
			{
				w++;
				word= false;
			}
			else if(Character.isDigit(f.charAt(i)))
			{
				a++;
				word= true;
			}
		}
		int p=0;
		String h="";
		while(p<f.length())
		{
			if(!Character.isWhitespace(f.charAt(p)) && !Character.isWhitespace(f.charAt(p+1)))
			{
				h+= String.valueOf(f.toCharArray()[p + 1]) + String.valueOf(f.toCharArray()[p]);
				p+=2;
			}
			else 
			{
				h=String.valueOf(f.charAt(p));
				p+=1;
			}
		}
		s.close();
		System.out.printf("Nº numbers: %d\nNº Upper: %d\nNº lower: %d\nNº words: %d\n" ,a, u, l,w );
		System.out.print(h);
	}
}

