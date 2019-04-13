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
	//	System.out.println("Square: " + x + ", " + y + "was clicked");
		if(turnController.getClick() == 0)
		{
			//if it is firstclick
			if(gameBoard.getSquarePiece(x,y) != null) {
		turnController.setSelX(x);
		turnController.setSelY(y);
		turnController.setClick(1);
			}
			else
			{
				turnController.setClick(0);
				return;
			}
		}
		else if (turnController.getClick()==1)
		{
		int pieceX = turnController.getSelX();
		int pieceY = turnController.getSelY();
		Piece test = gameBoard.getSquarePiece(turnController.getSelX(), turnController.getSelY());
		int player;
		if(gameBoard.getSquarePiece(turnController.getSelX(), turnController.getSelY()) != null)
		{
			player = gameBoard.getSquarePiece(turnController.getSelX(), turnController.getSelY()).getPLAYER();
			//checks piece belongs to player whose turn it is
			if(player == turnController.getTurn())
			{
				if(test.validateMove(gameBoard, pieceX, pieceY, x, y))
				{
					//moving piece
					gameEngine.movePiece(gameBoard, pieceX, pieceY, x, y);
					mainFrame.movePiece(pieceX, pieceY, x, y);
					turnController.setClick(0);
					System.out.println("Valid move");
					turnController.switchTurn();
					turnController.setClick(0);
					return;
				}
				else
				{
					System.out.println("Not a Valid Move");
					turnController.setClick(0);
					return;
				}
			}
			//if validatemove fails
			
			else
			{
				System.out.println("Not Your Turn");
				turnController.setClick(0);
				return;
			}
			
		}
		else if(turnController.getClick() == 1)
		{
			//functionality for if it is enemy piece and second click
			//gameEngine.pieceAttack(gameBoard.getSquarePiece(pieceX, pieceY),x , y);
		}
		else
		{
			turnController.setClick(0);
			return;
		}
		
		}
		mainFrame.revalidate();
		

	}

}
