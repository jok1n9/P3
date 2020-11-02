package aula4.ex3;

import java.util.LinkedList;

import aula3.ex1.Date;
import aula3.ex1.Person;

public abstract class Client extends Person{
	private int partnerNumber;
	private Date registDate;
	private LinkedList<Video> rented;	
	private LinkedList<Video> history;
	
	public Client(String name, int cc, Date date, int partner, Date regist) {
		super(name,cc,date);
		this.partnerNumber = partner;
		this.registDate = regist;
		this.rented = new LinkedList<Video>();
		this.history = new LinkedList<Video>();
	}
	
	public int getPartnerNumber() {
		return this.partnerNumber;
	}
	public Date getRegistDate() {
		return this.registDate;
	}
	public LinkedList<Video> getRentedList() {
		return this.rented;
	}
	public LinkedList<Video> getHistoryList() {
		return this.history;
	}
	public void showHistory() {
		for(int i = 0; i < this.getHistoryList().size(); i++) {
			System.out.print(this.getHistoryList().get(i).toString());			
		}
	}
}
