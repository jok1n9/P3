package aula6.ex1;

public class Vegetable implements VegAlimento{
	
	private String name;
	private double proteins;
	private double calories;
	private double weight;
	
	public Vegetable(String n, double p, double c, double w) {
		this.name = n;
		this.proteins = p;
		this.calories = c;
		this.weight = w;
	}
	public String getName() {
		return this.name;
	}
	public double getProteins() {
		return this.proteins;
	}
	public double getCalories() {
		return this.calories;
	}
	public double getWeight() {
		return this.weight;
	}
	
	@Override
	public String toString() {
		return "Fish name: "+this.name+
				", Proteins: "+this.proteins+
				", Calories: "+this.calories+
				", Weight: "+this.weight;
	}	
	
	public boolean equals(Vegetable v) {
		if(this == v)
			return true;
		if(v == null)
			return false;
		if(this.getClass() != v.getClass())
			return false;
		if(!this.name.equals(v.getName()))
			return false;
		if(this.proteins != v.getProteins())
			return false;
		if(this.calories != v.getCalories())
			return false;
		if(this.weight != v.getWeight())
			return false;		
		return true;
	}

}
