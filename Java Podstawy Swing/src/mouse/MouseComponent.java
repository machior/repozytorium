package mouse;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class MouseComponent extends JComponent
{
	private static final int SIDELENGTH = 10;
	private ArrayList<Rectangle2D> squares;
	private Rectangle2D current;
	public MouseComponent()
	{
		squares = new ArrayList<>();
		current = null;
		addMouseListener(new MouseHandler());
		addMouseMotionListener(new MouseMotionHandler());
	}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		// Rysowanie wszystkich kwadratów
		for (Rectangle2D r : squares)
		g2.draw(r);
	}
	/**
	* Znajduje pierwszy kwadrat zawierający punkt.
	* @param p punkt
	* @return pierwszy kwadrat zawierający punkt p
	*/
	public Rectangle2D find(Point2D p)
	{
		for (Rectangle2D r : squares)
		{
			if (r.contains(p)) return r;
		}
		return null;
	}
	/**
	* Dodaje kwadrat do zbioru.
	* @param p środek kwadratu
	*/
	public void add(Point2D p)
	{
		double x = p.getX();
		double y = p.getY();
		current = new Rectangle2D.Double(x - SIDELENGTH / 2, y - SIDELENGTH/2, SIDELENGTH, SIDELENGTH);
		squares.add(current);
		repaint();
	}
	public void remove(Rectangle2D s)
	{
		if (s == null) return;
		if (s == current) current = null;
		squares.remove(s);
		repaint();
	}
	// Kwadrat zawierający kursor
	private class MouseHandler extends MouseAdapter
	{
		public void mousePressed(MouseEvent event)
		{
			// Dodanie nowego kwadratu, jeśli kursor nie jest wewnątrz innego kwadratu
			current = find(event.getPoint());
			if (current == null) add(event.getPoint());
		}
		public void mouseClicked(MouseEvent event)
		{
			// Usunięcie kwadratu w wyniku jego dwukrotnego kliknięcia
			current = find(event.getPoint());
			if (!current.equals(null) && event.getClickCount() >= 2) remove(current);
		}
	}
	private class MouseMotionHandler implements MouseMotionListener
	{
		public void mouseMoved(MouseEvent event)
		{
			// Ustawienie kursora na krzyżyk, jeśli znajduje się wewnątrz kwadratu
			if (find(event.getPoint()) == null) setCursor(Cursor.getDefaultCursor());
			else setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		}
		public void mouseDragged(MouseEvent event)
		{
			if (current != null)
			{
				int x = event.getX();
				int y = event.getY();
				// Przeciągnięcie aktualnego kwadratu w celu wyśrodkowania go w punkcie (x, y)
				current.setFrame(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
				repaint();
			}
		}
	}
}