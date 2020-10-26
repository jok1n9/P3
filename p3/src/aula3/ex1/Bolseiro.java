package aula3.ex1;

public class Bolseiro extends Student{
	private double amount;
	
	public Bolseiro(String name, int cc, Date birth) {
		super(name,cc,birth);
		this.amount = 0;
	}
	
	public void setBolsa(double bolsa) {
		this.amount = bolsa;
	}
	public double getAmount() {
		return this.amount;
	}
	
	@Override
	public String toString() {
		return super.toString()+", Bolsa: "+String.format("%.2f", this.amount);
	}
}

