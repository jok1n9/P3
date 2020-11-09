package aula5.ex1;

public class Square extends Rectangle{	
	private double side;
	
	public Square(double x, double y, double width) {			
		super(x,y,width,width);		
		this.side = width;	
	}
	
	public Square(double width) {
		super(width,width);
		this.side = width;
	}
	
	public Square(Square s) {
		this(s.center.getX(),s.center.getY(),s.getWidth());		
	}
	
	public double getSide() {
		return this.side;
	}
	
	@Override
	public boolean equals(Figure f) {
		return super.equals(f);
	}
	
	@Override
	public String toString() {
		return super.toString()+", Side: "+this.side;
	}	

}
