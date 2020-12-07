package aula6.ex1;

public class Teste {
	
	public static void main(String[] args) {
		Ement ementa = new Ement("Especial Caloiro", "Snack da UA");
		Dish[] pratos = new Dish[10];
		
		for (int i=0; i < pratos.length; i++){
			pratos[i] = randPrato(i);
			int cnt = 0;
			while (cnt <2){ // Adicionar 2 Ingredientes a cada Prato
				Alimento aux = randAlimento();
				if (pratos[i].addIngredient(aux))
					cnt++;
				else
					System.out.println("ERRO: Não é possivel adicionar '" +
							aux + "' ao -> " + pratos[i]);
			}
			ementa.addDish(pratos[i], Menu.DAY.rand()); // Dia Aleatório
		}
		System.out.println("\n" + ementa);
	}
	// Retorna um Alimento Aleatoriamente
	public static Alimento randAlimento() {
		switch ((int) (Math.random() * 4)) {
		default:
		case 0:
			return new Meat(Meat.TYPE.CHICKEN, 22.3, 345.3, 300);
		case 1:
			return new Fish(Fish.TYPE.CONGELADO, 31.3, 25.3, 200);
		case 2:
			return new Vegetable("Couve Flor", 21.3, 22.4, 150);
		case 3:
			return new Cereal("Milho", 19.3, 32.4, 110);
		}
	}
	// Retorna um Tipo de Prato Aleatoriamente
	public static Dish randPrato(int i) {
		switch ((int) (Math.random() * 3)) {
		default:
		case 0:
			return new Dish("Prato N." + i);
		case 1:
			return new VegDish("Prato N." + i + " (Vegetariano)");
		case 2:
			return new DietDish("Prato N." + i + " (Dieta)", 90.8);
		}
	}
}