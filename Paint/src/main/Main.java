package main;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) 
	{
		
		System.out.println();
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new MyFrame("Paint");
				
			}
		});
	}
}
