package aula6.ex1;

public class Fish implements Alimento{	
	enum TYPE {CONGELADO,FRESCO};
	
	private TYPE type;
	private double proteins;
	private double calories;
	private double weight;
	
	public Fish(TYPE t, double p, double c, double w) {
		this.type = t;
		this.proteins = p;
		this.calories = c;
		this.weight = w;
	}
	
	public TYPE getType() {
		return this.type;
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
		return "Fish Type: "+this.type+
				", Proteins: "+this.proteins+
				", Calories: "+this.calories+
				", Weight: "+this.weight;
	}	
	
	public boolean equals(Fish f) {
		if(this == f)
			return true;
		if(f == null)
			return false;
		if(this.getClass() != f.getClass())
			return false;
		if(this.type != f.getType())
			return false;
		if(this.proteins != f.getProteins())
			return false;
		if(this.calories != f.getCalories())
			return false;
		if(this.weight != f.getWeight())
			return false;		
		return true;
	}
	
		
	
}
