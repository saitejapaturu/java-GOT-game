package Controller;

import Model.MutableBoard;

public class AttackCommand implements Command{
	private MutableBoard gameBoard;
	private TurnController tc;
	private int currentX;
	private int currentY;

	public AttackCommand(MutableBoard board, TurnController tc, int currentX, int currentY)
	{
		this.gameBoard = board;
		this.tc = tc;
		this.currentX = currentX;
		this.currentY = currentY;
	}
	@Override
	public void execute() {

		// this functionality will be moved to expressions, only needs to call gameBoard.attackpiece
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
