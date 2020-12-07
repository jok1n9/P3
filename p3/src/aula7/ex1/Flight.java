package aula7.ex1;

public class Flight {
	
	private Hour hour;
	private String name;
	private Company company;
	private String origin;
	private Hour delay;
	private String obs;
	
	public Flight (Hour h, String n, Company c, String o, Hour d, String obs) {
		this.hour = h;
		this.name = n;
		this.company = c;
		this.origin = o;
		this.delay = d;
		this.obs = obs;
	}
	
	public Hour getHour() {
		return this.hour;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Company getCompany() {
		return this.company;
	}
	
	public String getOrigin() {
		return this.origin;
	}
	
	public Hour getDelay() {
		return this.delay;
	}
	
	public String getObs() {
		return this.obs;
	}
	
	@Override
	public String toString() {
		String format = "%-7.7s%-11.11s%-21.21s%-23.23s%-9.9s%-20.20s";
		return String.format(format,
				this.hour.toString(),
				this.name,
				this.company,
				this.origin,
				this.delay.toString(),
				this.obs);				
	}

}
