package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Board;

public class BoardHistory
{

	private List <Board> history = new ArrayList<Board>();
	private int currentTurn;		// Stores Which move we are currently at.
	private int turnCounter;

	public BoardHistory(Board board)
	{
		this.currentTurn = 0;
		history.add(currentTurn, board);
		turnCounter = 0;
		
	}

	// If undo is possible, returns the last turn.
	public Board undo()
	{
		if(currentTurn==0)
		{
			return null;
		}
		else
		{
			currentTurn--;
			return this.history.get(currentTurn);
		}
	}

	// If a redo is possible, returns the turn made before calling undo.
	public Board redo()
	{
		if(currentTurn==turnCounter)
		{
			return null;
		}
		else
		{
			currentTurn++;
			return this.history.get(currentTurn);
		}
	}

	// Adds the current board state to history
	public void moveMade(Board board)
	{
		// move Made after undo
		if(currentTurn<turnCounter)
		{
			moveMadeAfterUndo();
		}

		//Add current move
		currentTurn++;
		turnCounter++;
		this.history.add(currentTurn, board);

	}

	// If a move is made after undo, then the future moves that were made before using undo are removed.
	private void moveMadeAfterUndo()
	{
		while(turnCounter > currentTurn)
		{
			history.remove(turnCounter);
			turnCounter--;
		}
	}

//	public Board getBoardAtTurn(int turn)
//	{
//		return history.get(turn);
//	}
	
//	public void push(Board board)
//	{
//		history.add(board);
//	}
	
//	public void pop()
//	{
//		history.remove(history.size()-1);
//	}
}
