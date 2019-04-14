package Model;

public class Assassin extends Piece
{

	private static final String ID = "Assassin";
	private static final int SPECIALTURN = 2;

	
	public Assassin(int player)
	{
		super(5, 3, 3, ID, player, SPECIALTURN);
	}
	
	public void special()
	{
		//Increases range by 1 every 2nd turn;
		//Idea for A-2 cancels any special abilities of enemy pieces for 2nd turn

		System.out.println("Special for Player - " + this.getPLAYER() + " Assassin activated. Range Increased for this turn");

		this.setRange(4);
		this.setSpecial(true);
	}

	//Returns to original range
	public void deactivateSpecial()
	{
		System.out.println("Special for Player - " + this.getPLAYER() + " Assassin de-activated. Range back to normal");

		this.setRange(3);
		this.setSpecial(false);
	}
}
