package aula3;

public class Teste1 {

	public static void main(String[] args) {
		
		Student est = new Student("Andreia", 9855678, new Date(18, 7, 1974));
		Bolseiro bls = new Bolseiro ("Maria", 8976543, new Date(11, 5, 1976));
		bls.setBolsa(745);
		
		System.out.println("Estudante: " + est.getName());
		System.out.println(est);
		
		System.out.println("Bolseiro: " + bls.getName() + ", NMec: "+bls.getNMec()
														+ ", Bolsa: "+bls.getAmount());
		System.out.println(bls);
		
	}

}
