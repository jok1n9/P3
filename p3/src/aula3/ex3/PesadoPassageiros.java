package aula3.ex3;

public class PesadoPassageiros extends Veiculo {
	public PesadoPassageiros(int cilindrada,int potencia,int lotacao,
			int pesobruto) 
		{
		super(cilindrada, potencia, lotacao, 'D', pesobruto);
		}
	@Override public String toString()
	{
		return "Veículo:Pesado de passageiros\n"
			+ super.toString() ;
		
			
	}
}
