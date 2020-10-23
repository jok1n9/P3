package aula2;
import java.util.*;
import java.io.*;

public class LettersSoup {
	private File file;
	private int width;
	private char [][] matrix;
	private LinkedList<String> words;	
	
	public LettersSoup(String filename) throws IOException{
		
		this.file = new File(filename);
		this.width = calculateWidth();
		this.matrix = readMatrix();
		this.words = readWords();
		
	}
	
	public File getFile() {
		return this.file;
	}
	public int getWidth() {
		return this.width;
	}
	public char[][] getMatrix() {
		return this.matrix;
	}
	public LinkedList<String> getWords() {
		return this.words;
	}
	
	private char[][] readMatrix() throws IOException {
		String line;
		char[][] matrix = new char[this.width][this.width];
		Scanner fr = new Scanner(this.file);
		for(int i = 0; i < this.width; i++) {
			line = fr.nextLine();
			for(int j = 0; j < this.width; j++) {
				matrix[i][j] = line.charAt(j);
			}
		}
		fr.close();		
		return matrix;
	}
	
	private int calculateWidth() throws IOException{
		Scanner fr = new Scanner(this.file);
		int w = fr.nextLine().length();
		fr.close();		
		return(w);
	}
	
	private LinkedList<String> readWords() throws IOException{
		String line;		
		LinkedList<String> words = new LinkedList<String>();
		Scanner fr = new Scanner(this.file);
		int k = 0;
		while(k < this.width) {		//jump to words section of the file
			line = fr.nextLine();
			k++;
		}
		while(fr.hasNextLine()) {
			line = fr.nextLine();
			for(String wd : line.split(",")) {
				words.add(wd.trim());
			}			
		}
		fr.close();
		return words;		
	}		
	
}
