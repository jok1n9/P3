package aula6.ex2;
import java.util.List;
import java.util.ArrayList;
import aula3.ex1.Bolseiro;
import aula5.ex1.Figure;
import aula5.ex1.Circle;
import aula5.ex1.Square;
import aula5.ex1.Rectangle;
import aula3.ex1.Student;
import aula3.ex1.Date;
public class TestFilter {
		public static void main(String[] args) {
		 List<Figure> lista = new ArrayList<Figure>();
		 lista.add(new Circle(2)); lista.add(new Circle(1, 3, 1));
		 lista.add(new Square(5)); lista.add(new Square(3, 4, 2));
		 lista.add(new Rectangle(2, 3)); lista.add(new Rectangle(3, 4, 5, 3));
		 lista.add(new Rectangle(1, 1, 5, 6));
		 System.out.println("Figuras Filter 1:");
		 List<Figure> ret = ListsProcess.filter(lista, f -> f.getArea() > 20);
		 printList(ret);
		 System.out.println("\nFiguras Filter 2:");
		 ret = ListsProcess.filter(lista, f -> f.getPerimeter() < 15);
		 printList(ret);
		 System.out.println("\nFiguras Filter 3:");
		 ret = ListsProcess.filter(lista, f -> f.getPerimeter() < 15 && f.getArea() > 10);
		 printList(ret);
		 List<Student> lista2 = new ArrayList<Student>();
		 lista2.add(new Student("Andreia", 9855678, new Date(18, 7, 1974)));
		 lista2.add(new Student("Monica", 75266454, new Date(11, 8, 1978)));
		 lista2.add(new Student("Jose", 85265426, new Date(15, 2, 1976)));
		 lista2.add(new Bolseiro("Maria", 8976543, new Date(12, 5, 1976)));
		 lista2.add(new Bolseiro("Xico", 872356522, new Date(21, 4, 1975)));
		 System.out.println("\nEstudante Filter 1:");
		 List<Student> ret2 = ListsProcess.filter(lista2, e -> e.getNMec() < 103);
		 printList(ret2);

		 System.out.println("\nEstudante Filter 2:");
		 ret2 = ListsProcess.filter(lista2,
		e -> e.getClass().getSimpleName().equals("Bolseiro"));
		 printList(ret2);
		}
		private static <T> void printList(List<T> myList) {
		 for (T e : myList)
		System.out.println(e);
		}
}

