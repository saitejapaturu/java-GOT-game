package Controller;

import Model.Board;

public class MoveCommand implements Command {
	private Board board;
	private TurnController tc;
	int currentx;
	int currenty;

	public MoveCommand(Board board, TurnController tc)
	{
		this.board = board;
		this.tc = tc;
	}
	
	public void execute() {
		

	}

}
