package Controller;
import Model.Board;
import Model.Square;
public class TurnController {
	//implement functionally for a turn controller
	private int turn;
	private Square selectedSquare;
	private int selX,selY;
	//0 for first click i.e. selecting players own piece
	//1 for selecting square piece will be moving to
	private int click = 0;
	
	public TurnController()
	{
		this.turn = 0;
		this.selX = 0;
		this.selY = 0;
		this.click = 0;
	}
	
	public int getTurn()
	{
		return this.turn;
	}
	
	public int getSelX()
	{
		
		return selX;
	}
	
	public int getSelY()
	{
			return this.selY;
	}
	
	public void setSelX(int x)
	{
		this.selX = x;
	}
	
	public void setSelY(int y)
	{
		this.selY = y;
	}
	
	public int getClick()
	{
		return this.click;
	}
	
	public void setClick(int click)
	{
	this.click = click;	
	}
	
	public void switchTurn()
	{
		if (this.turn == 0)
		{
			this.turn = 1;
		}
		else
		{
			this.turn = 0;
		}
	}
}
