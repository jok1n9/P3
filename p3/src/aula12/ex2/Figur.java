package aula12.ex2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import aula5.ex1.Circle;
import aula5.ex1.Figure;
import aula5.ex1.Rectangle;
import aula5.ex1.Square;
public class Figur {

	public static void main(String[] args) {
		
		ArrayList<Figure> a= new ArrayList<Figure>();
		a.add(new Circle(2));
		a.add(new Circle(1, 3, 2));
		a.add(new Square(2));
		a.add(new Square(3, 4, 2));
		a.add(new Rectangle(2, 3));
		System.out.println("Maior Figura \n" + maior(a)+ "\n");
		System.out.println("Maior Perimetro \n" + maiorperimetro(a)+ "\n");
		System.out.println("Area total \n" + area(a)+ "\n");
		System.out.println("Area total dos quadrados\n" + area(a, "Square") + "\n");
	}
	private static Figure maior(ArrayList<Figure> list)
	{
		return list.stream().sorted((f1, f2) -> f1.compareTo(f2)).collect(Collectors.toList()).get(list.size() - 1);
	}
	private static Figure maiorperimetro(ArrayList<Figure> list)
	{
		return list.stream().sorted(Comparator.comparingDouble(Figure::getPerimeter) ).collect(Collectors.toList()).get(list.size() - 1);
	}
	private static double area(ArrayList<Figure> list)
	{
		return list.stream().mapToDouble(Figure::getArea).sum();
	}
	
	private static double area(ArrayList<Figure> list, String type)
	{
		return list.stream().filter((k) -> k.getClass().getSimpleName().equals(type)).mapToDouble(Figure::getArea).sum();
	}
}
