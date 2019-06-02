package Controller;

import Model.MutableBoard;
import View.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefendListener implements ActionListener
{

	private MutableBoard gameBoard;

	private MainFrame mainFrame;
	private TurnController turnController;

	public DefendListener(MutableBoard gameBoard, MainFrame mainFrame, TurnController turnController)
	{
		this.gameBoard = gameBoard;
		this.mainFrame = mainFrame;
		this.turnController = turnController;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		this.gameBoard.defenceStance();

		turnController.switchTurn();
		mainFrame.revalidate();
		//debug
		mainFrame.endOfTurn();

		specials();

	}

}
