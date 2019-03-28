package model;

public class Mage extends Piece {

	public static final int MAXMOVE = 2;
	public static final int HEALTH = 5;
	public static final int RANGE = 2;
	public static final int DAMAGE = 1;
	
	public Mage(String id, int x, int y) {
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
		//immune any damage done by enemy for one turn every 3nd turn
	}
	

	

}
