package Controller;

import Model.MutableBoard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefendListener implements ActionListener
{

	private MutableBoard gameBoard;
	private EndOfTurnActionListenerDecorator endOfTurnActionListenerDecorator;

	public DefendListener(MutableBoard gameBoard, EndOfTurnActionListenerDecorator endOfTurnActionListenerDecorator)
	{
		this.gameBoard = gameBoard;
		this.endOfTurnActionListenerDecorator = endOfTurnActionListenerDecorator;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		this.gameBoard.defenceStance();
		endOfTurnActionListenerDecorator.endTurn();
	}

}
