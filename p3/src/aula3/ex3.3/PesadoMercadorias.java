package aula3.ex3;

class PesadoMercadorias extends Veiculo
{
	public PesadoMercadorias(int cilindrada,int potencia,int lotacao, int pesobruto) 
	{
				super(cilindrada, potencia, lotacao, 'C', pesobruto);
	}
	@Override public String toString()
	{
		return "Veículo: Pesado de mercadorias\n"
			+ super.toString() ;
		
			
	}
}