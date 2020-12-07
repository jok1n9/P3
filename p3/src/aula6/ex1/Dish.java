package aula6.ex1;

public class Dish implements Comparable<Dish>{
	
	private String name;
	private Alimento[] food;
	
	public Dish(String name) {
		this.name = name;
		this.food = new Alimento[0];
	}
	
	public String getName() {
		return this.name;
	}
	public Alimento[] getFood() {
		return this.food;		
	}
	
	public boolean addIngredient(Alimento a) {
		Alimento[] arr = new Alimento[this.food.length+1];		
		System.arraycopy(this.food, 0, arr, 0, this.food.length);
		this.food = new Alimento[this.food.length+1];
		arr[arr.length-1] = a;		
		System.arraycopy(arr, 0, this.food, 0, arr.length);			
		return true;
	}
	
	public double totalCalories() {
		double c = 0;
		for(Alimento a : this.food) 
			c += a.getCalories();		
		return c;
	}
	
	public double totalProteins() {
		double p = 0;
		for(Alimento a : this.food) 
			p += a.getProteins();		
		return p;
	}
	
	public double totalWeight() {
		double w = 0;
		for(Alimento a : this.food) 
			w += a.getWeight();		
		return w;
	}
	
	@Override
	public String toString() {
		String s = "Name: "+this.name+", Ingredients: ";
		for(int i = 0; i < this.food.length-1; i++) {
			s = s +this.food[i].toString() + ", " ;
		}
		s = s +this.food[this.food.length-1].toString();
		return s;
	}

	@Override
	public int compareTo(Dish d) {
		if(d == null)
			throw new NullPointerException("null");
		double dif = this.totalCalories() - d.totalCalories();
		if(dif < 0)
			return -1;
		if(dif > 0) 
			return 1;		
		return 0;
	}
	
	
}
