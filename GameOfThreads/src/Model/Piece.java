package Model;

public abstract class Piece
{
    private int health;
    private int maxMove;
    private int range;
    private int damage;
    private String id;
    private int player;
    
    public Piece(int health, int maxMove, int range, int damage, String id, int player)
    {
    	this.health = health;
        this.maxMove = maxMove;
        this.range = range;
        this.damage = damage;
        this.id = id;
       
        this.player = player;
    }
    

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
