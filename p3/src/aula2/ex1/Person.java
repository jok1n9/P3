package aula2;

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
		return "Name: "+this.getName()+"\nCC: "+this.getCC()+"\nBirthDate: "+this.getBirthDate().toString()+"\n";
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
