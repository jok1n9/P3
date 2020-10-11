package aula1.ex3;

public class Retangulo {
	private Ponto p1;
	private Ponto p2;
	private Ponto p3;
	private Ponto p4;
	
	public Retangulo(Ponto p1, Ponto p2, Ponto p3, Ponto p4)
	{
		assert(isretangulo(p1, p2, p3, p4));
		this.p1= p1;
		this.p2= p2;
		this.p3= p3;
		this.p4= p4;
	}
	public Ponto p1() {return this.p1;}
	public Ponto p2() {return this.p2;}
	public Ponto p3() {return this.p3;}
	public Ponto p4()  {return this.p4;}
	public double area() {return Ponto.dist(p1, p2) * Ponto.dist(p2, p3); }
	
	public boolean isretangulo(Ponto p1, Ponto p2, Ponto p3, Ponto p4) 
	{
		double cx = (p1.x() + p2.x() + p3.x() + p4.x()) / 4;
		double cy = (p1.y() + p2.y() + p3.y() + p4.y()) / 4;
	
		double d  = Math.pow((cx - p1.x()), 2) + Math.pow((cy - p1.y()), 2);
		double d1 = Math.pow((cx - p2.x()), 2) + Math.pow((cy - p2.y()), 2);
		double d2 = Math.pow((cx - p3.x()), 2) + Math.pow((cy - p3.y()), 2);
		double d3 = Math.pow((cx - p4.x()), 2) + Math.pow((cy - p4.y()), 2);
			
		return d == d1 && d == d2 && d ==d3;
	}
	
	public String toString() 
	{
		return "pontos:"+this.p1+" // "+this.p2+" // "+this.p3+" // "+this.p4
			+ "\n" +"Area:"+ this.area()+"\nPerimeter:" +this.perimetro()+"\n";
	}
	
	private double perimetro() 
	{
		return Ponto.dist(p1, p2) + Ponto.dist(p2, p3) + Ponto.dist(p3, p4) + Ponto.dist(p4, p1);
	}
}
