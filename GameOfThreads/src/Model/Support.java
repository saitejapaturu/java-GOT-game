package Model;

public class Support extends Piece {
	
	public static final int MAXMOVE = 2;
	public static final int HEALTH = 5;
	public static final int RANGE = 2;
	public static final int DAMAGE = 1;
	
	public Support(String id, int x, int y) {
		super(HEALTH, MAXMOVE, RANGE, DAMAGE, id, x, y);
	}

	@Override
	public void move(int newX, int newY) {
		this.setX(newX);
		this.setY(newY);
		
	}
	
	public void attack(int targetX, int targetY) {
		
	}
	
	public void special() {
		//Heals itself and other in team pieces by adding 20% of total hp every 2nd turn
	}

}
