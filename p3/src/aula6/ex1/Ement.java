package aula6.ex1;

public class Ement{	
	
	private String name;
	private String local;
	private Menu[] menus;	
	
	public Ement(String name, String local) {
		this.name = name;
		this.local = local;
		this.menus = new Menu[7];
		for(int i = 0; i < this.menus.length; i++) {
			this.menus[i] = new Menu(Menu.DAY.values()[i]);
		}			
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getLocal() {
		return this.local;
	}
	
	public Menu[] getMenus() {
		return this.menus;
	}
	
	public boolean addDish(Dish dish, Menu.DAY day) {		
		switch(day) {
			case MONDAY:
				return this.menus[0].addDish(dish);				
			case TUESDAY:
				return this.menus[1].addDish(dish);				
			case WEDNESDAY:
				return this.menus[2].addDish(dish);				
			case THURSDAY:
				return this.menus[3].addDish(dish);				
			case FRIDAY:
				return this.menus[4].addDish(dish);				
			case SATURDAY:
				return this.menus[5].addDish(dish);				
			case SUNDAY:
				return this.menus[6].addDish(dish);				
		default:
			return false;
			
		}
	}
	
	public boolean removeDish(Dish dish, Menu.DAY day) {
		switch(day) {
			case MONDAY:
				return this.menus[0].removeDish(dish);				
			case TUESDAY:
				return this.menus[1].removeDish(dish);				
			case WEDNESDAY:
				return this.menus[2].removeDish(dish);				
			case THURSDAY:
				return this.menus[3].removeDish(dish);				
			case FRIDAY:
				return this.menus[4].removeDish(dish);				
			case SATURDAY:
				return this.menus[5].removeDish(dish);				
			case SUNDAY:
				return this.menus[6].removeDish(dish);				
			default:
				return false;
				
		}
	}
	@Override
	public String toString() {
		String s = "Name :" +this.name+", Local: "+this.local;
		for(int i = 0; i < this.menus.length; i++) {
			s+= "\n"+this.menus[i].toString();
		}
		return s;
	}

}
