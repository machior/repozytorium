package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyMenu extends JMenuBar {
	
	//Watch at actionChoice(). Every first element is name of JMenu element, next elements are names of JMenuItems belonging to their JMenu parent
	final static String[][] menuNames = {
			{"File", "New", "Open...", "Save", "Save as..."},
			{"Edit", "Cut", "Copy", "Paste"},
			{"View", "Tool Box", "Color Box"},
			{"Image", "Flip/Rotate", "Invert Colors"},
			{"Colors", "Edit Colors"},
			{"Help", "Help Topics", "About"}
			};
	//Stores JMenus apperaing on menu bar
	private JMenu[] MyMenuArray = new JMenu[menuNames.length];
	
	/**
	 * Constructor of Paint's frame.
	 * @param frame extends JFrame
	 */
	public MyMenu(MyFrame frame) {
		super();
		frame.setJMenuBar(this);
		
		initMenu();
	}
	
	/**
	 * Menu initialisation.
	 */
	void initMenu(){
		for(int j=0; j<menuNames.length; ++j){
			for(int i=0; i<menuNames[j].length; ++i)
			{
				if(i==0){
					MyMenuArray[j] = new JMenu(menuNames[j][i]);
					add(MyMenuArray[j]);
				}
				else{
					initItems(j, i);
				}
			}
		}
	}
	
	void initItems(int j, int i)
	{
		JMenuItem item = new JMenuItem(menuNames[j][i]);
		MyMenuArray[j].add(item);
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				actionChoice(arg0.getActionCommand());
//				arg0.getSource().toString();
			}
		});
	}
	
	private void actionChoice(String name){
		System.out.println(name);
		
		switch (name) {
		//Buttons in "File" menu
		case "New":
			System.out.println("opcja 1.");
			break;
		case "Open...":
			System.out.println("opcja 2.");		
			break;
		case "Save":
			System.out.println("opcja 3.");
			break;
		case "Save as...":
			
			break;
		//Buttons in "Edit" menu
		case "Cut":
			
			break;
		case "Copy":
			
			break;
		case "Paste":
			
			break;
		//Buttons in "View" menu
		case "Tool Box":
			
			break;
		case "Color Box":
			
			break;
		//Buttons in "Image" menu
		case "Flip/Rotate":
			
			break;
		case "Invert Colors":
			
			break;
		//Buttons in "Colors" menu
		case "Edit Colors":
			
			break;
		//Buttons in "Help" menu
		case "Help Topics":
			
			break;
		case "About":
			
			break;

		default:
			System.out.println("Error. No service for this button.");
			break;
		}
	};
}