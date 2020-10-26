package aula3.ex2;

public class Square extends Rectangle{
	private double width;
	
	public Square(double x, double y, double width) {			
		super(x,y,width,width);		
		this.width = width;	
	}
	
	public Square(double width) {
		super(width,width);
		this.width = width;
	}
	
	public Square(Square s) {
		this(s.getP1().getX(),s.getP1().getY(),s.getWidth());		
	}
	
	public double getWidth() {
		return this.width;
	}
	
	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}
	
	@Override
	public String toString() {
		return super.toString()+", Width: "+this.width;
	}
 	

}
