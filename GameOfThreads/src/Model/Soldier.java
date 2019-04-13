package Model;

public class Soldier extends Piece
{
	private static final int MAXMOVE = 3;
	private static final int RANGE = 2;
	private static final int DAMAGE = 2;
	private static final String ID = "Soldier";

	public Soldier(int player)
	{
		super(4, MAXMOVE, RANGE, DAMAGE, ID, player);
	}

	public void Special()
	{
		//soldier is able to deal double damage for 1 turn
	}
}
