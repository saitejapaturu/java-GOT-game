package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Board;
import Model.GameEngine;
import Model.Piece;
import View.MainFrame;

public class SquareActionListener implements ActionListener {
	private Board gameBoard;
	private int currentX;
	private int currentY;

	private int firstX;
	private int firstY;

	private int click; //Is used to check if it's the first square to be selected or the second.

	private GameEngine gameEngine;
	private MainFrame mainFrame;
	private TurnController turnController;

	public SquareActionListener(Board gameBoard, int currentX, int currentY, GameEngine gameEngine,
								MainFrame mainFrame, TurnController turnController) {
		this.gameBoard = gameBoard;
		this.currentX = currentX;
		this.currentY = currentY;
		this.gameEngine = gameEngine;
		this.mainFrame = mainFrame;
		//System.out.println("Listener for square " + x + ", " + y + " was created");
		this.turnController = turnController;
		this.click = 0;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		System.out.println("l35 Square: " + currentX + ", " + currentY + "was clicked");

		//if it is the first click.
		if (click == 0)
		{
			//Check if the square selected has a piece to perform action.
			if (gameBoard.getSquarePiece(currentX, currentY) != null)
			{
				firstX = currentX;
				firstY = currentY;

				click = 1;
			}

			//If the square selected has no piece.
			else
			{
				//debug
				System.out.println("l47 Selected a square with no piece");
				resetClick();
				return; // end method.
			}
		}

		//If the piece is already selected and a new is square selected
		else if (click == 1)
		{
//			int pieceX = turnControllerBackUp.getSelX();
//			int pieceY = turnControllerBackUp.getSelY();

//			Piece test = gameBoard.getSquarePiece(turnControllerBackUp.getSelX(), turnControllerBackUp.getSelY());

			//checks piece belongs to player whose turn it is
			if(gameBoard.getSquarePiece(firstX,firstY).getPLAYER() != turnController.getPlayerTurn())
			{
				System.err.println("This piece belongs to enemy!");
				return; //end action method
			}

			//Make sure the first square selected has a piece.
			else if (gameBoard.getSquarePiece(firstX, firstY) != null)
			{
				//if the second square selected is empty, the piece moves.
				if (gameBoard.getSquarePiece(currentX,currentY) == null)
				{
					//if move is valid
					if (gameBoard.movePiece(firstX, firstY, currentX, currentY))
					{
						//moving piece
						//gameEngine.movePiece(gameBoard, firstX, firstY, x, y);
						mainFrame.movePiece(firstX, firstY, currentX, currentY);
						System.out.println("Valid move");

						endOfTurn();
						return;
					}
					//If move isn't valid, doesn't end turn, just reset's click
					else
					{
						System.out.println("Not a Valid Move");

						resetClick();

						return;
					}
				}

				//if the square the piece wants to move to has an piece
				else if (gameBoard.getSquarePiece(currentX,currentY) != null)
				{
					//Check if the piece is oon our team, if so method ends.
					if(gameBoard.getSquarePiece(currentX,currentY).getPLAYER() == gameBoard.getSquarePiece(firstX,firstY).getPLAYER())
					{
						System.err.println("Cannot move onto already occupied square!");
					}

					else
					{
						//If attack is valid
						if(gameBoard.attackPiece(firstX,firstY,currentX,currentY))
						{
							System.out.println("Valid Attack");

							endOfTurn();
							return;
						}
						//If move isn't valid, doesn't end turn, just reset's click
						else
						{
							System.out.println("Not a Valid Attack");

							resetClick();
							return;
						}
					}
				}
			}
		}
	}

	private void endOfTurn()
	{
		if(gameBoard.checkWinConditions() != 0)
		{
			gameOver();
		}

		turnController.switchTurn();
		resetClick();
		mainFrame.revalidate();
		mainFrame.updateComponents();
	}

	//If game ends
	private void gameOver()
	{

	}

	private void resetClick()
	{
		click = 0;
	}

}
