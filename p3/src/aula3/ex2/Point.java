package aula3.ex2;

public class Point {
	private double x;
	private double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	
	@Override
	public String toString() {
		return "("+this.x+","+this.y+")";
	}
	
	public double getDistanceTo(Point p) {
		return Math.sqrt(Math.pow(p.x-this.x, 2)+Math.pow(p.y-this.y, 2));
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null)
			return false;
		if(this.getClass() != o.getClass())
			return false;
		Point p = (Point) o;
		return(this.x == p.x && this.y == p.y);
	}
}
