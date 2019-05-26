package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Board;

public class UndoListener implements ActionListener{

	private BoardHistory history;
	private Board board;
	public UndoListener(BoardHistory history, Board board)
	{
		this.history = history;
		this.board = board;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		board = history.undo();
		
	}
}
