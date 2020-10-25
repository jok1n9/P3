package aula3;

public class Teste2 {

	public static void main(String[] args) {
		Circle c1 = new Circle(2);
		Circle c2 = new Circle(1,3,2);
		Circle c3 = new Circle(c1);
		
		System.out.println(c1+"\nc1 tem area: "+String.format("%.2f", c1.getArea())
							+ " e perimetro: "+String.format("%.2f", c1.getPerimeter()));
		System.out.println(c2+"\nc2 tem area: "+String.format("%.2f", c2.getArea())
							+ " e perimetro: "+String.format("%.2f", c2.getPerimeter()));
		
		System.out.println("c1 equals to c3? -> " + c1.equals(c3)); 
		
		Square s1 = new Square(2);
		Square s2 = new Square(3,4,2);
		Square s3 = new Square(s2);
		
		System.out.println(s1+"\ns1 tem area: "+String.format("%.2f", s1.getArea())
							+ " e perimetro: "+String.format("%.2f", s1.getPerimeter()));
		System.out.println(s3+"\ns2 tem area: "+String.format("%.2f", s3.getArea())
							+ " e perimetro: "+String.format("%.2f", s3.getPerimeter()));
		System.out.println("s1 equals to s3? -> " + s1.equals(s3));
		
		Rectangle r1 = new Rectangle(2,3);
		Rectangle r2 = new Rectangle(3,4,2,3);
		Rectangle r3 = new Rectangle(r2);
		
		System.out.println(r1+"\nr1 tem area: "+String.format("%.2f", r1.getArea())
							+ " e perimetro: "+String.format("%.2f", r1.getPerimeter()));
		System.out.println(r3+"\nr3 tem area: "+String.format("%.2f", r3.getArea())
							+ " e perimetro: "+String.format("%.2f", r3.getPerimeter()));
		System.out.println("r2 equals to r3? -> " + r2.equals(r3));
	}

}
