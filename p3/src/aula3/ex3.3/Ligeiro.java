package aula2.ex2;

public class Ligeiro extends Veiculo{
	public Ligeiro(int cilindrada,int potencia,int lotacao,
	char tipocarta, int pesobruto) {
		super(cilindrada, potencia, lotacao, 'B', pesobruto);
	}
	@Override public String toString()
	{
		return "Ve�culo: Ligeiro\n"
			+ super.toString() ;
		
			
	}
} 
