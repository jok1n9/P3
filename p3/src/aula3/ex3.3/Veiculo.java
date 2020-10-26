package aula3.ex3;

public class Veiculo {
	
	private int cilindrada;
	private int potencia;
	private int lotacao;
	private char tipocarta;
	private int pesobruto;
	public Veiculo(int cilindrada,int potencia,int lotacao,
			char tipocarta, int pesobruto){
		
		assert(assertions(cilindrada, potencia, lotacao, pesobruto)): "Erro: valores impossiveis";
		
		this.cilindrada= cilindrada;
		this.potencia= potencia;
		this.tipocarta= tipocarta;
		this.pesobruto= pesobruto;
		this.lotacao= lotacao;
	}
	
	public int getCilindrada() { return this.cilindrada;}
	public int getPotencia() { return this.potencia;}
	public int getLotacao() { return this.lotacao;}
	public char getTipoCarta() { return this.tipocarta;}
	public int getPeso() { return this.pesobruto;}
	
	@Override public String toString() {return "Cilindrada: "+ this.getCilindrada()+ "\n"
			+ "Potência: " +this.getPotencia()+"\n"
			+ "Capacidade: " + this.getLotacao()+ "\n"
			+ "Tipo de Carta: " + this.getTipoCarta()+"\n"
			+ "Peso: " + this.getPeso() + "kgs\n" ;}
	
	private boolean assertions(int cilindrada,int potencia,int lotacao, int pesobruto) 
	{
		if (cilindrada<0) return false;
		if (potencia<0) return false;
		if (lotacao<0) return false;
		if (pesobruto<0) return false;
		return true;
	}

}
