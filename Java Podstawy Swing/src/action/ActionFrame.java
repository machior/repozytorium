package action;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ActionFrame extends JFrame
{
	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public static void main(String[] args) {
		JFrame frame = new ActionFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public ActionFrame()
	{
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		buttonPanel = new JPanel();
		// Definicje akcji
		Action yellowAction = new ColorAction("Żółty", new ImageIcon("yellow-ball.jpg"), Color.YELLOW);
		Action blueAction = new ColorAction("Niebieski", new ImageIcon("blue-ball.jpg"), Color.BLUE);
		Action redAction = new ColorAction("Czerwony", new ImageIcon("red-ball.png"), Color.RED);
		// Dodanie przycisków dla akcji
		buttonPanel.add(new JButton(yellowAction));
		buttonPanel.add(new JButton(blueAction));
		buttonPanel.add(new JButton(redAction));
		// Dodanie panelu do ramki
		add(buttonPanel);
		// Powiązanie klawiszy Z, N i C z nazwami
		InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		imap.put(KeyStroke.getKeyStroke("ctrl Z"), "panel.yellow");
		imap.put(KeyStroke.getKeyStroke("ctrl N"), "panel.blue");
		imap.put(KeyStroke.getKeyStroke("ctrl C"), "panel.red");
		// Powiązanie nazw z akcjami
		ActionMap amap = buttonPanel.getActionMap();
		amap.put("panel.yellow", yellowAction);
		amap.put("panel.blue", blueAction);
		amap.put("panel.red", redAction);
	}
	
	public class ColorAction extends AbstractAction
	{
		/**
		* Tworzy akcję zmiany koloru.
		* @param name nazwa, która pojawi się na przycisku
		* @param icon ikona, która pojawi się na przycisku
		* @param c kolor tła
		*/
		public ColorAction(String name, Icon icon, Color c)
		{
			putValue(Action.NAME, name);
			putValue(Action.SMALL_ICON, icon);
			putValue(Action.SHORT_DESCRIPTION, "Ustaw kolor panelu na " + name.toLowerCase());
			putValue("color", c);
		}
		
		@Override
		public void actionPerformed(ActionEvent event)
		{
			Color c = (Color) getValue("color");
			buttonPanel.setBackground(c);
		}
	}
}
