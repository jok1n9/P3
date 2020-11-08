package aula5.ex2;

public class Veiculo implements Comparable<Veiculo>{
	private String color;
	private int ano;
	private int numerodas;
	public Veiculo(String color,int ano ,int numerodas)
	{
		this.color= color;
		this.ano= ano;
		this.numerodas= numerodas;
	}
	public String getColor() {
		return color;
	}
	public int getAno() {
		return ano;
	}
	public int getNumerodas() {
		return numerodas;
	}
	
	@Override
	public String toString() {
		return "color=" + color + ", numerodas=" + numerodas;
	}
	public int compareTo(Veiculo v) {
		if(this.ano== v.getAno()) return 0;
		if(this.ano<v.getAno()) return -1;
		else return 1;
		
	}
}
