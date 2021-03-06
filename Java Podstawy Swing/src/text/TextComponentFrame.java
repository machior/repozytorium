package text;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

public class TextComponentFrame extends JFrame
{
	public static final int TEXTAREA_ROWS = 8;
	public static final int TEXTAREA_COLUMNS = 20;
	
	JButton insertButton;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new TextComponentFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
	
	public TextComponentFrame()
	{
		final JTextField textField = new JTextField();
		final JPasswordField passwordField = new JPasswordField();
		
		textField.addKeyListener(new EnterReaction());
		passwordField.addKeyListener(new EnterReaction());
		
		JPanel northPanel = new JPanel();
		
		northPanel.setLayout(new GridLayout(2, 2));
		northPanel.add(new JLabel("Nazwa użytkownika: ", SwingConstants.RIGHT));
		northPanel.add(textField);
		northPanel.add(new JLabel("Hasło: ", SwingConstants.RIGHT));
		northPanel.add(passwordField);
		
		add(northPanel, BorderLayout.NORTH);
		
		final JTextArea textArea = new JTextArea(TEXTAREA_ROWS, TEXTAREA_COLUMNS);
		JScrollPane scrollPane = new JScrollPane(textArea);
		add(scrollPane, BorderLayout.CENTER);
		// Dodanie przycisku wstawiającego tekst do obszaru tekstowego
		JPanel southPanel = new JPanel();
		insertButton = new JButton("Wstaw");
		southPanel.add(insertButton);
		insertButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					textArea.append("Nazwa użytkownika: " + textField.getText() + "\nHasło: "
					+ new String(passwordField.getPassword()) + "\n");
				}
			});
		pack();
	}
	
	private class EnterReaction extends KeyAdapter
	{
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER)
				insertButton.doClick();
		}
	}
}
