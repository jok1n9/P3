package aula2.ex1;

public class Worker extends Person {
	private int fiscal;
	private int funcionario;
	
	public Worker(String nome, int CC, String data, int fiscal , int funcionario) {
		super(nome, CC, data);
		this.fiscal= fiscal;
		this.funcionario= funcionario ;
		
	}
}
