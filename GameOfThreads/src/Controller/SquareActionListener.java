package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Board;
import Model.GameEngine;
import View.MainFrame;

public class SquareActionListener implements ActionListener {
	Board gameBoard;
	int j;
	int i;
	GameEngine gameEngine;
	MainFrame mainFrame;

	public SquareActionListener(Board gameBoard, int j, int i, GameEngine gameEngine, MainFrame mainFrame) {
		this.gameBoard = gameBoard;
		this.i=i;
		this.j=j;
		this.gameEngine = gameEngine;
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Square " + i + ", " + j + "was clicked");

	}

}
