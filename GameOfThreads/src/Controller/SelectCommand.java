package Controller;

import Model.MutableBoard;

public class SelectCommand implements Command
{
	@Override
	public void execute(MutableBoard board)
	{
		System.out.println("Select Command");
	}
}
