package Model;

public class Mage extends Piece
{
	private static final int MAXMOVE = 3;
	private static final int RANGE = 4;
	private static final int DAMAGE = 2;
	private static final String ID = "Mage";

	public Mage (int player)
	{
		super(5, MAXMOVE, RANGE, DAMAGE, ID, player);
	}
	
	public void special()
	{
		//immune any damage done by enemy for one turn every 3nd turn
	}
}
