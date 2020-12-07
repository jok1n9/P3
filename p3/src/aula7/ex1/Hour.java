package aula7.ex1;

public class Hour implements Comparable<Hour>{
	
	private int hours;
	private int minutes;
	
	public Hour(int h, int m) {
		this.hours = h;
		this.minutes = m;
	}
	
	public Hour(String time) {
		String arr[] = time.split(":");
		this.hours = Integer.parseInt(arr[0]);
		this.minutes = Integer.parseInt(arr[1]);
	}
	
	public Hour(int min) {
		this.hours = min/60;
		this.minutes = min%60;
	}
	
	public Hour() {
		this.hours = 0;
		this.minutes = 0;
	}
	
	public int getHours() {
		return this.hours;
	}
	
	public int getMinutes() {
		return this.minutes;
	}
	
	public void setHours(int h) {
		this.hours = h;
	}
	
	public void setMinutes(int m) {
		this.minutes = m; 
	}	
	
	public int getTotalMinutes() {
		return this.minutes+this.hours*60;
	}
	
	public static Hour sumHour(Hour h1, Hour h2) {		
		int totalMinutes = h1.getMinutes()+h2.getMinutes()+h1.getHours()*60+h2.getHours()*60;
		Hour sum = new Hour(totalMinutes);		
		return sum;		
	}
	
	@Override
	public String toString() {			
		if(this.getTotalMinutes() == 0)
			return "";
		if(this.hours < 10) {
			if(this.minutes < 10) 
				return "0"+this.hours+":"+"0"+this.minutes;			
			else
				return "0"+this.hours+":"+this.minutes;
		}
		else {
			if(this.minutes < 10) 
				return this.hours+":"+"0"+this.minutes;			
			else
				return this.hours+":"+this.minutes;
		}			
	}

	@Override
	public int compareTo(Hour o) {
		if(this.hours < o.getHours())
			return -1;
		else if(this.hours > o.getHours())
			return 1;
		else {
			if(this.minutes < o.getMinutes())
				return -1;
			else if(this.minutes > o.getMinutes())
				return 1;
			else
				return 0;			
		}			
	}
	
	

}
