package aula1.ex2;

public class Pessoa {
	private String nome;
	private int CC;
	private Data born;

	public Pessoa(String a, int b, Data c) {
		assert(a.length()>0);
		assert(b>0);
		this.nome=a;
		this.CC=b;
		this.born= c;	
	}
	public String GetName(){return this.nome;}
	
	public int GetCC() {return this.CC;}
	
	public Data GetData() {return this.born;}
	
	public String toString()
	{
				return "Nome: " + this.GetName() + "\n"+ "CC: " + this.GetCC()+ "\n"+ "Data de Nascimento: " + this.GetData().toString() + "\n";
	}
}
