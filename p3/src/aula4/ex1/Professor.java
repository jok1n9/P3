package aula4.ex1;

import aula3.ex1.Date;
import aula3.ex1.Person;

public class Professor extends Person{
	
	private Date admissao;
	private int nfunc;
	
	
	public Professor(String nome, int cc ,Date data, Date admissao, int nfunc) 
	{
		super(nome, cc, data);
		this.admissao= admissao;
		this.nfunc= nfunc;
	}
	public Professor(String nome, int cc ,Date data) {
		super(nome, cc, data);
	}


	public Date getAdmissao() {return admissao;}


	public int getNfunc() {return nfunc;}
	
}
