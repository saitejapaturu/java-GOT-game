package Controller;

import Model.MutableBoard;

// Interface to execute commands
public interface Command
{
	void execute(MutableBoard board);
}
