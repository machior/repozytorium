package comboBox;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderFrame extends JFrame 
{
	public static void main(String[] args) {
		JFrame frame = new SliderFrame();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLocation(200, 200);
		frame.setVisible(true);
	}
	
	private JPanel sliderPanel; //panel z suwakami
	private JTextField textField; //pole z wartością z suwaka
	private ChangeListener listener; //nasłuchiwacz suwaków
	
	public SliderFrame() {
		sliderPanel = new JPanel();
		sliderPanel.setLayout(new GridBagLayout());
		//nieedytowalne pole na dole okna
		textField = new JTextField("Oczekiwanie na zmianę wartości");
		textField.setEditable(false);
		//nasłuchiwacz
		listener = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider jSlider = (JSlider) e.getSource();
				textField.setText("" + jSlider.getValue());
			}
		};
		
		//zwykły suwak
		JSlider slider = new JSlider();
		addSlider(slider, "Zwykły");
		
		//suwak z podziałką
		slider = new JSlider();
		addSlider(slider, "Podziałka");
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(10);
		
		//suwak z dosuwaniem gałki do najbliższej kreski
		slider = new JSlider();
		addSlider(slider, "Dosuwany");
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(10);
		
		//suwak bez prowadnicy
		slider = new JSlider();
		addSlider(slider, "Bez prowadnicy");
		slider.setPaintTrack(false);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(10);
		
		//suwak odwrócony
		slider = new JSlider();
		addSlider(slider, "Odwrócony");
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(10);
		slider.setInverted(true);
		
		//suwak z etykietami
		slider = new JSlider();
		addSlider(slider, "Etykiety");
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(10);
		slider.setPaintLabels(true);
		
		//suwak z etykietami liczbowymi
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(20);
		
		Hashtable<Integer, Component> labelTable = new Hashtable<>();
		labelTable.put(0, new JLabel("A"));
		labelTable.put(20, new JLabel("B"));
		labelTable.put(40, new JLabel("C"));
		labelTable.put(60, new JLabel("D"));
		labelTable.put(80, new JLabel("E"));
		labelTable.put(100, new JLabel("F"));
		
		slider.setLabelTable(labelTable);
		addSlider(slider, "Niestandardowe etykiety");
		
		
		
		Border border = BorderFactory.createTitledBorder("Suwaki");
		sliderPanel.setBorder(border);
		add(sliderPanel, BorderLayout.CENTER);
		add(textField, BorderLayout.SOUTH);

		pack();
	}
	
	/**
	 * Dodaje suwak do panelu suwaków i wiąże słuchacza
	 * @param s suwak
	 * @param description opis suwaka
	 */
	public void addSlider(JSlider slider, String description)
	{
		slider.addChangeListener(listener);
		JPanel panel = new JPanel();
		panel.add(slider);
		panel.add(new JLabel(description));
		panel.setAlignmentX(JPanel.LEFT_ALIGNMENT);
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridy = sliderPanel.getComponentCount();
		constraints.anchor = GridBagConstraints.WEST;
		sliderPanel.add(panel, constraints);
		
	}
}
