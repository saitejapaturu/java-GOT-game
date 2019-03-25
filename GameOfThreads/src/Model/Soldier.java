package Model;

public class Soldier extends Piece{
	public static final int MAXMOVE = 3;
	public static final int HEALTH = 4;
	public static final int RANGE = 3;
	public static final int DAMAGE = 2;

	public Soldier(int health, int maxMove, int range, int damage, String id, int x, int y) {
		super(HEALTH, MAXMOVE, RANGE, DAMAGE, id, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(int newX, int newY) {
		this.setX(newX);
		this.setY(newY);
	}

	@Override
	public void attack(int targetX, int targetY) {
		// TODO Auto-generated method stub
		
	}
	
	public void Special()
	{
		//soldier is able to deal double damage for 1 turn
	}

}
