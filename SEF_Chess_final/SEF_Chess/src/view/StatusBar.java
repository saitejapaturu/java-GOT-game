package view;

import javax.swing.JLabel;

public class StatusBar extends JLabel {
	//status bar shows when rolling
		JLabel statusLabel;
		StatusBar()
		{
			setText("Start Game!");
			setVisible(true);
		}
		
		public void update(String text)
		{
			setText(text);
		}
}
