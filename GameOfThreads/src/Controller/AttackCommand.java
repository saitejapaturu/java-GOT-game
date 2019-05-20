package Controller;

import Model.Board;

public class AttackCommand implements Command{
	private Board board;
	private TurnController tc;
	private int currentX;
	private int currentY;

	public AttackCommand(Board board, TurnController tc)
	{
		this.board = board;
		this.tc = tc;
		this.currentX = currentX;
		this.currentY = currentY;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
