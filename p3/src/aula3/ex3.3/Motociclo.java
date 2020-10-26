package aula2.ex2;

public class Motociclo extends Veiculo{
	public Motociclo(int cilindrada,int potencia,int lotacao,
			char tipocarta, int pesobruto) {
				super(cilindrada, potencia, lotacao, 'A', pesobruto);
			}
	@Override public String toString()
	{
		return "Veículo: Motociclo\n"+
			super.toString();
		
			
	}
} 