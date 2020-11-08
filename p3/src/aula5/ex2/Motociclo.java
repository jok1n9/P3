package aula5.ex2;



public class Motociclo extends Motorizado {
	public Motociclo(int cilindrada,int maxvelocidade, int ano,int consumo,
			String matricula, String combustivel, int potencia,String color, int numerodas) 
	{
		super(cilindrada, maxvelocidade, ano,consumo, matricula,combustivel, potencia, color, numerodas);
	}

	@Override
	public String toString() {
		return "Motociclo" + super.toString() ;
	}
}

