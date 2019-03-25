package Model;

public class Scout extends Piece{
	public static final int MAXMOVE = 4;
	public static final int HEALTH = 3;
	public static final int RANGE = 3;
	public static final int DAMAGE = 1;

	public Scout(int health, int maxMove, int range, int damage, String id, int x, int y) {
		super(HEALTH, MAXMOVE, RANGE, DAMAGE, id, x, y);
	}

	@Override
	public void move(int newX, int newY) {
		this.setX(newX);
		this.setY(newY);
	}

	@Override
	public void attack(int targetX, int targetY) {
		
	}
	
	public void Special()
	{
		//scout is able to move to any square on the map instantly
	}

}
