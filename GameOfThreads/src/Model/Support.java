package Model;

public class Support extends Piece {
	
	public static final int MAXMOVE = 2;
	public static final int HEALTH = 5;
	public static final int RANGE = 2;
	public static final int DAMAGE = 1;
	
	public Support(String id, int player) {
		super(HEALTH, MAXMOVE, RANGE, DAMAGE, id, player);
	}

	
	
	public void special() {
		//Heals itself and other in team pieces by adding 20% of total hp every 2nd turn
	}

}
