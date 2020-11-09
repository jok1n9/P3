package aula5.ex2;

public class Motorizado extends Veiculo {
	private int cilindrada;
	private int maxvelocidade;
	private int potencia;
	private int consumo;
	private String combustivel;

	private String matricula;
	public Motorizado(int cilindrada,int maxvelocidade, int ano,int consumo,
						String matricula, String combustivel, int potencia,String color, int numerodas) 
	{
		super(color,ano, numerodas);
		assert(cilindrada>0 && potencia>0&& consumo >0 && maxvelocidade>0);

		this.cilindrada= cilindrada;
		this.combustivel= combustivel;
		this.potencia= potencia;
		this.consumo= consumo;
		this.maxvelocidade= maxvelocidade;
		this.matricula= matricula;
	
	}
	public int getMaxvelocidade() {
		return maxvelocidade;
	}
	
	public int getPotencia() {
		return potencia;
	}
	public int getConsumo() {
		return consumo;
	}
	public String getCombustivel() {
		return combustivel;
	}

	public int getCilindrada() {
		return cilindrada;
	}
	public String getMatricula() {
		return matricula;
	}
	@Override
	public String toString() {
		return "[cilindrada=" + cilindrada + ", maxvelocidade=" + maxvelocidade +", matricula=" + matricula+ ", combustível=" +combustivel+ 
				", potencia=" + potencia+ ", consumo=" + consumo+", " + super.toString() + "]";
	}
}

