package aula8.ex3;

public class Question {	
	
	private String path; //path to image
	private String question;
	private String[] options;
	private int answer;
	private int dificulty;
	
	public Question(String p, String q, String ops[], int a, int dif) {
		this.path = p;
		this.question = q;
		this.options = ops;
		this.answer = a;
		this.dificulty = dif;
	}

	public String getPath() {
		return path;
	}

	public String getQuestion() {
		return question;
	}

	public String[] getOptions() {
		return options;
	}
	
	public int getRightIndex() {
		return this.answer;
	}

	public String getAnswer() {
		return options[this.answer];
	}

	public int getDificulty() {
		return dificulty;
	}
	
	public boolean isRight(int i) {
		return this.answer == i;
	}
	
	

}
