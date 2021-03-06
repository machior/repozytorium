package font;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JSlider;

public class FontTest {
	
//	private static Font font;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frame = new TestFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Nie wiem jeszcze co");
//				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}
}

class TestFrame extends JFrame
{
	public TestFrame() {
		getContentPane().add(new TestComponent());
		
		try {
			setIconImage(ImageIO.read(new URL("http://mms.businesswire.com/media/20150226006430/en/455088/5/CYCxHAIN.jpg")));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {			 
			e.printStackTrace();
		}

		pack();
	}
}

class TestComponent extends JComponent
{
	private static final int DEFEAULT_WIDTH = 300;
	private static final int DEFEAULT_HEIGHT = 200;
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		String string = "jakiś tam łańcuch";
		
		Font myFont = new Font("SansSerif", Font.BOLD, 20);
		g2.setFont(myFont);
		
		//Sprawdzanie rozmiaru textu
		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D bounds = myFont.getStringBounds(string, context);
		
		// set(x, y) na lewy górny róg tekstu
		double x = (getWidth() - bounds.getWidth())/2;
		double y = (getHeight() - bounds.getHeight())/2;
		
		//dodanie wydłużenia górnego
		double ascent = -bounds.getY();
		double baseY = y + ascent;
		
		//rysowanie komunikatu
		g2.drawString(string, (int) x, (int) baseY);
		
		//rysowanie linii bazowej
		g2.setPaint(Color.GREEN);
		g2.draw(new Line2D.Double(x, baseY, x + bounds.getWidth(), baseY));
		
		//rysowanie otaczającego prostokąta
		g2.setPaint(Color.RED);
		bounds.setRect(x, y, bounds.getWidth(), bounds.getHeight());
		g2.draw(bounds);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(DEFEAULT_WIDTH, DEFEAULT_HEIGHT);
	}
}