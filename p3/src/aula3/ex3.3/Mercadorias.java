package aula2.ex2;

class PesadoMercadorias extends Veiculo
{
	public PesadoMercadorias(int cilindrada,int potencia,int lotacao,
			char tipocarta, int pesobruto) 
	{
				super(cilindrada, potencia, lotacao, 'C', pesobruto);
	}
	@Override public String toString()
	{
		return "Veículo: Pesado de mercadorias\n"
			+ super.toString() ;
		
			
	}
}