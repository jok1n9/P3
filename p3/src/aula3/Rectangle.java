package aula3;

public class Rectangle extends Figure{		
	private Point p1;
	private Point p2;
	private Point p3;
	private Point p4;
	
	public Rectangle (double x, double y, double width, double height) {
		this.p1 = new Point(x,y);
		this.p2 = new Point(x+width,y);
		this.p3 = new Point(x+width,y-height);
		this.p4 = new Point(x,y-height);
	}
	
	public Rectangle(double width, double height) {
		this.p1 = new Point(0,0);
		this.p2 = new Point(width,0);
		this.p3 = new Point(width,-height);
		this.p4 = new Point(0,-height);
	}
	
	public Rectangle(Rectangle r) {
		this(r.p1.getX(),r.p1.getY(),r.getWidth(),r.getHeight());
	}
	
	public Point getP1() {
		return this.p1;
	}
	public Point getP2() {
		return this.p2;
	}
	public Point getP3() {
		return this.p3;
	}
	public Point getP4() {
		return this.p4;
	}
	
	public double getWidth() {
		return this.p1.getDistanceTo(this.p2);
	}
	public double getHeight() {
		return this.p1.getDistanceTo(this.p4);
	}
	
	@Override
	public double getArea() {
		return this.p1.getDistanceTo(p2)*this.p1.getDistanceTo(p4);		
	}

	@Override
	public double getPerimeter() {
		return this.p1.getDistanceTo(p2)*2 + this.p2.getDistanceTo(p3)*2;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null)
			return false;
		if(this.getClass() != o.getClass())
			return false;
		Rectangle r = (Rectangle) o;
		return this.p1.equals(r.p1) && this.p2.equals(r.p2) &&
			   this.p3.equals(r.p3) && this.p4.equals(r.p4) &&
			   this.getWidth() == r.getWidth() &&
			   this.getHeight() == r.getHeight();
	}
	
	@Override
	public String toString() {
		return "P1"+this.getP1().toString()+
				   ", P2"+this.getP2().toString()+
				   ", P3"+this.getP3().toString()+
				   ", P4"+this.getP4().toString()+
				   "\nPerimeter: "+String.format("%.2f", this.getPerimeter())+
				   ", Area: "+String.format("%.2f", this.getArea());
	}
}
