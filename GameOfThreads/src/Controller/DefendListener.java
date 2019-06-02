package Controller;

import Model.MutableBoard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefendListener implements ActionListener
{

	private MutableBoard gameBoard;
	private TurnController turnController;
	private EndOfTurnActionListenerDecorator endOfTurnActionListenerDecorator;

	public DefendListener(MutableBoard gameBoard, TurnController turnController,
						  	EndOfTurnActionListenerDecorator endOfTurnActionListenerDecorator)
	{
		this.gameBoard = gameBoard;
		this.turnController = turnController;
		this.endOfTurnActionListenerDecorator = endOfTurnActionListenerDecorator;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		this.gameBoard.defenceStance(turnController.getPlayerTurn());
		endOfTurnActionListenerDecorator.endTurn();
	}
}
