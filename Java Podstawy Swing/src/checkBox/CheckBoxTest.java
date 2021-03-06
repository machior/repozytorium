package checkBox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CheckBoxTest  extends JFrame
{
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new CheckBoxTest();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Check Box Test");
				frame.setVisible(true);
				frame.setMinimumSize(new Dimension(200, 200));
				frame.setLocation(new Point(200, 200));
			}
		});
	}
	
	Font labelFont;
	JLabel label;
	JPanel checkBoxPanel;
	private static final int DEFEAULT_SIZE = 36;
	private ButtonGroup buttonGroup;
	
	
	public CheckBoxTest() 
	{
		//ustawienie dwóch głównych paneli z tekstem i z przyciskami
		setLayout(new BorderLayout());
		JPanel textPanel = new JPanel();
		add(textPanel, BorderLayout.CENTER);
		checkBoxPanel = new JPanel(new FlowLayout());
		add(checkBoxPanel, BorderLayout.SOUTH);

		//konfiguracja panelu zawwierającego tekst
		label = new JLabel("Koń i żółw grali w kości", JLabel.CENTER);
		labelFont = label.getFont();
		textPanel.setLayout(new BorderLayout());
		textPanel.add(label, BorderLayout.CENTER);
		
		checkBoxPanel.setBackground(Color.GRAY);
		
		addCheckBox("Pogrubienie", Font.BOLD);
		addCheckBox("Kursywa", Font.ITALIC);
		
		buttonGroup = new ButtonGroup();
		addRadioButton("Mała", 8);
		addRadioButton("Średnia", 12);
		addRadioButton("Duża", 16);
		addRadioButton("Bardzo duża", 32);
	}
	
	private void addCheckBox(String name, int fontStyle)
	{
		boolean selected = (label.getFont().getStyle() == fontStyle);
		JCheckBox checkBox = new JCheckBox(name, selected);
		checkBoxPanel.add(checkBox);
		checkBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkBox.isSelected())
					label.setFont(new Font(label.getText(), label.getFont().getStyle()|fontStyle, label.getFont().getSize()));
				else
					label.setFont(new Font(label.getText(), label.getFont().getStyle()&(~fontStyle), label.getFont().getSize()));
			}
		});
	}
	
	/**
	 * Funkcja wstawiająca przyciski radiowe
	 * @param name nazwa przycisku
	 * @param size rozmiar czcionki przycisku
	 */
	private void addRadioButton(String name, int size)
	{
		boolean selected = size == DEFEAULT_SIZE;
		JRadioButton radioButton = new JRadioButton(name, selected);
		buttonGroup.add(radioButton);
		checkBoxPanel.add(radioButton);

		radioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setFont(new Font(label.getText(), label.getFont().getStyle(), size));
			}
		});
	}
}
