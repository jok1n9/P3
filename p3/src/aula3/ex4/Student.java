package aula3.ex4;
import aula3.ex1.Date;

public class Student extends Client {
	private int mec;
	private String course;	

	public Student (String name, int cc, Date age, int partner, Date regist, int mec, String course) {
		super(name,cc,age,partner,regist);
		this.mec = mec;
		this.course = course;		
	}
	
	public int getMec() {
		return this.mec;
	}
	public String getCourse() {
		return this.course;
	}
}
