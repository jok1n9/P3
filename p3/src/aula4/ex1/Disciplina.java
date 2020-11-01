package aula4.ex1;
import aula3.ex1.Student;

public class Disciplina {
	private String disciplina;
	private String area;
	private int ects;
	private Professor responsavel; 
	private Student[] vetoralunos; // Vetor dinâmico de Estudantes não "repetidos"

	public Disciplina(String disciplina, String area, int ects, Professor responsavel) {
		this.disciplina= disciplina;
		this.area= area;
		this.ects= ects;
		this.responsavel= responsavel;
		vetoralunos= new Student[0];
	}
	public boolean addAluno(Student est) 
	{
		if(alunoInscrito(est.getNMec())) return false;
		int a= vetoralunos.length;
		Student[] arraycopi= new Student[a+1]; 
		System.arraycopy(vetoralunos, 0, arraycopi, 0, a);
		
		vetoralunos =arraycopi;
		vetoralunos[vetoralunos.length-1]= est;
		
		return true;
		
		
	}// Adiciona um aluno à Disciplina
	public boolean delAluno(int nMec)
	{
		for(int i=0; i<vetoralunos.length; i++) 
		{
			if(vetoralunos[i].getNMec()== nMec) 
			{
				Student[] arraycopi= new Student[vetoralunos.length-1]; 
				System.arraycopy(vetoralunos, 0, arraycopi, 0, i);
				System.arraycopy(vetoralunos, i+1, arraycopi, i, vetoralunos.length-i-1);
				vetoralunos=arraycopi;
				return true;
			}
		}
		return false;
	}// Remove um aluno da Disciplina
	
	public boolean alunoInscrito(int nMec) 
	{
		for(int i=0; i<vetoralunos.length; i++) 
		{
			if(vetoralunos[i].getNMec()== nMec) 
			{
				return true;
			}
		}
		return false;
	}// Verifica se aluno está inscrito à disciplina
	
	public int numAlunos() 
	{
		return vetoralunos.length;
	} // Retorna o Nº de Alunos Inscritos
	
	@Override
	public String toString() 
	{
		return "Disciplina [disciplina=" + disciplina + ", area=" + area + ", ects=" + ects + ", Professor "+ this.responsavel + "]";
	}
	public Student[] getAlunos() 
	{
		return this.vetoralunos;
	} // Retorna uma lista com todos os alunos da disciplina
	
	public Student[] getAlunos(String tipo) {
		
		Student[] a= new Student[0];
		for(int i=0; i<vetoralunos.length; i++) 
		{
			
			if(vetoralunos[i].getClass().getSimpleName().equals(tipo)) {
				a=addAluno(a, vetoralunos[i]);
				
			}
		}
		return a;
	} // Retorna uma lista com todos os alunos da disciplina do subtipo “tipo”
	
	
	private Student[] addAluno(Student[] a, Student est) 
	{
		int b= a.length;
		Student[] arraycopi= new Student[b+1]; 
		System.arraycopy(a, 0, arraycopi, 0, b);
		
		arraycopi[b]=est;
		return arraycopi;
		
		
	}// Adiciona um aluno à Disciplina
}
