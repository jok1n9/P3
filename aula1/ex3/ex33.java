package aula1.ex3;

import java.util.Scanner;

public class ex33 
{
	static Scanner s;
	public static void main(String[] args) 
	{
		s= new Scanner(System.in);
		int a=0;
		do {
			System.out.print("1-Circulo\n2-Retangulo\n3-Quadrado\n4-exit\n");
			a= s.nextInt();
			switch(a) {
				case 1:
					circulo();
					break;
				case 2:
					retangulo();
					break;
				case 3:
					quadrado();
					break;
				case 4:
					System.exit(0);
					break;	
			}
		}while(a!=4);

	}
	public static void circulo() 
	{
		double x, y, raio;
		s= new Scanner(System.in);
		System.out.println("Circulo");
		System.out.print("coordenadas\n");
		System.out.print("x:");
		x= s.nextDouble();
		System.out.print("y:");
		y= s.nextDouble();
		System.out.print("raio:");
		raio= s.nextDouble();
		Circulo a= new Circulo(x, y , raio);
		System.out.print(a.toString());
		
	}
	public static void quadrado() 
	{
		s= new Scanner(System.in);
		double x, y;
		Ponto[] a= new Ponto[4];
		System.out.println("Quadrado");
		System.out.print("coordenadas dos 4 vertices\n");
		for(int i=0; i<4; i++) {
			System.out.printf("Ponto %d \n", i+1);
			System.out.print("x: ");
			x=s.nextDouble();
			System.out.print("y: ");
			y=s.nextDouble();
			a[i]= new Ponto(x,y);
		}
		Quadrado b= new Quadrado(a[0], a[1], a[2], a[3]);
		System.out.print(b.toString());
	}
	public static void retangulo() 
	{
		s= new Scanner(System.in);
		double x, y;
		Ponto[] a= new Ponto[4];
		System.out.println("Quadrado");
		System.out.print("coordenadas dos 4 vertices\n");
		for(int i=0; i<4; i++) {
			System.out.printf("Ponto %d \n", i+1);
			System.out.print("x: ");
			x=s.nextDouble();
			System.out.print("y: ");
			y=s.nextDouble();
			a[i]= new Ponto(x,y);
		}
		Quadrado b= new Quadrado(a[0], a[1], a[2], a[3]);
		System.out.print(b.toString());
	}
}	
