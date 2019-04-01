package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Engine;
import view.Frame;

public class NewGameListener implements ActionListener{
	private Engine gameEngine;
	private Frame frame;
	public NewGameListener(Engine engine, Frame frame)
	{
		super();
		this.gameEngine = engine;
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		frame.setupNewGame();
		gameEngine.newGame();
		frame.Update(gameEngine.getCurrentPlayer().getName() + " it's tour turn!", gameEngine.getMoves());
	}

}
