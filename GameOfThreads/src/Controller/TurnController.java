package Controller;
import Model.Square;
public class TurnController {
	//implement functionally for a turn controller
	private int turn;
	private Square selectedSquare;
	
	public int getTurn()
	{
		return this.turn;
	}
	
	public Square getSelectedSquare()
	{
		return selectedSquare;
	}
}
