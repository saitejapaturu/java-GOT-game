package Controller;

import Model.MutableBoard;

public class InvalidCommand implements Command
{
	@Override
	public void execute(MutableBoard board)
	{
		System.out.println("Invalid command");
	}
}
