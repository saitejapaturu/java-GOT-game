package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.MutableBoard;
import View.MainFrame;

public class SquareActionListener implements ActionListener
{
	private MutableBoard gameBoard;
	private int currentX;		// X coordinate of the currently selected square
	private int currentY;		// Y coordinate of the currently selected square

	private MainFrame mainFrame;
	private TurnController turnController;

	public SquareActionListener(MutableBoard gameBoard, int currentX, int currentY,
								MainFrame mainFrame, TurnController turnController)
	{
		this.gameBoard = gameBoard;
		this.currentX = currentX;
		this.currentY = currentY;
		this.mainFrame = mainFrame;
		this.turnController = turnController;
	}

	//When a square is clicked, if it's the second click, if all conditions apply either moves the piece
	// or attacks enemy piece based on the square selected
	@Override
	public void actionPerformed(ActionEvent arg0)
	{

		//if it is the first click.
		if (turnController.getclick() == 0)
		{
			//checks piece belongs to player whose turn it is
			
			//Check if the square selected has a piece to perform action.
			if (gameBoard.getSquare(currentX, currentY).getPiece() != null)
			{
				turnController.validFirstClick(currentX,currentY);
				if(gameBoard.getSquare(currentX,currentY).getPiece().getPLAYER() != turnController.getPlayerTurn())
				{
				System.err.println("This piece belongs to enemy!");
					turnController.reset();
					return; //end action method
				}
			}

			//If the square selected has no piece.
			else
			{
				
				turnController.reset();
				return; // end method.
			}
		}

		//If the piece is already selected and a new is square selected
		else if (turnController.getclick() == 1)
		{
			//Make sure the first square selected has a piece.
			 if (gameBoard.getSquare(turnController.getFirstX(), turnController.getFirstY()).getPiece() != null)
			{
				//if the second square selected is empty, the piece moves.
				if (gameBoard.getSquare(currentX,currentY).getPiece() == null)
				{
					//if move is valid
					if (gameBoard.movePiece(turnController.getFirstX(), turnController.getFirstY(), currentX, currentY))
					{
						//moving piece
						//gameEngine.movePiece(gameBoard, firstX, firstY, x, y);
						//here we make a new attackCommand
						mainFrame.movePiece(turnController.getFirstX(), turnController.getFirstY(), currentX, currentY);
						System.out.println("Valid move");

						endOfTurn();
						return;
					}
					//If move isn't valid, doesn't end turn, just reset's click
					else
					{
						System.out.println("Not a Valid Move");

						turnController.reset();

						return;
					}
				}

				//if the square the piece wants to move to has an piece
				else if (gameBoard.getSquare(currentX,currentY).getPiece() != null)
				{
					//Check if the piece is oon our team, if so method ends.
					if(gameBoard.getSquare(currentX,currentY).getPiece().getPLAYER() == gameBoard.getSquare(turnController.getFirstX(), turnController.getFirstY()).getPiece().getPLAYER())
					{
						System.err.println("Cannot move onto already occupied square!");
					}

					else
					{
						//If attack is valid
						//here we make a new attack command
						if(gameBoard.attackPiece(turnController.getFirstX(), turnController.getFirstY(),currentX,currentY))
						{
							System.out.println("Valid Attack");

							endOfTurn();
							return;
						}
						//If move isn't valid, doesn't end turn, just reset's click
						else
						{
							System.out.println("Not a Valid Attack");

							turnController.reset();
							return;
						}
					}
				}
			}
		}
	}

	//This method gets called at the end of the turn.
	//move to turn controller based on patterns
	private void endOfTurn()
	{
		if(gameBoard.checkWinConditions() != 0)
		{
			gameOver();
		}

		turnController.switchTurn();
		turnController.reset();
		mainFrame.revalidate();
		//debug
		mainFrame.endOfTurn();

		specials();
	}

	//If game ends call this method
	private void gameOver()
	{

	}

	//Deactivates specials of all pieces and activates specials of appropriate pieces for next turn.
	private void specials()
	{
		gameBoard.deactivateSpecial();

		//If the turn is a multiple of 2, activate specials of the pieces whose special activates on every 3rd turn
		if(turnController.getTurn()%2 == 0)
		{
			gameBoard.activateSpecial(2);
		}

		//If the turn is a multiple of 3, activate specials of the pieces whose special activates on every 3rd turn
		else if(turnController.getTurn()%3 == 0)
		{
			gameBoard.activateSpecial(3);
		}
	}



}
