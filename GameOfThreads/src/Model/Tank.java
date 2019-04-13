package Model;

public class Tank extends Piece
{
	private static final int MAXMOVE = 2;
	private static final int RANGE = 2;
	private static final int DAMAGE = 2;
	private static final String ID = "Tank";
	private static final int SPECIALTURN = 3;

	public Tank(int player)
	{
		super(7, MAXMOVE, RANGE, DAMAGE, ID, player, SPECIALTURN);
	}

	public void special()
	{
		//tank piece goes fortifies itself for 3 turns, unable to move or take damage
	}
}
