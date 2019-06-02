package Controller;

import Model.MutableBoard;

public interface Command {

	public void execute(MutableBoard board);
	
}
