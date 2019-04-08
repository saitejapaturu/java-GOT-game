
package Model;

public class Assassin extends Piece {
	
	public static final int MAXMOVE = 2;
	public static final int HEALTH = 5;
	public static final int RANGE = 2;
	public static final int DAMAGE = 1;
	
	public Assassin(String id,int player) {
		super(HEALTH, MAXMOVE, RANGE, DAMAGE, id, player);
	}

	
	public void attack(int targetX, int targetY)
	{
		
	}
	
	public void special() {
		//cancels any special abilities of enemy pieces for 2 turn
	}

}
