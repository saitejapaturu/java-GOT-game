package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Board;
import Model.GameEngine;
import Model.Piece;
import View.MainFrame;

public class SquareActionListener implements ActionListener
{
	private Board gameBoard;
	private int x;
	private int y;
	private GameEngine gameEngine;
	private MainFrame mainFrame;
	private TurnControllerBackUp turnControllerBackUp;

	public SquareActionListener(Board gameBoard, int x, int y, GameEngine gameEngine, 
			MainFrame mainFrame, TurnControllerBackUp turnControllerBackUp)
	{
		this.gameBoard = gameBoard;
		this.x=x;
		this.y=y;
		this.gameEngine = gameEngine;
		this.mainFrame = mainFrame;
		//System.out.println("Listener for square " + x + ", " + y + " was created");
		this.turnControllerBackUp = turnControllerBackUp;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		System.out.println("l35 Square: " + x + ", " + y + "was clicked");
		if(turnControllerBackUp.getClick() == 0)
		{
			//if it is firstclick
			if(gameBoard.getSquarePiece(x,y) != null)
			{
				turnControllerBackUp.setSelX(x);
				turnControllerBackUp.setSelY(y);
				turnControllerBackUp.setClick(1);  //switch click
			}
			else
			{
				System.out.println("l47 Selected a square with no piece");
				turnControllerBackUp.setClick(0);
				return;
			}
		}

		else if (turnControllerBackUp.getClick()==1)
		{
			int pieceX = turnControllerBackUp.getSelX();
			int pieceY = turnControllerBackUp.getSelY();
			Piece test = gameBoard.getSquarePiece(turnControllerBackUp.getSelX(), turnControllerBackUp.getSelY());
			int player;
			if(gameBoard.getSquarePiece(turnControllerBackUp.getSelX(), turnControllerBackUp.getSelY()) != null)
		{
			player = gameBoard.getSquarePiece(turnControllerBackUp.getSelX(), turnControllerBackUp.getSelY()).getPLAYER();
			//checks piece belongs to player whose turn it is
			if(player == turnControllerBackUp.getTurn())
			{
				if(gameBoard.movePiece(pieceX, pieceY, x, y))
				{
					//moving piece
					//gameEngine.movePiece(gameBoard, pieceX, pieceY, x, y);
					mainFrame.movePiece(pieceX, pieceY, x, y);
					turnControllerBackUp.setClick(0);
					System.out.println("Valid move");
					turnControllerBackUp.switchTurn();
					turnControllerBackUp.setClick(0);
					mainFrame.updateComponents();
					mainFrame.revalidate();
					return;
				}
				else
				{
					System.out.println("Not a Valid Move");
					turnControllerBackUp.setClick(0);
					return;
				}
			}
			//if validatemove fails
			
			else
			{
				System.out.println("Not Your Turn");
				turnControllerBackUp.setClick(0);
				return;
			}
			
		}
		else if(turnControllerBackUp.getClick() == 1)
		{
			//functionality for if it is enemy piece and second click
			//gameEngine.pieceAttack(gameBoard.getSquarePiece(pieceX, pieceY),x , y);
		}
		else
		{
			turnControllerBackUp.setClick(0);
			return;
		}
		
		}
		mainFrame.revalidate();
		mainFrame.updateComponents();

	}

}
