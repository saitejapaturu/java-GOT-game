package Client;

import Model.Board;
import Model.ImmutableBoard;
import View.MainFrame;

import javax.swing.*;

import Controller.BoardHistory;
import Controller.TurnController;

public class GOTClient {

	public static void main(String[] args) {

		
		//board.newBoard();
		
		TurnController turnController = new TurnController();
		BoardHistory boardHistory = new BoardHistory();
		Board board = new ImmutableBoard(0);
		boardHistory.push(board);
		


		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				MainFrame mainFrame = new MainFrame("Game Of Threads", board, turnController);

			}
		});
	}
}
