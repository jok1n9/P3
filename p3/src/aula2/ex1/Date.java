package aula2;

public class Date {
	private int year;
	private int month;
	private int day;
	
	public static final int[] common = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static final int[] leap = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};	
	
	public Date(int y, int m, int d) {		
		assert (validDate(y,m,d)) : "Invalid Date";
		this.year = y;
		this.month = m;
		this.day = d;
	}
	
	public Date(String date) {
		int d = Integer.valueOf(date.split("/")[0]);
		int m = Integer.valueOf(date.split("/")[1]);
		int y = Integer.valueOf(date.split("/")[2]);
		assert (validDate(y,m,d));
		this.year = y;
		this.month = m;
		this.day = d;
		
	}
	
	int daysOfMonth(int y, int m) {
		if(isLeapYear(y)) return leap[m-1];
		else return common[m-1];		
	}

	boolean validDate(int y, int m, int d) {
		if(!(d > 0 && d <= daysOfMonth(y,m))) return false;
		if(!(m > 0 && m <= 12)) return false;
		if(y <= 0) return false;
		return true;		
	}
	
	boolean isLeapYear(int year) {
		return year%4 == 0 && year%100 != 0 || year%400 == 0;
	}
	
	public int getYear() {
		return this.year;
	}
	public int getMonth() {
		return this.month;
	}
	public int getDay() {
		return this.day;
	}
	
	@Override
	public String toString() {
		return this.getDay()+"/"+this.getMonth()+"/"+this.getYear();
	}
}
