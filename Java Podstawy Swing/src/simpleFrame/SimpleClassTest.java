package simpleFrame;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SimpleClassTest 
{
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frame = new SimpleFrame();
				frame.setTitle("Moja ramka");
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}
}

class SimpleFrame extends JFrame
{
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public SimpleFrame(){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		System.out.println("width is " + width + "\nheight is " + height);
//		setSize(width/2, height/2);
		setExtendedState(JFrame.ICONIFIED);
		setLocationByPlatform(true);
		
		Image image = new ImageIcon("icon.jpg").getImage();
		setIconImage(image);
	}
}