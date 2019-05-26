package Controller;

import java.util.List;

import Model.Board;

public class BoardHistory{

	List <Board> history;
	public BoardHistory()
	{
		
	}
	
	public Board getBoardAtTurn(int turn)
	{
		return history.get(turn);
	}
	
	public void push(Board board)
	{
		history.add(board);
	}
	
	public void pop()
	{
		history.remove(history.size()-1);
	}
}
