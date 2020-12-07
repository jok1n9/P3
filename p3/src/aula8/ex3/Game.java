package aula8.ex3;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Game {
	
	private LinkedList<Question> questions;
	private int level;
	
	public Game() throws IOException {
		this.questions = loadQuestions("src/aula8/ex3/questions.txt");		
		this.level = 0;
		
	}
	
	public LinkedList<Question> getQuestions() {
		return this.questions;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public void setLevel(int l) {
		this.level = l;
	}
	
	public void levelUp() {
		this.level++;
	}
	
	
	
	public LinkedList<Question> loadQuestions(String path) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(path));		
		LinkedList<Question> questions = new LinkedList<Question>();
		String[] data;
		for(String line : lines) {
			data = line.split("--");
			String ops[] = {data[2],data[3],data[4],data[5]};			
			questions.add(new Question(
								data[0],
								data[1],
								ops,
								Integer.parseInt(data[6]),
								Integer.parseInt(data[7])));
		}
		return questions;
	}
	
	public Question getQuestion() {		
		return this.questions.get(this.level);		
	}	
	
	public int getMoney() {
		int[] money = {25,50,125,250,500,750,1500,2500,5000,10000,16000,32000,64000,125000,250000};
		return money[this.level];
	}
	
	public static int[] publicLifeline(Question q) {
		double p; // the probability of the answer given by a random person is correct (%)
		
		if(q.getDificulty() == 0) p = 90;
		else if(q.getDificulty() == 1) p = 50;
		else p = 30;			
		int a= 100;		
		int pessoa = 100/a;
		int help[] = new int[4];
		double percentagem = p/100;
		double rp = 1-percentagem;
		for(int i = 0; i <a; i++) {
			double rand = Math.random();
			if(rand>rp) help[0] += pessoa;
			else if(rand>rp/2) help[1] += pessoa;
			else if(rand>rp/4) help[2] += pessoa;
			else help[3] += pessoa;
		}
		int c;
		c=help[0];
		help[0]=help[q.getRightIndex()];
		help[q.getRightIndex()]=c;
		return help;
	}
	
	public static int getRandomIndex(Question q) {
		Random r = new Random();
		int rand = r.nextInt(4);		
		while(rand == q.getRightIndex()) {
			rand = r.nextInt(4);
		}
		return rand;
		
	}
	
	

}
