package Model;

public abstract class Piece
{
    private int health;
    private int maxMove;
    private int range;
    private int damage;
    private String id;
    private int x;
    private int y;
    
    public Piece(int health, int maxMove, int range, int damage, String id, int x, int y)
    {
    	this.health = health;
        this.maxMove = maxMove;
        this.range = range;
        this.damage = damage;
        this.id = id;
        this.x = x;
        this.y = y;
    }
    
    public int getX()
    {
        return this.x;
    }
    
    public int getY()
    {
        return this.y;
    }
    
    public void setX(int x)
    {
        this.x = x;
    }
    
    public void setY(int y)
    {
        this.y = y;
    }

    public abstract void move(int newX, int newY);
    
    public abstract void attack(int targetX, int targetY);

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public void takeDamage(int dmg)
	{
		this.health -=dmg;
	}
	
	public int getDamage()
	{
		return this.damage;
	}
}
