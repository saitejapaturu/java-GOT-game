package Controller;
import Model.Square;
public class TurnController {
	//implement functionally for a turn controller
	private int turn;
	private Square selectedSquare;
	//0 for first click i.e. selecting players own piece
	//1 for selecting square piece will be moving to
	private int click = 0;
	
	public TurnController()
	{
		
	}
	
	public int getTurn()
	{
		return this.turn;
	}
	
	public Square getSelectedSquare()
	{
		return selectedSquare;
	}
	
	public int getClick()
	{
		return this.click;
	}
	
}
