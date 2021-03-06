package draw;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * @version 1.0 16.09.2016
 * @author Bartek
 *
 */

public class DrawTest {
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new DrawFrame();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Draw test");
			}
		});
	}

}

/**
 * Ramka zawierająca panel z rysunkami
 */
class DrawFrame extends JFrame
{
	public DrawFrame() {
		add(new DrawComponent());
		pack();
	}
}

@SuppressWarnings("serial")
class DrawComponent extends JComponent
{
	private static final int DEFEAULT_WIDTH = 400;
	private static final int DEFEAULT_HEIGHT = 400;
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		double leftX = 100;
		double topY = 100;
		double width = 200;
		double height = 150;
		
		//rysoweanie prostokąta
		Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
		g2.draw(rect);
		
		//rysowanie elipsy
		Ellipse2D ellipse = new Ellipse2D.Double();
		ellipse.setFrame(rect);
		g2.draw(ellipse);
		
		//rysowanie przekątnej
		g2.draw(new Line2D.Double(leftX, topY, leftX + width, topY + height));		

		//rysowanie koła z takim samym środkiem
//		double centerX = (leftX*2 + width)/2;
//		double centerY = (topY*2 + height)/2;
		double centerX = rect.getCenterX();
		double centerY = rect.getCenterY();
		double radius = 150;
		
		Ellipse2D circle = new Ellipse2D.Double();
		circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
		g2.draw(circle);
		
		String string = "laska z kału";
		g2.setColor(SystemColor.scrollbar);
		g2.drawString(string, 20, 20);
		
		setBackground(Color.GREEN);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(DEFEAULT_WIDTH, DEFEAULT_HEIGHT);
	}
}