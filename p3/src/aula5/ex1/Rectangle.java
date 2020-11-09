package aula5.ex1;
import aula3.ex2.Point;

public class Rectangle extends Figure{		
	private double width;
	private double height;
	
	
	public Rectangle (double x, double y, double width, double height) {
		this.center = new Point(x,y);
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(double width, double height) {
		this.center = new Point(0,0);
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(Rectangle r) {
		this(r.center.getX(),r.center.getY(),r.width,r.height);
	}
	
	public double getWidth() {
		return this.width;
	}
	public double getHeight() {
		return this.height;
	}
	
	@Override
	public double getArea() {
		return this.width*this.height;	
	}

	@Override
	public double getPerimeter() {
		return this.width*2 + this.height*2;
	}
	
	@Override
	public boolean equals(Figure f) {
		if(this == f)
			return true;
		if(f == null)
			return false;
		if(this.getClass() != f.getClass())
			return false;
		Rectangle r = (Rectangle) f;
		return this.center.equals(r.center)&&
			   this.width == r.getWidth() &&
			   this.height == r.getHeight();
	}
	
	@Override
	public String toString() {
		return 	"Rectangle"+
				", Center:"+this.getCenter().toString()+
				", Hight: "+this.getHeight()+
				", Width: "+this.getWidth();
	}
}
