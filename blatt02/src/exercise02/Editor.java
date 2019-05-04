package exercise02;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public abstract class Editor {
	
	// To get Access in control
	private static JTextArea textField;
	private static JFrame quitFrame;
	private static Control actionListener;
	
	public static void main(String[] args) {
		
		// Setting up the Frame
		JFrame frame  = new JFrame("Notepad Bolle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JLabel label = new JLabel("Notepad Bolle");
		textField = new JTextArea(50,50);
		
		frame.getContentPane().add(label);
		
		// Scroll Pane for scrolling
		JScrollPane scrollPane = new JScrollPane(textField);
		frame.getContentPane().add(scrollPane);
		
		// Setting up the menu
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem menuItemOpen = new JMenuItem("Open");
		JMenuItem menuItemSave = new JMenuItem("Save");
		JMenuItem menuItemSaveAs = new JMenuItem("Save As");
		JMenuItem menuItemQuit = new JMenuItem("Quit");
		
		// Creating Action Listener and KeyListener
		actionListener = new Control();
		Control keyListener = new Control();
		Control documentListener = new Control();
		
		textField.addKeyListener(keyListener);
		textField.getDocument().addDocumentListener(documentListener);
		
		// Distinct identification of buttons
		menuItemOpen.setActionCommand("BUTTON_OPEN");
		menuItemSave.setActionCommand("BUTTON_SAVE");
		menuItemSaveAs.setActionCommand("BUTTON_SAVEAS");
		menuItemQuit.setActionCommand("BUTTON_QUIT");
		
		// Setting up ActionListener
		menuItemOpen.addActionListener(actionListener);
		menuItemSave.addActionListener(actionListener);
		menuItemSaveAs.addActionListener(actionListener);
		menuItemQuit.addActionListener(actionListener);
		
		menu.add(menuItemOpen);
		menu.add(menuItemSave);
		menu.add(menuItemSaveAs);
		menu.add(menuItemQuit);
		
		menubar.add(menu);
		frame.setJMenuBar(menubar);
		
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public static void quitMessage() {
		
		quitFrame = new JFrame("Quit");
		quitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel quitLabel = new JLabel("You have unsaved changes! Do you really want to quit?");
		
		quitFrame.getContentPane().setLayout(new FlowLayout());
		quitFrame.getContentPane().add(quitLabel);
		
		JButton buttonYes = new JButton("Yes!");
		JButton buttonNo = new JButton("No!");
		buttonYes.setActionCommand("BUTTON_YES");
		buttonNo.setActionCommand("BUTTON_NO");
		
		buttonYes.addActionListener(actionListener);
		buttonNo.addActionListener(actionListener);
		
		quitFrame.getContentPane().add(buttonYes);
		quitFrame.getContentPane().add(buttonNo);
		
		quitFrame.pack();
		quitFrame.setVisible(true);
		
	}
	
	public static void closeQuitWindow() {
		quitFrame.setVisible(false);
		quitFrame.dispose();
	}
	
	public static JTextArea getTextField() {
		return textField;
	}

}
