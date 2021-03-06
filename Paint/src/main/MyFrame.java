package main;

import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	
	public MyFrame(String name) {
		//------------------------------
		//set a main window-------------
		super(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(300, 200, 800, 500);
		
		setLayout(null);
		//------------------------------
		
		
		//------------------------------
		//set left options panel--------
		LeftPanel leftPanel = new LeftPanel(this, LEFT_PANEL_WIDTH);
		//------------------------------
		
		//------------------------------
		//set "paper" panel-------------
		DrawingPanel drawingPanel = new DrawingPanel(this);
		drawingPanel.setBounds(100, 100, 500, 100);
		drawingPanel.setBackground(Color.BLUE);
		//------------------------------
		
//		Color chooser = JColorChooser.showDialog(null, "Choose color", Color.red);
//		System.out.println("Chooser color is " + chooser);
		
		//------------------------------
		//set top menu (File, Edit, etc.)
		MyMenu menu = new MyMenu(this);
		//------------------------------
		
		PaintColors[] pc = PaintColors.class.getEnumConstants();
		for(PaintColors colors : pc)
			System.out.println(colors.name() + colors);
		
		
	}

	final private static int LEFT_PANEL_WIDTH = 80;
}
