package button;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonFrame extends JFrame {
	
	private JPanel buttonPanel;
	private static final int DEFEAULT_WIDTH = 300;
	private static final int DEFEAULT_HEIGHT = 200;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ButtonFrame frame = new ButtonFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						System.out.println("Zamykam okno");
					}
				});
				frame.setVisible(true);
			}
		});
	}
	
	public ButtonFrame() {
		setSize(DEFEAULT_WIDTH, DEFEAULT_HEIGHT);
		
		setLayout(new BorderLayout());
		
		buttonPanel = new JPanel();
		buttonPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Klikasz");
			}
		});
		
		//dodanie panelu do ramki
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		makeButton("Żółty", Color.YELLOW);
		makeButton("Niebieski", Color.BLUE);
		makeButton("Czerwony", Color.RED);
//		makeButton("Pomarańczowy", Color.ORANGE);
//		makeButton("Czarny", Color.BLACK);
//		makeButton("Biały", Color.WHITE);
	}
	
	public void makeButton(String name, Color background)
	{
		JButton button = new JButton(name);
		buttonPanel.add(button);
		//przypisanie tego obiektu do tworzonego przycisku
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setBackground(background);
			}
		});
	}
}