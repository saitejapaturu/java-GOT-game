package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Board;
import View.MainFrame;

public class UndoListener implements ActionListener
{

	private BoardHistory history;
	private MainFrame mainframe;


	public UndoListener(BoardHistory history, MainFrame mainFrame)
	{
		this.history = history;
		this.mainframe = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		Board undoBoard = history.undo();

		if(undoBoard != null)
		{
			mainframe.undoRedo(undoBoard);
		}
		else
		{
			System.err.println("Undo can't be performed.");
		}
	}


}
