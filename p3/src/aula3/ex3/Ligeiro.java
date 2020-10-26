package aula3.ex3;

public class Ligeiro extends Veiculo{
	public Ligeiro(int cilindrada,int potencia,int lotacao, int pesobruto) {
		super(cilindrada, potencia, lotacao, 'B', pesobruto);
	}
	@Override public String toString()
	{
		return "Veículo: Ligeiro\n"
			+ super.toString() ;
		
			
	}
} 
