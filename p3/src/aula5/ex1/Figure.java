package aula5.ex1;
import aula3.ex2.Point;

public abstract class Figure implements Comparable<Figure>{
	
	protected Point center;
	
	public abstract double getArea();
	public abstract double getPerimeter();
	public abstract boolean equals(Figure f);		
	
	public Point getCenter() {
		return this.center;
	}
	
	@Override
	public int compareTo(Figure f) {
		if(f == null)
			throw new NullPointerException("null");
		double dif = this.getArea() - f.getArea();
		if(dif < 0)
			return -1;
		else if(dif > 0)
			return 1;
		else
			return 0;		
	}
	
	@Override
	public String toString() {
		return "Figure: " + this.getClass().getSimpleName()+
				", Area: "+this.getArea()+
				", Perimeter: "+this.getPerimeter()+
				", Center:"+this.center.toString();					
	}
}