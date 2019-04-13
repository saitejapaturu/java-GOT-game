package Model;

public class Assassin extends Piece
{
	private static final int MAXMOVE = 2;
	private static final int RANGE = 3;
	private static final int DAMAGE = 3;
	private static final String ID = "Assassin";
	private static final int SPECIALTURN = 2;
	
	public Assassin(int player)
	{
		super(5, MAXMOVE, RANGE, DAMAGE, ID, player, SPECIALTURN);
	}
	
	public void special()
	{
		//cancels any special abilities of enemy pieces for 2nd turn
	}
}
