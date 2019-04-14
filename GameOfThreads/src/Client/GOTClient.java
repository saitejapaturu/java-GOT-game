package Client;

import Model.Board;
import View.MainFrame;

import javax.swing.*;

import Controller.TurnController;

public class GOTClient {

	public static void main(String[] args) {

		
		//board.newBoard();
		
		TurnController turnController = new TurnController();
		Board board = new Board();


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
