package aula8.ex3;

public class Teste {

	public static void main(String[] args) {
		
		double p[] = publicHelp(90);
		for(double prob : p) {
			System.out.println(prob);
		}
		

	}
	
	public static double[] publicHelp(double p) {		
		//double confidence; // the probability of the answer given by a random person is correct
		//int right = q.getRightIndex();
		
		double a= 46;
		double pessoa = 100/a;
		double help[] = new double[4];
		double percentagem = p/100;
		double rp = 1-percentagem;
		for(int i = 0; i <a; i++) {
			double rand = Math.random();
			if(rand>rp) help[0] += pessoa;
			else if(rand>rp/2) help[1] += pessoa;
			else if(rand>rp/4) help[2] += pessoa;
			else help[3] += pessoa;
		}
		return help;
	}
	
	public static double[] publicHelp2(Question q) {
		
		
		
		return null;
		
	}

}
