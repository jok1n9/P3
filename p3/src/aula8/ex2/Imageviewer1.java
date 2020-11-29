package aula8.ex2;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionEvent;

public class Imageviewer1 {
	private JFileChooser fileChooser;
	private JFrame frame;
	private File file;
	private Bitmap bmp;
	private JPanel image;
	private Bitmap bmp2;
	private PanelImage panelImage;
	private Pixel[][] a;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Imageviewer1 window = new Imageviewer1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Imageviewer1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame("ImageViewer1.0");
		
		frame.setBounds(100, 100, 1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JButton open = new JButton(" open       ");
		
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		        fileChooser.setAcceptAllFileFilterUsed(false);
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("BMP Images", "bmp");
		        fileChooser.addChoosableFileFilter(filter);
		        fileChooser.setDialogTitle("Open file");
		        int returnVal = fileChooser.showOpenDialog(null);
		        
		        if (returnVal == JFileChooser.APPROVE_OPTION) 
		        {
		            file = fileChooser.getSelectedFile();
		            try {
		            	if(bmp!=null) frame.remove(panelImage);
		            	bmp= new Bitmap(file.getAbsolutePath());
		            	panelImage = new PanelImage(bmp.getData(), bmp.bitmapInfoHeader.getWidth(),bmp.bitmapInfoHeader.getHeight());
		        		panelImage.setBounds(5, 5, 1920, 1080);
		        		frame.getContentPane().add(panelImage);
		        		frame.revalidate();
		    			frame.repaint();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            
					
		        }
			}});
		mnNewMenu.add(open);
		JButton save = new JButton(" save       ");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					RandomAccessFile bmpFile = new RandomAccessFile(file.getAbsolutePath(), "rw");
					
					//File Header
					bmpFile.writeShort(Short.reverseBytes(bmp.getBitmapFileHeader().getType()));
					bmpFile.writeInt(Integer.reverseBytes(bmp.getBitmapFileHeader().getSize()));
					bmpFile.writeShort(0);
					bmpFile.writeShort(0);
					bmpFile.writeInt(Integer.reverseBytes(bmp.getBitmapFileHeader().getOffBits()));
				
					//Info header
					bmpFile.writeInt(Integer.reverseBytes(bmp.getBitmapInfoHeader().getSize()));
					bmpFile.writeInt(Integer.reverseBytes(bmp.getBitmapInfoHeader().getWidth()));
					bmpFile.writeInt(Integer.reverseBytes(-Math.abs(bmp.getBitmapInfoHeader().getHeight())));
					bmpFile.writeShort(Short.reverseBytes(bmp.getBitmapInfoHeader().getPlanes()));
					bmpFile.writeShort(Short.reverseBytes(bmp.getBitmapInfoHeader().getBitCount()));
					bmpFile.writeInt(Integer.reverseBytes(bmp.getBitmapInfoHeader().getCompression()));
					bmpFile.writeInt(Integer.reverseBytes(bmp.getBitmapInfoHeader().getSizeImage()));
					bmpFile.writeInt(Integer.reverseBytes(bmp.getBitmapInfoHeader().getxPelsPerMeter()));
					bmpFile.writeInt(Integer.reverseBytes(bmp.getBitmapInfoHeader().getyPelsPerMeter()));
					bmpFile.writeInt(Integer.reverseBytes(bmp.getBitmapInfoHeader().getClrUsed()));
					bmpFile.writeInt(Integer.reverseBytes(bmp.getBitmapInfoHeader().getClrImportant()));
	
					bmpFile.write(Bitmap.pixelToByteArray(bmp.getPixelArray()));
					bmpFile.close();
					JOptionPane.showMessageDialog(frame, "Image saved with success");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(save);
		
		JButton saveas = new JButton("save as.. ");
		saveas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(bmp!=null) {
					fileChooser = new JFileChooser();
					fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			        fileChooser.setAcceptAllFileFilterUsed(false);
			        FileNameExtensionFilter bmpFilter = new FileNameExtensionFilter("BMP Images", "bmp");
			        fileChooser.addChoosableFileFilter(bmpFilter);
			        fileChooser.setDialogTitle("Save As");
			        
			        int returnVal = fileChooser.showSaveDialog(null);
			        
			        if (returnVal == JFileChooser.APPROVE_OPTION) 
			        {
			        	File file = fileChooser.getSelectedFile();
			            try
			            {
			            	String a= file.getAbsolutePath()+ ".bmp";
			            	RandomAccessFile bmpFile = new RandomAccessFile(a, "rw");
							
							//File Header
							bmpFile.writeShort(Short.reverseBytes(bmp.getBitmapFileHeader().getType()));
							bmpFile.writeInt(Integer.reverseBytes(bmp.getBitmapFileHeader().getSize()));
							bmpFile.writeShort(0);
							bmpFile.writeShort(0);
							bmpFile.writeInt(Integer.reverseBytes(bmp.getBitmapFileHeader().getOffBits()));
						
							//Info header
							bmpFile.writeInt(Integer.reverseBytes(bmp.getBitmapInfoHeader().getSize()));
							bmpFile.writeInt(Integer.reverseBytes(bmp.getBitmapInfoHeader().getWidth()));
							bmpFile.writeInt(Integer.reverseBytes(-Math.abs(bmp.getBitmapInfoHeader().getHeight())));
							bmpFile.writeShort(Short.reverseBytes(bmp.getBitmapInfoHeader().getPlanes()));
							bmpFile.writeShort(Short.reverseBytes(bmp.getBitmapInfoHeader().getBitCount()));
							bmpFile.writeInt(Integer.reverseBytes(bmp.getBitmapInfoHeader().getCompression()));
							bmpFile.writeInt(Integer.reverseBytes(bmp.getBitmapInfoHeader().getSizeImage()));
							bmpFile.writeInt(Integer.reverseBytes(bmp.getBitmapInfoHeader().getxPelsPerMeter()));
							bmpFile.writeInt(Integer.reverseBytes(bmp.getBitmapInfoHeader().getyPelsPerMeter()));
							bmpFile.writeInt(Integer.reverseBytes(bmp.getBitmapInfoHeader().getClrUsed()));
							bmpFile.writeInt(Integer.reverseBytes(bmp.getBitmapInfoHeader().getClrImportant()));
			
							bmpFile.write(Bitmap.pixelToByteArray(bmp.getPixelArray()));
							bmpFile.close();
							JOptionPane.showMessageDialog(frame, "Image saved with success");	      
			            	
						} 
			            catch (IOException e1)
			            {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			        }else {JOptionPane.showMessageDialog(frame, "Not Valid");}
			    }else {JOptionPane.showMessageDialog(frame, "No image loaded");} 
		        }
			
		});
		mnNewMenu.add(saveas);
		
		JButton resize = new JButton("Resize");
		resize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(panelImage);
				bmp.resize();
				panelImage = new PanelImage(bmp.getData(), bmp.bitmapInfoHeader.getWidth(),bmp.bitmapInfoHeader.getHeight());
        		panelImage.setBounds(5, 5, 1920, 1080);
        		frame.getContentPane().add(panelImage);
        		frame.revalidate();
    			frame.repaint();
			}
		});
		menuBar.add(resize);
		
		JButton horizontal = new JButton(" Horizontal flip   ");
		horizontal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(panelImage);
				a=bmp.flipHorizontal();
				bmp.setData(Bitmap.pixelToByteArray(a));
				
				panelImage = new PanelImage(bmp.getData(), bmp.bitmapInfoHeader.getWidth(),bmp.bitmapInfoHeader.getHeight());
        		panelImage.setBounds(5, 5, 1920, 1080);
        		frame.getContentPane().add(panelImage);
        		frame.revalidate();
    			frame.repaint();
			}
		});
		menuBar.add(horizontal);
		
		JButton vertical = new JButton(" Vertical flip  ");
		vertical.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(panelImage);
				a=bmp.flipVertical();
				bmp.setData(Bitmap.pixelToByteArray(a));
				
				panelImage = new PanelImage(bmp.getData(), bmp.bitmapInfoHeader.getWidth(),bmp.bitmapInfoHeader.getHeight());
        		panelImage.setBounds(5, 5, 1920, 1080);
        		frame.getContentPane().add(panelImage);
        		frame.revalidate();
    			frame.repaint();
			}
		});
		menuBar.add(vertical);
		frame.getContentPane().setLayout(null);
		}

}
