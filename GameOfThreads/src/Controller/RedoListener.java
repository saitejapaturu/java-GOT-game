package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.MutableBoard;
import View.MainFrame;

public class RedoListener implements ActionListener{

	private BoardHistory history;
	private MutableBoard board;
	private MainFrame mainFrame;

	public RedoListener(MutableBoard board, MainFrame mainFrame)
	{
		this.mainFrame = mainFrame;
		this.board = board;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//board = history.redo();
		
	}
}
