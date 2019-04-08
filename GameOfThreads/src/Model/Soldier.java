package Model;

public class Soldier extends Piece{
	public static final int MAXMOVE = 3;
	public static final int HEALTH = 4;
	public static final int RANGE = 3;
	public static final int DAMAGE = 2;

	public Soldier( String id, int player) {
		super(HEALTH, MAXMOVE, RANGE, DAMAGE, id, player);
		// TODO Auto-generated constructor stub
	}


	public void Special()
	{
		//soldier is able to deal double damage for 1 turn
	}

}
