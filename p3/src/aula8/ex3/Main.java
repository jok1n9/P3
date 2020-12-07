package aula8.ex3;

import java.io.IOException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main {	
	
	private static JFrame frame;
	private static JRadioButton but1;
	private static JRadioButton but2;
	private static JRadioButton but3;
	private static JRadioButton but4;
	private static ButtonGroup choices;
	private static JTextArea question;
	private static JLabel money;
	private static JButton exit;
	private static JButton confirm;
	private static JButton audience;
	private static JButton phone;
	private static JButton help50_50;
	private static JLabel image;
	private static Game game;
	private static Question q;
	private static AudioFilePlayer player; //a joke

	public static void main(String[] args) throws IOException {			
		
		//Start Game
		game = new Game();
		player = new AudioFilePlayer();
		
		
		//SetUpWindow
		frame = new JFrame("Quem quer ser Milionário");
		frame.setBounds(100, 100, 711, 556);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		setupWindow();			
		
		while(game.getLevel() != 15) {			
			
			q = game.getQuestion();
			
			//update options			
			
			but1.setText(q.getOptions()[0]);
			but2.setText(q.getOptions()[1]);
			but3.setText(q.getOptions()[2]);
			but4.setText(q.getOptions()[3]);
			
			//update question
			question.setText(q.getQuestion());
			
			//update money
			money.setText(Integer.toString(game.getMoney()));
			
			//update image
			image.setIcon(new ImageIcon(new ImageIcon(q.getPath()).getImage().getScaledInstance(315, 322, Image.SCALE_DEFAULT)));
						
			frame.setVisible(true);				
			
		}
		
		JOptionPane.showMessageDialog(frame,"Parabéns Milionário\nGanhou 250000");		
			

	}
	
	public static void setupWindow() {
		
		choices = new ButtonGroup();		
		
		//option 1
		but1 = new JRadioButton("");
		but1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		but1.setBounds(28, 405, 201, 49);
		but1.setActionCommand("0");
		choices.add(but1);
		frame.getContentPane().add(but1);		
		
		//option 2
		but2 = new JRadioButton("");
		but2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		but2.setBounds(249, 405, 201, 49);
		but2.setActionCommand("1");
		choices.add(but2);
		frame.getContentPane().add(but2);
		
		//option 3
		but3 = new JRadioButton("");
		but3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		but3.setBounds(28, 457, 201, 39);
		but3.setActionCommand("2");
		choices.add(but3);
		frame.getContentPane().add(but3);		
		
		//option 4
		but4 = new JRadioButton("");
		but4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		but4.setBounds(249, 457, 201, 39);	
		but4.setActionCommand("3");
		choices.add(but4);
		frame.getContentPane().add(but4);
		
		//question
		question = new JTextArea();
		question.setBounds(351, 126, 315, 207);
		question.setLineWrap(true);
		question.setWrapStyleWord(true);
		question.setFont(new Font("Tahoma", Font.BOLD, 20));
		question.setEditable(false);
		frame.getContentPane().add(question);
		
		//money
		money = new JLabel("New label");
		money.setBounds(639, 11, 46, 14);		
		frame.getContentPane().add(money);
		
		//exit button
		exit = new JButton("Desistir");
		exit.setBounds(572, 453, 97, 31);
		//exit action listener
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame,"Ganhou "+game.getMoney());				
				System.exit(0);
			}
		});
		frame.getContentPane().add(exit);
		
		//confirm button
		confirm = new JButton("Comfirmar");		
		confirm.setBounds(465, 453, 97, 31);
		
		//confirm action listener
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(but1.isSelected())
					if(q.getRightIndex() == 0) {						
						choices.clearSelection();
						but1.setEnabled(true);
						but2.setEnabled(true);
						but3.setEnabled(true);
						but4.setEnabled(true); //enable all buttons in case 50/50 help is used
						player.play("src/aula8/ex3/sounds/correta.wav");
						game.levelUp();	
						
					}						
					else {
						JOptionPane.showMessageDialog(frame,"Ganhou "+game.getMoney());	
						player.play("src/aula8/ex3/sounds/errada.wav");
						System.exit(0);
					}
				if(but2.isSelected())
					if(q.getRightIndex() == 1) {						
						choices.clearSelection();
						but1.setEnabled(true);
						but2.setEnabled(true);
						but3.setEnabled(true);
						but4.setEnabled(true); //enable all buttons in case 50/50 help is used
						player.play("src/aula8/ex3/sounds/correta.wav");
						game.levelUp();						
					}						
					else {
						player.play("src/aula8/ex3/sounds/errada.wav");
						JOptionPane.showMessageDialog(frame,"Ganhou "+game.getMoney());						
						System.exit(0);
					}
				if(but3.isSelected())
					if(q.getRightIndex() == 2) {						
						choices.clearSelection();
						but1.setEnabled(true);
						but2.setEnabled(true);
						but3.setEnabled(true);
						but4.setEnabled(true); //enable all buttons in case 50/50 help is used
						player.play("src/aula8/ex3/sounds/correta.wav");
						game.levelUp();						
					}						
					else {
						player.play("src/aula8/ex3/sounds/errada.wav");
						JOptionPane.showMessageDialog(frame,"Ganhou "+game.getMoney());						
						System.exit(0);
					}
				if(but4.isSelected())
					if(q.getRightIndex() == 3) {						
						choices.clearSelection();
						but1.setEnabled(true);
						but2.setEnabled(true);
						but3.setEnabled(true);
						but4.setEnabled(true); //enable all buttons in case 50/50 help is used
						player.play("src/aula8/ex3/sounds/correta.wav");						
						game.levelUp();						
					}						
					else {
						player.play("src/aula8/ex3/sounds/errada.wav");
						JOptionPane.showMessageDialog(frame,"Ganhou "+game.getMoney());							
						System.exit(0);
					}
			}
		});		
		frame.getContentPane().add(confirm);
		
		//image label
		image = new JLabel("New label");
		image.setHorizontalAlignment(SwingConstants.CENTER);
		image.setBounds(10, 11, 315, 322);
		frame.getContentPane().add(image);
		
		//audience button
		audience = new JButton("Ajuda Público");
		audience.setBounds(10, 364, 116, 34);
		audience.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] pub = Game.publicLifeline(q);
				JOptionPane.showMessageDialog(frame,"Ajuda do Público:\n"+
													q.getOptions()[0]+":  "+pub[0]+"%\n"+
													q.getOptions()[1]+":  "+pub[1]+"%\n"+
													q.getOptions()[2]+":  "+pub[2]+"%\n"+
													q.getOptions()[3]+":  "+pub[3]+"%");
				audience.setEnabled(false);
			}
		});
		
		frame.getContentPane().add(audience);
		
		//phone button
		phone = new JButton("Telefone...");
		phone.setBounds(136, 364, 118, 34);
		//Phone listener
		phone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[]help = Game.publicLifeline(q);
				int i = q.getRightIndex();
				int r = Game.getRandomIndex(q);
				JOptionPane.showMessageDialog(frame,"Dúvida entre\n"+
													q.getOptions()[i]+":  "+help[i]+"%\n"+
													q.getOptions()[r]+":  "+help[r]+"%");
				phone.setEnabled(false);
			}
		});
		frame.getContentPane().add(phone);
		
		//50-50 button
		help50_50 = new JButton("50-50");
		help50_50.setBounds(264, 364, 116, 34);
		//50-50 action listener
		help50_50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JRadioButton[] buts = {but1,but2,but3,but4};				
				for(JRadioButton b : buts) {
					b.setEnabled(false);
				}
				buts[q.getRightIndex()].setEnabled(true);
				buts[Game.getRandomIndex(q)].setEnabled(true);
				help50_50.setEnabled(false);
				
			}
		});
		frame.getContentPane().add(help50_50);				
	}
	
	public static void startGame() throws IOException {
		game = new Game();		
	}
	
	public static void setVisible() {
		frame.setVisible(true);
	}
	
}
