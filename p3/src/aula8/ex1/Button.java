package aula8.ex1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Button implements ActionListener {
	public static JToggleButton[][] buts;
	public static int[][] plays;
	public static int played;
	JFrame galo;
	public Button(int a){
		galo=new JFrame("Jogo do Galo");
		
		galo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		galo.setSize(500, 500);
		
		this.utton();
		galo.setVisible(true);
		
	}
	public void utton() {
		JPanel panel= new JPanel();
		panel.setLayout(new GridLayout(3,3));
		played=0;
		buts= new JToggleButton[3][3];
		plays= new int[3][3];
		for(int x=0; x<3; x++) {
			for (int y=0; y<3 ; y++) {
				plays[x][y]=0;
				JToggleButton b= new JToggleButton();
				b.addActionListener((ActionListener)this);
				buts[x][y]= b;
				panel.add(b);
			}
		}
		panel.setOpaque(true);
		this.galo.add(panel);
		
	}
	public void play(JToggleButton b) {
		for(int x = 0; x < 3; x++)
		{
			for(int y = 0; y < 3; y++)
			{
				if(b == Button.buts[x][y])
				{
					if(played%2==0)plays[x][y]=1;
					else plays[x][y]=2; 
					played++;
				}
			}
		}
	}
		
	public void actionPerformed(ActionEvent event) 
		{ 	
		JToggleButton b= (JToggleButton) event.getSource();
		b.setEnabled(false);
		if(played%2==0) b.setText("x");
		else {b.setText("O");}
		play(b);
		
		
			if(checkwin(plays)) {
				if(played%2==0) JOptionPane.showMessageDialog(galo, "O won"); 
				else JOptionPane.showMessageDialog(galo, "X WON");
				
				reset();}
			if(Button.played==9) {
				JOptionPane.showMessageDialog(galo, "It is a draw!");
				reset();
			}
		}
	private void reset() {
		for(int x = 0; x < 3; x++)
		{
			for(int y = 0; y < 3; y++)
			{
				Button.buts[x][y].setText(null);
				Button.buts[x][y].setSelected(false);	
				Button.buts[x][y].setEnabled(true);
			}
		}
		played=0;
		plays= new int[3][3];
	}
	private boolean checkwin(int[][] plays) {
		for(int x = 0; x < 3; x++)
		{
			if(plays[x][0] == plays[x][1] && plays[x][0] == plays[x][2] && plays[x][0] != 0)
			{
				return true;
			}
		}
		for(int y = 0; y < 3; y++)
			{

				if(plays[0][y] == plays[1][y] && plays[0][y] == plays[2][y] && plays[0][y] != 0)
				{
					return true;
				}
			
			}
		if(plays[0][0] == plays[1][1] && plays[0][0] == plays[2][2] && plays[0][0] != 0)
		{
			return true;
		}
		
		
		if(plays[2][0] == plays[1][1] && plays[2][0] == plays[0][2] && plays[2][0] != 0)
		{
			return true;
		}
		return false;
		} 
	
	
	public static void main(String[] args) {
		int newgame= 0;
		
		new Button(newgame);
	}
}

