package aula3.ex3;

public class Condutor extends Person {
	private int numerodecarta;
	private char tipodeCarta;
	
	
	public Condutor(String Nome, int cc, Date birth, int numero, char Carta) {
		super(Nome, cc, birth);
		this.tipodeCarta=Carta;
		this.numerodecarta= numero;
		
	}
	public int getNumerodecarta() {return this.numerodecarta;}
	public char getCarta() {return this.tipodeCarta; }
	
	public boolean canDrive(Veiculo b) {
		return this.tipodeCarta>=b.getTipoCarta();
	}
	
	@Override public String toString() {
		return super.toString()+ ", Carta: "+this.numerodecarta
				+ ", Tipo de Carta: " +this.tipodeCarta+ "\n";
	}

}
