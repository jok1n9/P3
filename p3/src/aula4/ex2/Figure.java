package aula4.ex2;
import aula3.ex2.Point;

public abstract class Figure {
	
	protected Point center;
	
	public abstract double getArea();
	public abstract double getPerimeter();
	public abstract boolean equals(Figure f);		
	
	public Point getCenter() {
		return this.center;
	}
}