package Controller;

import Model.MutableBoard;

public class MoveCommand implements Command
{
	private MutableBoard gameBoard;
	private int currentX;
	private int currentY;
	private int firstX;
	private int firstY;
	 
	public MoveCommand(int currentX, int currentY, int firstX, int firstY)
	{
		
		this.currentX = currentX;
		this.currentY = currentY;
		this.firstX = firstX;
		this.firstY = firstY;

	}
	
	public void execute(MutableBoard board)
	{
		this.gameBoard = board;
		gameBoard.movePiece(firstX, firstY,currentX,currentY);
	}
}
