package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.MutableBoard;
import View.MainFrame;

public class UndoListener implements ActionListener
{

	private MutableBoard board;
	private MainFrame mainFrame;


	public UndoListener(MutableBoard board, MainFrame mainFrame)
	{
		this.board = board;
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(board.undo())
		{
			this.mainFrame.undoRedo();
		}
		else
		{
			System.err.println("Undo can't be performed.");
		}
	}


}
