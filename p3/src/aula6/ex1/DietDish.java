package aula6.ex1;

public class DietDish extends Dish implements Comparable<Dish>{
	
	private double maxCalories;

	public DietDish(String name, double max) {		
		super(name);
		this.maxCalories = max;
	}
	
	public double getMaxCalories() {
		return this.maxCalories;
	}
	
	@Override
	public String toString() {
		return null;
	}
	
	@Override
	public boolean addIngredient(Alimento a) {
		if (super.totalCalories()+a.getCalories() <= this.maxCalories)
			return super.addIngredient(a);
		return false;
	}

}
