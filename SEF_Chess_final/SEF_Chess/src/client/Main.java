package client;



import javax.swing.SwingUtilities;

import model.Board;
import model.Engine;
import view.Frame;

public class Main {

	public static void main(String[] args) {
		
		Board board = new Board();
		board.newBoard();
		Engine gameEngine = new Engine(board);
		
		
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				Frame mainFrame = new Frame("Chess Game", board, gameEngine);
				
				mainFrame.Update("Welcome to 6x6 Chess!", 0);
			}
		});
	}
}