package aula7.ex2;

import java.io.IOException;
import java.util.Scanner;

public class TestBitmap {

	public static void main(String[] args) throws IOException {
		String a= "src/aula7/ex2/Figura.bmp";
		Bitmap bmp = new Bitmap(a);
		int selection = 0;
		Scanner userInput = new Scanner(System.in);
		do
		{
			System.out.println("-----------------------");
			System.out.println("Caminho: " + a);
			System.out.println("Largura: " + bmp.getBitmapInfoHeader().getWidth() + "px");
			System.out.println("Altura: " + bmp.getBitmapInfoHeader().getHeight() + "px");
			System.out.println("Resolução: " + bmp.getBitmapInfoHeader().getxPelsPerMeter() * bmp.getBitmapInfoHeader().getyPelsPerMeter() + " pixeis/metro^2");
			System.out.println("Tamanho: " + bmp.getBitmapFileHeader().getSize() + " bytes");
			System.out.println("Número de bits: " + bmp.getBitmapInfoHeader().getBitCount() + " bits");
			System.out.println("Compressão: " + bmp.getBitmapInfoHeader().getCompression());
			System.out.println("RAW: " + bmp.getBitmapInfoHeader().getSizeImage() + " bits");
			System.out.println("-----------------------");
			System.out.println("");
			System.out.println("[1] Guardar ficheiro .raw ");
			System.out.println("[2] Redimensionar imagem");
			System.out.println("[3] Girar horizontal");
			System.out.println("[4] Girar vertical");
			System.out.println("[5] Sair");
			System.out.print("Seleção: ");
			selection = Integer.parseInt(userInput.nextLine());
			
			switch(selection)
			{
				case 1:
					System.out.print("Caminho para guardar o ficheiro: ");
					String inputPath = userInput.nextLine();
					bmp.saveToRaw(inputPath);
					System.out.println("Guardado com sucesso em RAW");
					break;
				
				case 2:
					System.out.print("Caminho para guardar o ficheiro: ");
					inputPath = userInput.nextLine();
					bmp.resize();
					bmp.saveToBmp(inputPath, bmp.getPixelArray());
					System.out.println("Guardado com sucesso");
					break;
					
				case 3:
					System.out.print("Caminho para guardar o ficheiro: ");
					inputPath = userInput.nextLine();
					bmp.saveToBmp(inputPath, bmp.flipHorizontal());
					System.out.println("Guardado com sucesso");
				case 4:
					System.out.print("Caminho para guardar o ficheiro: ");
					inputPath = userInput.nextLine();
					bmp.saveToBmp(inputPath, bmp.flipVertical());
					System.out.println("Guardado com sucesso");
				default:
					
			}
		}
		while(selection != 5);
		userInput.close();
	}
	

}
