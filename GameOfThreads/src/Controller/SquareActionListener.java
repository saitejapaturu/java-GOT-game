package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Board;
import Model.GameEngine;
import Model.Piece;
import View.MainFrame;

public class SquareActionListener implements ActionListener {
	Board gameBoard;
	private int x;
	private int y;
	GameEngine gameEngine;
	MainFrame mainFrame;
	TurnController turnController;

	public SquareActionListener(Board gameBoard, int x, int y, GameEngine gameEngine, 
			MainFrame mainFrame, TurnController turnController) {
		this.gameBoard = gameBoard;
		this.x=x;
		this.y=y;
		this.gameEngine = gameEngine;
		this.mainFrame = mainFrame;
		//System.out.println("Listener for square " + x + ", " + y + " was created");
		this.turnController = turnController;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Square: " + x + ", " + y + "was clicked");
		if(turnController.getClick() == 0)
		{
			//if it is firstclick
		turnController.setSelX(x);
		turnController.setSelY(y);
		turnController.setClick(1);
		}
		else if (turnController.getClick()==1){
		int pieceX = turnController.getSelX();
		int pieceY = turnController.getSelY();
		int player = turnController.getTurn();
		Piece test = gameBoard.getSquarePiece(x, y);
		if(gameBoard.getSquarePiece(turnController.getSelX(), turnController.getSelY()) != null)
		{
			//checks piece belongs to player whose turn it is
			if(gameEngine.validMove(gameBoard, pieceX, pieceY, x, y, player))
			{
				//moving piece
				gameEngine.movePiece(gameBoard, pieceX, pieceY, x, y);
				mainFrame.movePiece(pieceX, pieceY, x, y);
				turnController.setClick(0);
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
			gameEngine.pieceAttack(gameBoard.getSquarePiece(pieceX, pieceY),x , y);
		}
		
		}
		mainFrame.revalidate();


	}

}
