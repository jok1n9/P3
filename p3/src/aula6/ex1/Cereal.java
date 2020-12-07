package aula6.ex1;

public class Cereal implements VegAlimento{
	
	private String name;
	private double proteins;
	private double calories;
	private double weight;
	
	public Cereal(String n, double p, double c, double w) {
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
		return "Cereal name: "+this.name+
				", Proteins: "+this.proteins+
				", Calories: "+this.calories+
				", Weight: "+this.weight;
	}	
	
	public boolean equals(Cereal c) {
		if(this == c)
			return true;
		if(c == null)
			return false;
		if(this.getClass() != c.getClass())
			return false;
		if(!this.name.equals(c.getName()))
			return false;
		if(this.proteins != c.getProteins())
			return false;
		if(this.calories != c.getCalories())
			return false;
		if(this.weight != c.getWeight())
			return false;		
		return true;
	}


}
