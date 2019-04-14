package Client;

import Model.GameEngine;
import View.MainFrame;

import javax.swing.*;

import Controller.TurnControllerBackUp;

public class GOTClient {

	public static void main(String[] args) {

		
		//board.newBoard();
		GameEngine gameEngine = new GameEngine();
		TurnControllerBackUp turnControllerBackUp = new TurnControllerBackUp();


		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				MainFrame mainFrame = new MainFrame("Game Of Threads", gameEngine.getBoard(), gameEngine, turnControllerBackUp);

				//mainFrame.Update("Welcome to the Game Of Threads", 0);
			}
		});
	}
}
