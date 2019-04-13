package Model;

public class Assassin extends Piece
{
	private static final int MAXMOVE = 2;
	private static final int RANGE = 3;
	private static final int DAMAGE = 3;
	private static final String ID = "Assassin";
	
	public Assassin(int player)
	{
		super(5, MAXMOVE, RANGE, DAMAGE, ID, player);
	}
	
	public void special()
	{
		//cancels any special abilities of enemy pieces for 2 turn
	}
}
