package Controller;

import Model.Board;

public class AttackCommand implements Command{
	private Board gameBoard;
	private TurnController tc;
	private int currentX;
	private int currentY;

	public AttackCommand(Board board, TurnController tc, int currentX, int currentY)
	{
		this.gameBoard = board;
		this.tc = tc;
		this.currentX = currentX;
		this.currentY = currentY;
	}
	@Override
	public void execute() {

		if(gameBoard.attackPiece(tc.getFirstX(), tc.getFirstY(),currentX,currentY))
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
