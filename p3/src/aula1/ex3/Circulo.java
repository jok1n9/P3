package aula1.ex3;

public class Circulo {
	private double raio;
	private Ponto centro;
	
	public Circulo(Ponto centro, double raio) 
	{
		this.raio= raio;
		this.centro= centro;
	}
	public Circulo(double x, double y, double raio) 
	{
		Ponto a= new Ponto(x,y);
		this.centro= a;
		
		this.raio= raio;	
	}
	public double raio() { return this.raio;}
	
	public Ponto centro() { return this.centro;}
	
	public double area() { return Math.PI*Math.pow(this.raio, 2);}
	
	public double perimetro() {return 2*Math.PI*this.raio;}
	
	public static boolean ciguais(Circulo c1, Circulo c2) 
	{ 
		return c1.raio()== c2.raio();  
	}
	public boolean cintersetam(Circulo c1, Circulo c2)
	{
		double x= c1.centro().x()- c2.centro().x();
		double y= c1.centro().y()- c2.centro().y();
		double dist= Math.abs(Math.sqrt((Math.pow(x,2)+Math.pow(y,2)))) ;
		
		return dist < c1.raio() + c2.raio();//se um estiver dentro do outro é considerado na mesma
		
	}
	public String toString()
	{
		return "Centro:" + this.centro().toString() + "\n Raio: " + this.raio() + "\n Area: " + this.area() + "\n Perimeter: " + this.perimetro()+"\n";
	}
}
