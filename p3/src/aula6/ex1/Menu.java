package aula6.ex1;

import java.util.LinkedList;

public class Menu {	
	
	enum DAY {
		MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY;
		
		public static DAY rand() {
			int i = (int) (Math.random() * 6);
			return DAY.values()[i];
					
		}
	
	}				
	private DAY day;
	private LinkedList<Dish> dishes;
	
	public Menu(DAY d) {
		this.day = d;
		this.dishes = new LinkedList<Dish>();
	}
	
	public boolean addDish (Dish d) {
		return this.dishes.add(d);
	}
	
	public boolean removeDish(Dish d) {
		return this.dishes.remove(d);
	}
	
	public DAY getDay() {
		return this.day;		
	}
	
	public LinkedList<Dish>getDishes() {
		return this.dishes;
	}
	
	@Override
	public String toString() {
		String s =  "Day: "+this.day+ ", ";
		for(int i = 0; i < this.dishes.size(); i++) {
			s = s + this.dishes.get(i).toString()+", ";
		}
		return s;
	}

}