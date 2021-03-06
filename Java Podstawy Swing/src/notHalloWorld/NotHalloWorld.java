package notHalloWorld;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class NotHalloWorld 
{
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				JFrame frame = new NotHalloWorldFrame();
				frame.setTitle("NotHalloWorldWindow");
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}
}

class NotHalloWorldFrame extends JFrame
{
	public NotHalloWorldFrame() {
		add(new NotHalloWorldComponent());
		pack();
	}
}

class NotHalloWorldComponent extends JComponent
{
	public static final int MESSAGE_X = 75;
	public static final int MESSAGE_Y = 75;
	
	public static final int DEFALT_WIDTH = 300;
	public static final int DEFALT_HEIGHT = 600;
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawString("To nie jest program \"witaj swiecie \"", MESSAGE_X, MESSAGE_Y);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(DEFALT_WIDTH, DEFALT_HEIGHT);
	}
}