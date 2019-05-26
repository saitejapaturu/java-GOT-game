package Controller;

import Model.MutableBoard;

public class MoveCommand implements Command {
	private MutableBoard gameBoard;
	private TurnController tc;
	int currentX;
	int currentY;

	public MoveCommand(MutableBoard board, TurnController tc, int currentX, int currentY)
	{
		this.gameBoard = board;
		this.tc = tc;
		this.currentX = currentX;
		this.currentY = currentY;
	}
	
	public void execute() {
		if(gameBoard.movePiece(tc.getFirstX(), tc.getFirstY(),currentX,currentY))
		{
			//turnController.endTurn();
		}
		else
			//if not a valid move
		{
			System.out.println("Not a Valid Attack");

			tc.reset();
			return;
		}

	}

}
