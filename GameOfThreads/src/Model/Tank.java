package Model;

public class Tank extends Piece{
	public static final int MAXMOVE = 2;
	public static final int HEALTH = 5;
	public static final int RANGE = 2;
	public static final int DAMAGE = 1;

	public Tank(String id, int player) {
		super(HEALTH, MAXMOVE, RANGE, DAMAGE, id, player);
	}


	public void Special()
	{
		//tank piece goes fortifies itself for 3 turns, unable to move or take damage
	}

	
	
}
