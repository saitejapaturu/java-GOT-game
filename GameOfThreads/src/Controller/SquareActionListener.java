package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Board;
import View.MainFrame;

public class SquareActionListener implements ActionListener {
	private Board gameBoard;
	private int currentX;
	private int currentY;



	private MainFrame mainFrame;
	private TurnController turnController;

	public SquareActionListener(Board gameBoard, int currentX, int currentY,
								MainFrame mainFrame, TurnController turnController) {
		this.gameBoard = gameBoard;
		this.currentX = currentX;
		this.currentY = currentY;
		this.mainFrame = mainFrame;
		//System.out.println("Listener for square " + x + ", " + y + " was created");
		this.turnController = turnController;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		System.out.println("l35 Square: " + currentX + ", " + currentY + "was clicked");

		//if it is the first click.
		if (turnController.getclick() == 0)
		{
			//checks piece belongs to player whose turn it is
			
			//Check if the square selected has a piece to perform action.
			if (gameBoard.getSquarePiece(currentX, currentY) != null)
			{
				validFirstClick(currentX,currentY);
				if(gameBoard.getSquarePiece(currentX,currentY).getPLAYER() != turnController.getPlayerTurn())
				{
				System.err.println("This piece belongs to enemy!");
					reset();
					return; //end action method
				}
			}

			//If the square selected has no piece.
			else
			{
				//debug
				System.out.println("l47 Selected a square with no piece");
				reset();
				return; // end method.
			}
		}

		//If the piece is already selected and a new is square selected
		else if (turnController.getclick() == 1)
		{
//			int pieceX = turnControllerBackUp.getSelX();
//			int pieceY = turnControllerBackUp.getSelY();

//			Piece test = gameBoard.getSquarePiece(turnControllerBackUp.getSelX(), turnControllerBackUp.getSelY());

			//Make sure the first square selected has a piece.
			 if (gameBoard.getSquarePiece(turnController.getFirstX(), turnController.getFirstY()) != null)
			{
				//if the second square selected is empty, the piece moves.
				if (gameBoard.getSquarePiece(currentX,currentY) == null)
				{
					//if move is valid
					if (gameBoard.movePiece(turnController.getFirstX(), turnController.getFirstY(), currentX, currentY))
					{
						//moving piece
						//gameEngine.movePiece(gameBoard, firstX, firstY, x, y);
						mainFrame.movePiece(turnController.getFirstX(), turnController.getFirstY(), currentX, currentY);
						System.out.println("Valid move");

						endOfTurn();
						return;
					}
					//If move isn't valid, doesn't end turn, just reset's click
					else
					{
						System.out.println("Not a Valid Move");

						reset();

						return;
					}
				}

				//if the square the piece wants to move to has an piece
				else if (gameBoard.getSquarePiece(currentX,currentY) != null)
				{
					//Check if the piece is oon our team, if so method ends.
					if(gameBoard.getSquarePiece(currentX,currentY).getPLAYER() == gameBoard.getSquarePiece(turnController.getFirstX(), turnController.getFirstY()).getPLAYER())
					{
						System.err.println("Cannot move onto already occupied square!");
					}

					else
					{
						//If attack is valid
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

							reset();
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
		reset();
		mainFrame.revalidate();
		mainFrame.updateComponents();
	}

	//If game ends
	private void gameOver()
	{

	}

	//resets values for false clicks
	private void reset()
	{
		turnController.setFirstX(0);
		turnController.setFirstY(0);
		turnController.setClick(0);
	}

	private void validFirstClick(int firstX, int firstY)
	{
		turnController.setFirstX(firstX);
		turnController.setFirstY(firstY);
		turnController.setClick(1);
	}

}
