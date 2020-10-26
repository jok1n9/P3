package aula2.ex2;

public class Person {
	private String nome;
	private int cc;
	private Date dataNasc;
	
	public Person (String n, int num, Date d) {
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
	public Date getBirthDate() {
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
	public void setBirthDate(Date d) {
		this.dataNasc = d;
	}
}
