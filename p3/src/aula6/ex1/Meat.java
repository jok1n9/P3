package aula6.ex1;

public class Meat implements Alimento{
	enum TYPE {COW,PIG,PERU,CHICKEN,OTHER};
	
	private TYPE type;
	private double proteins;
	private double calories;
	private double weight;
	
	public Meat(TYPE t, double p, double c, double w) {
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
		return "Meat Type: "+this.type+
				", Proteins: "+this.proteins+
				", Calories: "+this.calories+
				", Weight: "+this.weight;
	}	
	
	public boolean equals(Meat m) {
		if(this == m)
			return true;
		if(m == null)
			return false;
		if(this.getClass() != m.getClass())
			return false;
		if(this.type != m.getType())
			return false;
		if(this.proteins != m.getProteins())
			return false;
		if(this.calories != m.getCalories())
			return false;
		if(this.weight != m.getWeight())
			return false;		
		return true;
	}
	
}
