package aula9.ex3;

public class Pessoa {
	private String nome;
	private int cc;
	private Data dataNasc;
	
	public Pessoa (String n, int num, Data d) {
		assert(n.length() > 0) : "Invalid Name";
		assert(num > 0) : "Invalid CC";		
		this.nome = n;
		this.cc = num;
		this.dataNasc = d;
	}
	
	public String getName() {
		return this.nome;
	}
	public int getCC() {
		return this.cc;
	}
	public Data getBirthDate() {
		return this.dataNasc;
	}
	
	@Override
	public String toString() {
		return "Name: "+this.getName()+", CC: "+this.getCC()+", BirthDate: "+this.getBirthDate().toString();
	}
	
	public void setName(String name) {
		this.nome = name;
	}
	public void setCC(int cc) {
		this.cc = cc;
	}
	public void setBirthDate(Data d) {
		this.dataNasc = d;
	}
}
