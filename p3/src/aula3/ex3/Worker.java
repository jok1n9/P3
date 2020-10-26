package aula3.ex3;

import aula3.ex1.Date;

public class Worker extends Client{
	private int workId;
	private int fiscalId;
	
	public Worker(String name, int cc, Date date,int partner, Date regist, int work, int fiscal) {
		super(name,cc,date,partner,regist);
		this.workId = work;
		this.fiscalId = fiscal;		
	}
	
	public int getWorkId() {
		return this.workId;
	}
	public int getFiscalId() {
		return this.fiscalId;
	}
	
	
}
