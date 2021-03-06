package comboBox;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
* Ramka z przykładową etykietą tekstową i listą rozwijalną umożliwiającą wybór kroju czcionki.
*/
public class ComboBoxFrame extends JFrame
{
	private JComboBox<String> faceCombo;
	private JLabel label;
	private static final int DEFAULT_SIZE = 24;
	
	public static void main(String[] args) {
		JFrame frame = new ComboBoxFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public ComboBoxFrame()
	{
		label = new JLabel("Koń i pies grali w kości z piękną ćmą u źródła.");
		label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
		add(label, BorderLayout.CENTER);
		
		faceCombo = new JComboBox<>();
		faceCombo.addItem("Serif");
		faceCombo.addItem("SansSerif");
		faceCombo.addItem("Monospaced");
		faceCombo.addItem("Dialog");
		faceCombo.addItem("DialogInput");
		
		faceCombo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setFont(new Font(faceCombo.getItemAt(faceCombo.getSelectedIndex()), Font.PLAIN, DEFAULT_SIZE));
			}
		});
		
		JPanel comboPanel = new JPanel();
		comboPanel.add(faceCombo);
		add(comboPanel, BorderLayout.SOUTH);
		pack();
	}
}