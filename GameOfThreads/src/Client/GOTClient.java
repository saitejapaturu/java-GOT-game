package Client;

import Model.Board;
import Model.GameEngine;
import View.MainFrame;

import javax.swing.*;

public class GOTClient {

	public static void main(String[] args) {

		Board board = new Board();
		//board.newBoard();
		GameEngine gameEngine = new GameEngine();


		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				MainFrame mainFrame = new MainFrame("Game Of Threads", board, gameEngine);

				//mainFrame.Update("Welcome to the Game Of Threads", 0);
			}
		});
	}
}
