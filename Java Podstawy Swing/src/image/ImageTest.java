package image;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class ImageTest 
{
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new ImageFrame();
				frame.setTitle("Moja ramka ze zdjęciem");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class ImageFrame extends JFrame
{
	public ImageFrame() {
		getContentPane().add(new ImageComponent());
		pack();
	}
}

class ImageComponent extends JComponent
{
	private static final int DEFEAULT_WIDTH = 300;
	private static final int DEFEAULT_HEIGHT = 200;
	
	private Image image;
	
	public ImageComponent()
	{
		image = new ImageIcon("icon.jpg").getImage();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		if(image == null) {
			System.out.println("nie ma foty");
			return;
		}
		System.out.println("jest fota");
		
		int imageWidth = image.getWidth(this);
		int imageHeight = image.getHeight(this);
		
		//ryzowanie w lewym górnym rogu
		g.drawImage(image, 0, 0, null);
		
		//powielanie w obrębie komponentu
		for(int i=0; i*imageWidth <= getWidth(); i++)
			for(int j=0; j*imageHeight <= getHeight(); j++)
				if(i+j>0) g.copyArea(0, 0, imageWidth, imageHeight, i*imageWidth, j*imageHeight);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(DEFEAULT_WIDTH, DEFEAULT_HEIGHT);
	}
}