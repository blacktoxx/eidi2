package exercise02;

import exercise01.IO;

import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JFileChooser;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Control implements ActionListener, KeyListener, DocumentListener {

		private String standardPath;
		private static boolean documentChanged;
		
		
		public Control() {
			standardPath = "";
			documentChanged = false;
		}
	
		@Override
		public void actionPerformed(ActionEvent event) {
			switch (event.getActionCommand()) {
				case "BUTTON_OPEN":
					open();
					break;
				case "BUTTON_SAVE":
					save();
					break;
				case "BUTTON_SAVEAS":
					saveAs();
					break;
				case "BUTTON_QUIT":
					// checks if unsaved progress
					if (documentChanged) {
						Editor.quitMessage();
					} else {
						System.exit(0);
					}
					break;
				case "BUTTON_YES":
					System.exit(0);
					break;
				case "BUTTON_NO":
					Editor.closeQuitWindow();
					break;
				default:
					System.out.println("Hallo");
			}
		}
		
		public void open() {
			JFileChooser jfc = new JFileChooser();
			
			int returnValue = jfc.showOpenDialog(null);
			
			if(returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = jfc.getSelectedFile();
				//System.out.println(selectedFile.getAbsolutePath());
				IO reader = new IO();
				
				standardPath = selectedFile.getAbsolutePath();
				
				String text = reader.readFile(standardPath);
				Editor.getTextField().setText(text);
					
			}
		}
		
		public void save() {
			if (standardPath.equals("")) {
				saveAs();
				return;
			}
			
			String text = Editor.getTextField().getText();
			IO reader = new IO();
			reader.writeFile(standardPath, text);
			
			// Progress was saved
			documentChanged = false;
			
		}
			
		public void saveAs() {
			
			String text = Editor.getTextField().getText();
					
			JFileChooser jfc = new JFileChooser();
			
			int returnValue = jfc.showSaveDialog(null);
			
			if(returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = jfc.getSelectedFile();
				IO reader = new IO();
				
				standardPath = selectedFile.getAbsolutePath();
				reader.writeFile(standardPath, text);
						
			}
			
			// Progress was saved
			documentChanged = false;
			
		}
		
		// KeyListener
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.isControlDown()) {
				switch (e.getKeyCode()) {
					case KeyEvent.VK_O:
						open();
						break;
					case KeyEvent.VK_S:
						if(e.isShiftDown()) {
							saveAs();
						}else {
							save();
						}
						break;
					case KeyEvent.VK_Q:
						System.exit(0);
						break;
				}
			}
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			
		}
		
		@Override
		public void keyTyped(KeyEvent e) {
			
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			documentChanged = true;
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			documentChanged = true;
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			documentChanged = true;
		}
}
