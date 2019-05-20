package Controller;

import Model.Board;

public class MoveCommand implements Command {
	private Board gameBoard;
	private TurnController tc;
	int currentX;
	int currentY;

	public MoveCommand(Board board, TurnController tc, int currentX, int currentY)
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

	}

}
