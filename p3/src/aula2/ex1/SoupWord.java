package aula2;

public class SoupWord {
	private String word;
	private int x;
	private int y;
	private String direction;	
	
	public SoupWord(String word, int x, int y, String direction) {
		this.word = word;
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	public String getWord() {
		return this.word;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public String getDirection() {
		return this.direction;
	}
	
	public String toString() {
		return(this.word+"\t\t"+this.x+","+this.y+"\t\t"+this.direction+"\n");
	}
}
