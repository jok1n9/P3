package aula5.ex2;


public class Policiaveiculo extends Motorizado {
	String id;
	String tipo;
	public Policiaveiculo(int cilindrada,int maxvelocidade, int ano,int consumo,
			String matricula, String combustivel, int potencia,String color, int numerodas, String tipo, String id) 
	{
		super(cilindrada, maxvelocidade, ano,consumo, matricula,combustivel, potencia, color, numerodas);
		assert(checkTipos(tipo));
		this.id= id;
		this.tipo= tipo;
	}
	@Override
	public String toString() {
		return "Policiaveiculo [id=" + id+", tipo="+ tipo+"]"+ super.toString();
	}
	public String getTipo() {return this.tipo;}
	public String getId() {return this.id;}
	public enum Tipos{
		INEM, Bombeiros, GNR, PSP, PJ
	}
	private boolean checkTipos(String tipo) {
		for(Tipos n: Tipos.values()) {
			if( n.toString() == tipo) return true;
		}
	return false;
	}
	
}
