package calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CalculatorPanel extends JPanel 
{
	private JButton display;
	private JButton outcome;
	private JPanel panel;
	private double result;
	private String lastCommand;
	private boolean givenCommand;
	private static int WIN_DEF_WIDTH = 200;
	private static int WIN_DEF_HEIGHT = 200;
	
	public static void main(String[] args) {
		 EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setMinimumSize(new Dimension(WIN_DEF_WIDTH , WIN_DEF_HEIGHT));
				frame.add(new CalculatorPanel());
				frame.setVisible(true);
				frame.setLocation(
						(int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() - WIN_DEF_WIDTH)/2, 
						(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight() - WIN_DEF_HEIGHT)/2);
			}
		});
	}
	
	public CalculatorPanel()
	{
		setLayout(new BorderLayout());
		
		result = 0;
		lastCommand = "=";
		givenCommand = false;
		
		//dodanie wyświetlacza
		display = new JButton("0");
		display.setEnabled(false);
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		outcome = new JButton("");
		outcome.setEnabled(false);
		outcome.setHorizontalAlignment(SwingConstants.RIGHT);
		JPanel windowPanel = new JPanel();
		windowPanel.setLayout(new BorderLayout());
		windowPanel.add(display, BorderLayout.SOUTH);
		windowPanel.add(outcome, BorderLayout.NORTH);
		add(windowPanel, BorderLayout.NORTH);
		
		ActionListener insert = new InsertAction();
		ActionListener command = new CommandAction();
		
		//wstawienie przycisków na siatkę 4x4
		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4));
		
		addButton("7", insert);
		addButton("8", insert);
		addButton("9", insert);
		addButton("+", command);
		
		addButton("4", insert);
		addButton("5", insert);
		addButton("6", insert);
		addButton("-", command);
		
		addButton("1", insert);
		addButton("2", insert);
		addButton("3", insert);
		addButton("*", command);
		
		addButton("0", insert);
		addButton(".", insert);
		addButton("C", command);
		addButton("/", command);
		
		JButton C = new JButton("=");
		C.addActionListener(command);
		add(C, BorderLayout.SOUTH);
		
		add(panel, BorderLayout.CENTER);
	}
	 /**
	  * Dodaje przycisk do panelu centralnego
	  * @param label etykieta przycisku
	  * @param listener słuchacz przycisków
	  */
	private void addButton(String label, ActionListener listener)
	{
		JButton button = new JButton(label);
		button.addActionListener(listener);
		panel.add(button);
	}
	
	/**
	 * Ta akcja wstawia łąńcuch akcji przycisku na końcu tekstu wyświetlania
	 */
	class InsertAction implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(display.getText().equals("0") && !e.getActionCommand().equals("."))
				display.setText(e.getActionCommand());
			else display.setText(display.getText() + e.getActionCommand());
		}
	}
	
	/**
	 * Ta kacja wykonuje polecenia określone przez akcję przycisku
	 */
	class CommandAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if(!command.equals("=") && !command.equals("C"))
			{
//				System.out.println("debug +");
				calculate(Double.parseDouble(display.getText()));
				outcome.setText(result + command);
				lastCommand = command;
			}
			else if(command.equals("="))
			{
				calculate(Double.parseDouble(display.getText()));
				outcome.setText(String.valueOf(result));
				lastCommand = command;
			}
			else if(command.equals("C"))
			{
				result=0;
				display.setText("0");
				outcome.setText("");
				lastCommand="=";
			}
		}
		
	}
	
	public void calculate(double x)
	{
		if(lastCommand.equals("+")) result += x;
		else if (lastCommand.equals("-")) result -= x;
		else if (lastCommand.equals("*")) result *= x;
		else if (lastCommand.equals("/")) result /= x;
		else if (lastCommand.equals("=")) result = x;
		display.setText("0");
	}
}
