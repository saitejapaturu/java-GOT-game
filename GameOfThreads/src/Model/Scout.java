package Model;

public class Scout extends Piece{
	public static final int MAXMOVE = 4;
	public static final int HEALTH = 3;
	public static final int RANGE = 3;
	public static final int DAMAGE = 1;

	public Scout(String id, int player) {
		super(HEALTH, MAXMOVE, RANGE, DAMAGE, id, player);
	}

	
	
	
	public void Special()
	{
		//scout is able to move to any square on the map instantly
	}

}
