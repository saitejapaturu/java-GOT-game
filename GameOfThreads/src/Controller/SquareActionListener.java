package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.MutableBoard;

public class SquareActionListener implements ActionListener
{
	private MutableBoard gameBoard;
	private int currentX;		// X coordinate of the currently selected square
	private int currentY;		// Y coordinate of the currently selected square

	private TurnController turnController;
	private EndOfTurnActionListenerDecorator endOfTurnActionListenerDecorator;

	public SquareActionListener(MutableBoard gameBoard, int currentX, int currentY, TurnController turnController,
								EndOfTurnActionListenerDecorator endOfTurnActionListenerDecorator)
	{
		this.gameBoard = gameBoard;
		this.currentX = currentX;
		this.currentY = currentY;
		this.turnController = turnController;
		this.endOfTurnActionListenerDecorator = endOfTurnActionListenerDecorator;
	}

	//When a square is clicked, if it's the second click, if all conditions apply either moves the piece
	// or attacks enemy piece based on the square selected
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		//basic outlook on how interpreter and design patterns are implemented
		String info = currentX + "-" + currentY + "-" + turnController.getFirstX() + "-" + turnController.getFirstY()
				+ "-" + turnController.getclick();
		SquareContext context = new SquareContext(info);
		SelectExpression select = new SelectExpression(turnController, gameBoard); 
		Command command = select.interperet(context);

		if(command != null)
		{
			command.execute(gameBoard);
			if(command.getClass() == AttackCommand.class || command.getClass() == MoveCommand.class)
			{
				endOfTurnActionListenerDecorator.endTurn();
			}
		}
		
		else
		{
			turnController.setClick(0);
		}
		//if it is the first click.
	}
}

