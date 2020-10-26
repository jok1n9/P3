package aula2.ex2;

public class Veiculo {
	private int cilindrada;
	private int potencia;
	private int lotacao;
	private char tipocarta;
	private int pesobruto;
	public Veiculo(int cilindrada,int potencia,int lotacao,
			char tipocarta, int pesobruto){
		this.cilindrada= cilindrada;
		this.potencia= potencia;
		this.tipocarta= tipocarta;
		this.pesobruto= pesobruto;
		this.lotacao= lotacao;
	}
	public int getCilindrada() { return this.cilindrada;}
	public int getPotencia() { return this.potencia;}
	public int getLotacao() { return this.lotacao;}
	public int getTipoCarta() { return this.tipocarta;}
	public int getPeso() { return this.pesobruto;}
	@Override public String toString() {return "Cilindrada: "+ this.getCilindrada()+ "\n"
			+ "Potência: " +this.getPotencia()+"\n"
			+ "Capacidade: " + this.getLotacao()+ "\n"
			+ "Tipo de Carta: " + this.getTipoCarta()+"\n"
			+ "Peso: " + this.getPeso() + "\n" ;}

}
