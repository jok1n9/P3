package aula3.ex2;

public class Circle extends Figure{
	private Point center;
	private double radius;
	
	public Circle(Point c, double r) {
		this.center = c;
		this.radius = r;
	}
	
	public Circle(double x, double y, double r) {
		this.center = new Point(x,y);
		this.radius = r;
	}
	
	public Circle(double r) {
		this.center = new Point(0,0);
		this.radius = r;		
	}
	
	public Circle(Circle c) {
		this(c.getCenter(),c.getRadius());
	}
	
	public Point getCenter() {
		return this.center;
	}
	public double getRadius() {
		return this.radius;
	}

	@Override
	public double getArea() {		
		return Math.PI*this.radius*this.radius;
	}

	@Override
	public double getPerimeter() {		
		return 2*Math.PI*this.radius;
	}	
	
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null)
			return false;
		if(this.getClass() != o.getClass())
			return false;
		Circle c = (Circle) o;
		return (this.center.equals(c.center) && this.radius == c.radius);
	}
	
	@Override
	public String toString() {
		return "Center:"+this.center.toString()+
			   ", Radius: "+String.format("%.2f",this.getRadius())+
			   ", Perimeter: "+String.format("%.2f",this.getPerimeter())+
			   ", Area: "+String.format("%.2f", this.getArea());
				
	}
}
