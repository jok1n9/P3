package aula3;

public abstract class Figure {
	private static int count = 1;
	private int id;
	
	public abstract double getArea();
	public abstract double getPerimeter();
	
	public Figure () {
		this.id = count++;
	}
	
	public int getId() {
		return this.id;
	}		
	
}
