package Client;

import Model.Board;
import Model.GameEngine;
import View.MainFrame;

import javax.swing.*;

import Controller.TurnController;

public class GOTClient {

	public static void main(String[] args) {

		
		//board.newBoard();
		GameEngine gameEngine = new GameEngine();
		TurnController turnController = new TurnController();


		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				MainFrame mainFrame = new MainFrame("Game Of Threads", gameEngine.getBoard(), gameEngine, turnController);

				//mainFrame.Update("Welcome to the Game Of Threads", 0);
			}
		});
	}
}
