package aula1.ex2;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class ex22
{
	static LinkedList<Pessoa> pessoas;
	static Scanner s;
	public static void main(String[] args) 
	{
		int c=0;
		s= new Scanner(System.in);
		pessoas = new LinkedList<Pessoa>();
		do 
		{
			System.out.print("1-Nova Pessoa\n2-Apagar Pessoa\n3-Lista de Pessoas\n"
					+ "4-Ordenar pessoas por nome\n5-Ordenar pessoas por CC\n6-SAIR\n");	
			c= s.nextInt();
			switch(c)
			{
				case 1:
					adPessoa();
					break;
				case 2:
					remPessoa();
					break;
				case 3:
					mostraPessoas();
					break;
				case 4:
					ordenaCC();
					break;
				case 5:
					ordenaNomes();
					break;
				case 6:
					System.exit(0);
					break;
			}
		}while(c!=6);
		s.close();
	}
	public static void adPessoa() 
	{
		s = new Scanner(System.in);
		System.out.println("Nova pessoa");
		System.out.print("Nome -> ");
		
		String nome = s.nextLine();
		
		System.out.print("CC -> ");
		int cc = Integer.parseInt(s.nextLine());
		
		System.out.print("Data de Nascimento (DD/MM/YYYY) -> ");
		String date = s.nextLine();
		
		pessoas.add(new Pessoa(nome, cc, new Data(date)));
		
		System.out.println("Pessoa adicinada");
	}
	public static void remPessoa() 
	{
		s = new Scanner(System.in);
		System.out.println("Remover pessoa");
		System.out.print("CC -> ");
		int cc = Integer.parseInt(s.nextLine());
		boolean encontra = false;
		
		for(int i = 0; i < pessoas.size(); i++)
		{
			if(pessoas.get(i).GetCC() == cc)
			{
				pessoas.remove(i);	
				encontra = true;
			}
		}
		
		if(encontra)
		{	
			System.out.println("Pessoa removida");
		}
		else 
		{	
			System.out.println("Person não existe");	
	
		}
	}
	public static void mostraPessoas() 
	{
		System.out.println("Lista de Pessoas");
		
		for(int i = 0; i < pessoas.size(); i++)
		{
			
			System.out.println(pessoas.get(i).toString());
		}
	}
	public static void ordenaNomes()
	{
		pessoas.sort(Comparator.comparing(Pessoa::GetName));
	}
	public static void ordenaCC() 
	{
		pessoas.sort(Comparator.comparing(Pessoa::GetCC));
	}
	
}