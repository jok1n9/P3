package aula5.ex2;


public class Bicicletapolicia extends Bicicleta {
	String tipo;
	String id;
	public Bicicletapolicia(String color, int ano, int numerodas, String tipo, String id) {
		super(color,ano, numerodas);
		assert(checkTipos(tipo));
		this.id=id;
		this.tipo= tipo;
	}
	public String getTipo() {return this.tipo;}
	public String getId() {return this.id;}
	public enum Tipos{
		INEM, Bombeiros, GNR, PSP, PJ
	}
	public boolean checkTipos(String tipo) {
		for(Tipos n: Tipos.values()) {
			if( n.toString() == tipo) return true;
		}
	return false;
	}
}

