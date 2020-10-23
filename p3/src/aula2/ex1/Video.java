package aula2;
import java.util.*;

public class Video {
	private int id;
	private String title;
	private String category;
	private int minimumAge;
	private LinkedList<Integer> ratings;
	private boolean status;
	private int ownerID;
	
	public Video(int id, String title, String cat, int min) {
		this.id = id;
		this.title = title;
		this.category = cat;
		this.minimumAge = min;
		this.ratings = new LinkedList<Integer>();
		this.status = false;
		this.ownerID = -1;		//no owner;
	}
	
	public int getId() {
		return this.id;
	}
	public String getTitle() {
		return this.title;
	}
	public String getCategory() {
		return this.category;
	}
	public int getMinimumAge() {
		return this.minimumAge;
	}
	public boolean getStatus() {
		return this.status;
	}
	public int getOwnerID() {
		return this.ownerID;
	}
	
	public double getRating() {
		if(ratings.size() == 0)
			return 0.0;
		double rating = 0;
		for(int i = 0; i < this.ratings.size(); i++) {
			rating += this.ratings.get(i);
		}
		return rating/this.ratings.size();
	}
	
	public void addRating(int rating) {
		this.ratings.add(rating);
	}
	public void setOwner(int id) {
		this.status = true;
		this.ownerID = id;
	}
	
	public void setStatus(boolean b) {
		this.status = b;
	}
	
	@Override
	public String toString() {
		return "----------------------------------\n"+
				"ID: " + this.id + "\n"+
				"Title: " + this.title + "\n"+
				"Category: " + this.category+ "\n"+
				"Minimium Age: " + this.minimumAge + "\n"+
				"Rating: " + this.getRating() + "\n"+
				"----------------------------------\n";
	}
	
}
