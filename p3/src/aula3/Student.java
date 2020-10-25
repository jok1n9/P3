package aula3;

public class Student extends Person{
	private static int currentMec = 100;
	private int mec;
	private Date registration;
	
	public Student(String name, int cc, Date birth, Date regist) {
		super(name,cc,regist);
		this.registration = regist;
		this.mec = Student.currentMec++;
	}
	
	public Student(String name, int cc, Date birth) {
		super(name,cc,birth);
		this.mec = Student.currentMec++;
		this.registration = Date.today();
	}
	
	public int getNMec() {
		return this.mec;
	}
	public Date getRegistrationDate() {
		return this.registration;
	}
	
	@Override
	public String toString() {
		return super.toString()+", NMec: "+this.mec+", Registration Date: "+this.registration;
	}
	
}
