package Controller;

import Model.MutableBoard;

// When a player decides to attack an enemy piece this command gets executed.
public class AttackCommand implements Command
{
	private MutableBoard gameBoard;
	private int currentX;
	private int currentY;
	private int firstX;
	private int firstY;
	 
	public AttackCommand(int currentX, int currentY, int firstX, int firstY)
	{
		
		this.currentX = currentX;
		this.currentY = currentY;
		this.firstX = firstX;
		this.firstY = firstY;

	}
	@Override
	public void execute(MutableBoard board)
	{
		this.gameBoard = board;
		// this functionality will be moved to expressions, only needs to call gameBoard.attackpiece
		gameBoard.attackPiece(firstX, firstY,currentX,currentY);
	}
}
