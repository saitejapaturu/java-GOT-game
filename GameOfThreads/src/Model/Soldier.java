package Model;

public class Soldier extends Piece
{
	private static final int MAXMOVE = 3;
	private static final int RANGE = 2;
	private static final int DAMAGE = 2;
	private static final String ID = "Soldier";
	private static final int SPECIALTURN = 2;

	public Soldier(int player)
	{
		super(4, MAXMOVE, RANGE, DAMAGE, ID, player, SPECIALTURN);
	}

	public void special()
	{
		//soldier is able to deal double damage for 2nd turn
	}
}
