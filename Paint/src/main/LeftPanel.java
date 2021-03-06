package main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class LeftPanel extends JPanel 
{
	public LeftPanel(MyFrame frame, int width) {
		super();
		frame.add(this);
		setBounds(0, 0, width, frame.getHeight());
		setBackground(Color.gray);
		this.frame = frame;
		this.width = width;
		
		setLayout(new FlowLayout());
		
		viewButtons(this);
		viewColors(this);
	}
	
	private static void viewButtons(LeftPanel leftPanel)
	{
		
	}
	
	private static void viewColors(LeftPanel leftPanel)
	{
		PaintColors[] sampleColors = PaintColors.class.getEnumConstants();
		for(PaintColors paintColor : sampleColors)
		{
			JPanel sampleColor = new JPanel();
			sampleColor.setBackground(paintColor.getColor());
			leftPanel.add(sampleColor);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		setBounds(0, 0, width, frame.getHeight());
		setBackground(Color.gray);
	}

	private MyFrame frame;
	private int width;
}
