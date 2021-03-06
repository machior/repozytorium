package plaf;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
/**
* Ramka z panelem zawierającym przyciski zmieniające styl.
*/
@SuppressWarnings("serial")
public class PlafFrame extends JFrame
{
	private JPanel buttonPanel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				PlafFrame frame = new PlafFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
	
	public PlafFrame()
	{
		buttonPanel = new JPanel();
		UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
		for (UIManager.LookAndFeelInfo info : infos)
		makeButton(info.getName(), info.getClassName());
		add(buttonPanel);
		pack();
	}
	/**
	* Tworzy przycisk zmieniający styl.
	* @param name nazwa przycisku
	* @param plafName nazwa klasy stylu
	*/
	void makeButton(String name, final String plafName)
	{
		// Dodanie przycisku do panelu.
		JButton button = new JButton(name);
		buttonPanel.add(button);
		// Ustawienie akcji przycisku.
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				// Akcja przycisku — przełączenie na nowy styl.
				try
				{
					UIManager.setLookAndFeel(plafName);
					SwingUtilities.updateComponentTreeUI(PlafFrame.this);
					pack();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
}
