package aula3.ex3;

public class Motociclo extends Veiculo{
	public Motociclo(int cilindrada,int potencia,int lotacao, int pesobruto) {
				super(cilindrada, potencia, lotacao, 'A', pesobruto);
			}
	@Override public String toString()
	{
		return "Veículo: Motociclo\n"+
			super.toString();
		
			
	}
} 