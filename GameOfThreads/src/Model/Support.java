package Model;

public class Support extends Piece
{
	private static final int MAXMOVE = 2;
	private static final int RANGE = 2;
	private static final int DAMAGE = 1;
	private static final String ID = "Support";

	public Support(int player)
	{
		super(4, MAXMOVE, RANGE, DAMAGE, ID, player);
	}

	public void special()
	{
		//Heals itself and other in team pieces by adding 20% of total hp every 2nd turn
	}
}
