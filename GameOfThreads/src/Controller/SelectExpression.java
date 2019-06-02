package Controller;

import Model.MutableBoard;

public class SelectExpression extends Expression
{
	//non terminal expression
	private TurnController tc;
	private MutableBoard gameBoard;
	
	public SelectExpression(TurnController tc, MutableBoard gameBoard)
	{
		this.tc = tc;
		this.gameBoard = gameBoard;
	}

	@Override
	public MoveCommand interperet(SquareContext context) {
		// in here decide which new expression to create and pass to either attackExpression or Move Expression
		int currentX = context.getCurrentX();
		int currentY = context.getCurrentY();
		int firstX = context.getFirstX();
		int firstY = context.getFirstY();
		int click = context.getClick();
		//if it is the first click.
				if (tc.getclick() == 0)
				{
					//checks piece belongs to player whose turn it is
					
					//Check if the square selected has a piece to perform action.
					if (gameBoard.getSquare(currentX, currentY).getPiece() != null)
					{
						tc.validFirstClick(currentX,currentY);
						if(gameBoard.getSquare(currentX,currentY).getPiece().getPLAYER() != tc.getPlayerTurn())
						{
						System.err.println("This piece belongs to enemy!");
							tc.reset();
							return; //end action method
						}
					}

					//If the square selected has no piece.
					else
					{
						
						tc.reset();
						return; // end method.
					}
				}

				//If the piece is already selected and a new is square selected
				else if (tc.getclick() == 1)
				{
					//Make sure the first square selected has a piece.
					 if (gameBoard.getSquare(tc.getFirstX(), tc.getFirstY()).getPiece() != null)
					{
						//if the second square selected is empty, the piece moves.
						if (gameBoard.getSquare(currentX,currentY).getPiece() == null)
						{
							//if move is valid
							if (gameBoard.movePiece(tc.getFirstX(), tc.getFirstY(), currentX, currentY))
							{
								//moving piece
								//gameEngine.movePiece(gameBoard, firstX, firstY, x, y);
								//here we make a new attackCommand
								mainFrame.movePiece(tc.getFirstX(), tc.getFirstY(), currentX, currentY);
								System.out.println("Valid move");

								endOfTurn();
								return;
							}
							//If move isn't valid, doesn't end turn, just reset's click
							else
							{
								System.out.println("Not a Valid Move");

								tc.reset();

								return;
							}
						}

						//if the square the piece wants to move to has an piece
						else if (gameBoard.getSquare(currentX,currentY).getPiece() != null)
						{
							//Check if the piece is oon our team, if so method ends.
							if(gameBoard.getSquare(currentX,currentY).getPiece().getPLAYER() == gameBoard.getSquare(tc.getFirstX(), tc.getFirstY()).getPiece().getPLAYER())
							{
								System.err.println("Cannot move onto already occupied square!");
							}

							else
							{
								//If attack is valid
								//here we make a new attack command
								if(gameBoard.attackPiece(tc.getFirstX(), tc.getFirstY(),currentX,currentY))
								{
									System.out.println("Valid Attack");

									endOfTurn();
									return;
								}
								//If move isn't valid, doesn't end turn, just reset's click
								else
								{
									System.out.println("Not a Valid Attack");

									tc.reset();
									return;
								}
							}
						}
					}
				}
		
		
		return null;
	}

}
