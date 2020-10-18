package aula2.ex1;

public class Student extends Person 
{
	private int mec;
	private String Curso;
	
	public Student(String nome, int CC, String data, int mec, String Curso) {
		super(nome, CC, data);
		this.Curso= Curso;
		this.mec= mec;
		
	}
}

