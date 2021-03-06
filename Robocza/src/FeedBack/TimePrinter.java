package FeedBack;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TimePrinter implements ActionListener
{
	public static void main(String[] args) 
	{
		TimePrinter listener = new TimePrinter();
		Timer t = new Timer(1000, listener);
		t.start();
		JOptionPane.showMessageDialog(null, "Zamknąć program?");
		System.exit(0);
	}
	
	/**
	 * @param event wykryte zdażenie
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		Date now = new Date(); 
		System.out.println("Kiedy usłyszysz dzwięk, będzie godzina " + now);
		Toolkit.getDefaultToolkit().beep();
		System.out.println(Toolkit.getDefaultToolkit().getScreenSize());
	}
	
}
