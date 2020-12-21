package aula11.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import aula3.ex1.*;
import aula5.ex1.*;


public abstract class TestList{
	public static void main(String[] args) {
		LinkedList<Person> vp = new LinkedList<Person>();
		for (int i=0; i<10; i++)
			vp.add(new Person("Bebé no Vector "+i,
					1000+i, Date.today()));
		Iterator<Person> vec = vp.iterator();
		printSet(vp.iterator());
		LinkedList<Person> lp = new LinkedList<Person>();
		while ( vec.hasNext() )
			lp.add( vec.next() );
		Iterator<Person> lista = lp.iterator();
		while ( lista.hasNext() )
			System.out.println( lista.next() );
		ArrayList<Figure> figList = new ArrayList<Figure>();
		figList.add(new Circle (1,3, 1));
		figList.add(new Square(3,4, 2));
		figList.add(new Rectangle(1,2, 2,5));
		printSet(figList.iterator());
		System.out.println("Soma da Area de Lista de Figuras: " +
							sumArea(figList));
		// Partindo do principio que Quadrado extends Rectangulo:
		ArrayList< Rectangle > quadList =
				new ArrayList<Rectangle>();
		quadList.add(new Square(3,4, 2));
		quadList.add(new Rectangle(1,2, 2,5));
		System.out.println("Soma da Area de Lista de Quadrados: " +
							sumArea(quadList));
	}

	
	public static<T extends Figure> double sumArea(ArrayList<T> list)
	{
		
		double area = 0;
		
		for(Figure f : list)
		{
			area += f.getArea();
		}
		
		return area;
	}
	
	public static void printSet(Iterator set)
	{
		do
		{
			System.out.println(set.next());
		}
		while(set.hasNext());
	}
}