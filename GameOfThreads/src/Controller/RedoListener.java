package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.MutableBoard;
import View.MainFrame;

public class RedoListener implements ActionListener{

	private MutableBoard board;
	private MainFrame mainFrame;

	public RedoListener(MutableBoard board, MainFrame mainFrame)
	{
		this.board = board;
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(board.redo())
		{
			this.mainFrame.undoRedo();
		}
		else
		{
			System.err.println("Redo can't be performed.");
		}
		
	}
}
