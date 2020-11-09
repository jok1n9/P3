package aula5.ex1;
import aula3.ex2.Point;

public class FigureCollection {
	private double maxArea;
	private Figure[] collection;	
	
	public FigureCollection (double maxArea) {
		this.maxArea = maxArea;
		this.collection = new Figure[0];
		
	}
	
	public boolean addFigure(Figure f) {		
		if(this.totalArea() + f.getArea() > this.maxArea || indexOf(f) != -1) 
			return false;
		Figure[] arr = new Figure[this.collection.length+1];		
		System.arraycopy(this.collection, 0, arr, 0, this.collection.length);
		this.collection = new Figure[this.collection.length+1];
		arr[arr.length-1] = f;		
		System.arraycopy(arr, 0, this.collection, 0, arr.length);		
		return true;
	}
	
	public boolean delFigure(Figure f) {
		int index = indexOf(f);
		if(index == -1)
			return false;
		Figure[] copy = new Figure[this.collection.length];
		System.arraycopy(this.collection, 0, copy, 0, this.collection.length);
		this.collection = new Figure[this.collection.length-1];	
		System.arraycopy(copy, 0, this.collection, 0, index);
		System.arraycopy(copy, index+1, this.collection, index , copy.length-index-1);
		
		return true;		
	}
	
	public double totalArea() {
		double area = 0;
		for(int i = 0; i < this.collection.length; i++) {
			area+= this.collection[i].getArea();
		}
		return area;
	}
	
	public boolean exists(Figure f) {
		return indexOf(f) != -1;
	}
	
	@Override
	public String toString() {
		String list = "";
		for(int i = 0; i < this.collection.length; i++) {
			list+= this.collection[i].toString()+"\n";
		}
		return list;
	}
	
	public Figure[] getFigures() {
		return this.collection;
	}
	
	public Point[] getCenters() {
		Point[] points = new Point[this.collection.length];
		for(int i = 0; i < this.collection.length; i++) {
			points[i] = this.collection[i].center;
		}
		return points;
	}
	
	private int indexOf(Figure f) {		
		for(int i = 0; i < this.collection.length; i++) {
			if(this.collection[i].equals(f)) 
				return i;
		}
		return -1;
	}	
	
}