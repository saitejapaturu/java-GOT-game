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
	public Command interperet(SquareContext context) {
		// in here decide which new expression to create and pass to either attackExpression or Move Expression
		int currentX = context.getCurrentX();
		int currentY = context.getCurrentY();
		int firstX = context.getFirstX();
		int firstY = context.getFirstY();
		int click = context.getClick();
		//if it is the first click.
				if (click == 0)
				{
					//checks piece belongs to player whose turn it is
					
					//Check if the square selected has a piece to perform action.
					if (gameBoard.getSquare(currentX, currentY).getPiece() != null)
					{
						
						if(gameBoard.getSquare(currentX,currentY).getPiece().getPLAYER() != tc.getPlayerTurn())
						{
						System.err.println("This piece belongs to enemy!");
							tc.reset();
							InvalidExpression invalid = new InvalidExpression();
							return invalid.interperet(context);
						}
						else 
						{
							tc.validFirstClick(currentX,currentY);
							SelectCommand select = new SelectCommand();
							return select;
						}
					}

					//If the square selected has no piece.
					else
					{
						tc.reset();
						InvalidExpression invalid = new InvalidExpression();
						return invalid.interperet(context);
					}
				}

				//If the piece is already selected and a new is square selected
				else if (click == 1)
				{
					//Make sure the first square selected has a piece.
					 if (gameBoard.getSquare(firstX, firstY).getPiece() != null)
					{
						//if the second square selected is empty, the piece moves.
						if (gameBoard.getSquare(currentX,currentY).getPiece() == null)
						{
							//if move is valid
							MoveExpression move = new MoveExpression();
							return move.interperet(context);
						}
						//if the square the piece wants to move to has an piece
						else if (gameBoard.getSquare(currentX,currentY).getPiece() != null)
								{
									//Check if the piece is oon our team, if so method ends.
									if(gameBoard.getSquare(currentX,currentY).getPiece().getPLAYER() == gameBoard.getSquare(firstX, firstY).getPiece().getPLAYER())
									{
										System.err.println("Cannot move onto already occupied square!");
										
										InvalidExpression invalid = new InvalidExpression();
										
										return invalid.interperet(context);
									}

									else
									{
										//If attack is valid
										//here we make a new attack command	
										
											System.out.println("Valid Attack");

											AttackExpression attack = new AttackExpression();
											return attack.interperet(context);
										
										//If move isn't valid, doesn't end turn, just reset's click
										
									}
								}
					}
				
					}
				
		
		
		return null;
	}

}
