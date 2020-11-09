package aula5.ex2;

import aula5.ex1.UtilCompare;
public class testeveiculos {

	public static void main(String[] args) {
		Bicicleta a= new Bicicleta("verde", 2000, 2);
		
		
		Automovel b= new Automovel(320, 300, 2000, 15,"14-AB-13", "gasóleo", 200, "verde", 4);
		
		
		Motociclo c= new Motociclo(200, 150, 1987,10,"15-4B-H3", "gasolina", 100, "verde", 1);
		
		
		Policiaveiculo d= new Policiaveiculo(350, 350, 2010, 20,"35-3B-U5", "gasóleo", 200, "azul", 1,"inem", "JVINR340");
		
		Bicicletapolicia f= new Bicicletapolicia("azul", 1999, 2, "INEM" ,"aveomev");
		
		Veiculo[] e= new Veiculo[5];
		e[0]=a;
		e[1]=b;
		e[2]=c;
		e[3]=d;
		e[4]=f;
		UtilCompare.sortArray(e);
		for(Veiculo n: e) {
			System.out.println(n);
		}
		

	}

}
