package Model;

public class Tank extends Piece{
	public static final int MAXMOVE = 2;
	public static final int HEALTH = 5;
	public static final int RANGE = 2;
	public static final int DAMAGE = 1;

	public Tank(int health, int maxMove, int range, int damage, String id, int x, int y) {
		super(HEALTH, MAXMOVE, RANGE, DAMAGE, id, x, y);
	}

	@Override
	public void move(int newX, int newY) {
		this.setX(newX);
		this.setY(newY);
	}

	public void Special()
	{
		//tank piece goes fortifies itself for 3 turns, unable to move or take damage
	}

	@Override
	public void attack(int targetX, int targetY) {
		// TODO Auto-generated method stub
		
	}
	
}
