package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Board;
import Model.GameEngine;
import View.MainFrame;

public class SquareActionListener implements ActionListener {
	Board gameBoard;
	int x;
	int y;
	GameEngine gameEngine;
	MainFrame mainFrame;

	public SquareActionListener(Board gameBoard, int x, int y, GameEngine gameEngine, MainFrame mainFrame) {
		this.gameBoard = gameBoard;
		this.x=x;
		this.y=x;
		this.gameEngine = gameEngine;
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Square " + x + ", " + y + "was clicked");
		if(gameBoard.getSquarePiece(x, y) != null)
		{
			//checks piece belongs to player whose turn it is
			if(gameBoard.getSquarePiece(x, y).getPlayer() == gameEngine.getPlayerTurn())
			{
				//set selected square
			}
			//if it is not their piece/turn
			else
			{
				System.out.println("Not your turn");
			}
		}
		else if(gameBoard.getSquarePiece)
		{
			//functionality for if it is enemy piece and second click
		}
		

	}

}
