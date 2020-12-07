package aula6.ex1;

public class VegDish extends Dish implements Comparable<Dish>{

	public VegDish(String name) {
		super(name);		
	}
	
	@Override
	public String toString() {
		return null;
	}
	
	@Override
	public boolean addIngredient(Alimento a) {
		if (a instanceof VegAlimento)
			return super.addIngredient(a);
		return false;
	}

}
