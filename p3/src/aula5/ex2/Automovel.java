package aula5.ex2;



public class Automovel extends Motorizado {
	public Automovel(int cilindrada,int maxvelocidade, int ano,int consumo,
			String matricula, String combustivel, int potencia,String color, int numerodas) 
	{
		super(cilindrada, maxvelocidade, ano,consumo, matricula,combustivel, potencia, color, numerodas);
	}

	@Override
	public String toString() {
		return "Automovel" + super.toString() ;
	}
}
