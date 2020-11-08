package aula5.ex2;

public class Bicicleta extends Veiculo {
	public Bicicleta(String color, int ano, int numerodas) {
		super(color,ano, numerodas);
	}

	@Override
	public String toString() {
		return "Bicicleta ["+ super.toString() + "]";
	}
}
