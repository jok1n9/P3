package aula1.ex3;

public class Ponto {
	private double x;
	private double y;
	
	public Ponto(double x, double y)
	{
		this.x= x;
		this.y= y;
	}
	
	public double x() {return this.x;}
	public double y() {return this.y;}
	public String toString() { return this.x+ "," + this.y;}
	public static double dist(Ponto a, Ponto b) 
	{
		double x= a.x()- b.x();
		double y= a.y()- b.y();
		return Math.abs(Math.sqrt((Math.pow(x,2)+Math.pow(y,2)))) ;
	}
}
