package aula2.ex2;

public class Condutor extends Person {
	private int numero;
	private char Carta;
	
	public Condutor(String Nome, int cc, Date birth, int numero, char Carta) {
		super(Nome, cc, birth);
		this.Carta=Carta;
		this.numero= numero;
		
	}
	public boolean canDrive( Veiculo a) {
		if(a.getTipoCarta() == this.Carta) return true;
		return false;
	}
}
