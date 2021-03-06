package menu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.*;
/**
* Ramka z paskiem menu
*/
public class MenuFrame extends JFrame
{
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	private Action saveAction;
	private Action saveAsAction;
	private JCheckBoxMenuItem readonlyItem;
	private JPopupMenu popup;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new MenuFrame();
				frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				frame.setVisible(true);
				
			}
		});
	}
	
	/**
	* Przykładowa akcja, która drukuje nazwę akcji do wyjścia System.out
	*/
	class TestAction extends AbstractAction
	{
		public TestAction(String name)
		{
			super(name);
		}
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("Wybrano " + getValue(Action.NAME));
		}
	}
	
	public MenuFrame()
	{
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		JMenu fileMenu = new JMenu("Plik");
		fileMenu.add(new TestAction("Nowy"));
		
		// Akceleratory
		JMenuItem openItem = fileMenu.add(new TestAction("Otwórz"));
		openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
		
		fileMenu.addSeparator();
		
		saveAction = new TestAction("Zapisz");
		JMenuItem saveItem = fileMenu.add(saveAction);
		saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
		
		saveAsAction = new TestAction("Zapisz jako");
		fileMenu.add(saveAsAction);
		fileMenu.addSeparator();
		
		fileMenu.add(new AbstractAction("Zakończ")
			{
				public void actionPerformed(ActionEvent event)
				{
					System.exit(0);
				}
			});
		
		// Menu z polem wyboru i przełącznikami
		
		readonlyItem = new JCheckBoxMenuItem("Tylko do odczytu");
		readonlyItem.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					boolean saveOk = !readonlyItem.isSelected();
					saveAction.setEnabled(saveOk);
					saveAsAction.setEnabled(saveOk);
				}
			});
		
		ButtonGroup group = new ButtonGroup();
		
		JRadioButtonMenuItem insertItem = new JRadioButtonMenuItem("Wstawianie");
		insertItem.setSelected(true);
		JRadioButtonMenuItem overtypeItem = new JRadioButtonMenuItem("Nadpisywanie");
		
		group.add(insertItem);
		group.add(overtypeItem);
		
		// Ikony
		
		Action cutAction = new TestAction("Wytnij");
		cutAction.putValue(Action.SMALL_ICON, new ImageIcon("cut.gif"));
		Action copyAction = new TestAction("Kopiuj");
		copyAction.putValue(Action.SMALL_ICON, new ImageIcon("copy.gif"));
		Action pasteAction = new TestAction("Wklej");
		pasteAction.putValue(Action.SMALL_ICON, new ImageIcon("paste.gif"));
		JMenu editMenu = new JMenu("Edycja");
		editMenu.add(cutAction);
		editMenu.add(copyAction);
		editMenu.add(pasteAction);
		
		// Zagnieżdżone menu
		
		JMenu optionMenu = new JMenu("Opcje");
		optionMenu.add(readonlyItem);
		optionMenu.addSeparator();
		optionMenu.add(insertItem);
		optionMenu.add(overtypeItem);
		editMenu.addSeparator();
		editMenu.add(optionMenu);
		
		// Mnemoniki
		
		JMenu helpMenu = new JMenu("Pomoc");
		helpMenu.setMnemonic('P');
		JMenuItem indexItem = new JMenuItem("Indeks");
		indexItem.setMnemonic('I');
		helpMenu.add(indexItem);
		
		// Mnemoniki można także dodawać do akcji
		
		Action aboutAction = new TestAction("O programie");
		aboutAction.putValue(Action.MNEMONIC_KEY, new Integer('O'));
		helpMenu.add(aboutAction);
		
		// Dodanie wszystkich menu najwyższego rzędu do paska menu
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
		
		// Menu kontekstowe
		
		popup = new JPopupMenu();
		popup.add(cutAction);
		popup.add(copyAction);
		popup.add(pasteAction);
		JPanel panel = new JPanel();
		panel.setComponentPopupMenu(popup);
		add(panel);
		
		// Poniższy wiersz stanowi obejście błędu 4966109
		
		panel.addMouseListener(new MouseAdapter() {});
		
		// Pasek narzędzi
		
		JButton blueButton = new JButton();
		blueButton.setBackground(Color.BLUE);
		blueButton.setToolTipText("niebieski przycisk dla fejmu");
		JToolBar bar = new JToolBar(SwingConstants.VERTICAL);
		bar.setToolTipText("ssdsd");
		bar.add(blueButton);
		bar.addSeparator();
		bar.add(redAction);
		redAction.putValue(Action.SHORT_DESCRIPTION, "Czerwony");
		redAction.putValue(Action.LONG_DESCRIPTION, "Długa deskrypcja");
		panel.add(bar);
	}
	
	Action redAction = new AbstractAction("RED") {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Jakaś tam akcja");
			setBackground(Color.RED);
		}
	};
}
