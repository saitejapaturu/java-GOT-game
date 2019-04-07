package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Board;
import Model.GameEngine;
import View.MainFrame;

public class SquareActionListener implements ActionListener {
	Board gameBoard;
	private int x;
	private int y;
	GameEngine gameEngine;
	MainFrame mainFrame;
	TurnController turnController;

	public SquareActionListener(Board gameBoard, int x, int y, GameEngine gameEngine, MainFrame mainFrame) {
		this.gameBoard = gameBoard;
		this.x=x;
		this.y=y;
		this.gameEngine = gameEngine;
		this.mainFrame = mainFrame;
		System.out.println("Listener for square " + x + ", " + y + " was created");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Square: " + x + ", " + y + "was clicked");
		int pieceX = turnController.getSelectedSquare().getX();
		int pieceY = turnController.getSelectedSquare().getX();
		int player = turnController.getTurn();

		if(gameBoard.getSquarePiece(x, y) != null)
		{
			//checks piece belongs to player whose turn it is
			if(gameEngine.validMove(gameBoard, pieceX, pieceY, x, y, player))
			{
				gameEngine.movePiece(gameBoard, pieceX, pieceY, x, y);
				mainFrame.movePiece(pieceX, pieceY, x, y);
			}
			//if it is not their piece/turn
			else
			{
				System.out.println("Not your turn");
			}
		}
		else if(turnController.getClick() == 1)
		{
			//functionality for if it is enemy piece and second click
		}
		
		mainFrame.revalidate();
		

	}

}
