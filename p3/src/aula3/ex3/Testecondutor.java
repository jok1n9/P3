package aula3.ex3;

public class Testecondutor {

	public static void main(String[] args) {
		Motociclo v1= new Motociclo(200, 100, 2, 1000);
		System.out.println(v1.toString());
		
		Person joa= new Person("Joaquim Andrade", 20002, new Date("21/10/2000"));
		Condutor joaquim = new Condutor(joa.getName(), joa.getCC(), joa.getBirthDate(), 
				199932, 'A');
		
		System.out.print(joaquim.toString());
		
		if(joaquim.canDrive(v1)) System.out.println(joaquim.getName()+ " pode conduzir este veiculo\n");
		else System.out.print(joaquim.getName()+ " não pode conduzir este veículo\n");
		
		PesadoMercadorias v2= new PesadoMercadorias(600, 300, 3, 2000);
		System.out.print(v2.toString());
		
		if(joaquim.canDrive(v2)) System.out.println(joaquim.getName()+ " pode conduzir este veiculo\n");
		else System.out.println(joaquim.getName()+ " não pode conduzir este veículo\n");
		
		PesadoPassageiros v3= new PesadoPassageiros(34340, 3003, 54, 3000);
		System.out.println(v3.toString());
		
		Ligeiro v4= new Ligeiro(34340, 3003, 5, 1000);
		System.out.println(v4.toString());
		
		

	}

}
