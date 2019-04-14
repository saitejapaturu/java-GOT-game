package Model;

public class Tank extends Piece
{
	private static final String ID = "Tank";
	private static final int SPECIALTURN = 3;
	private int originalHealth;

	public Tank(int player)
	{
		super(7, 2, 2, ID, player, SPECIALTURN);
	}

	public void special()
	{
		//tank piece goes fortifies itself every 3rd turn unable to move or take damage
        this.setRange(0);
        originalHealth = this.getHealth();
        this.setHealth(10);
    }

    //Returns to original range
    public void deactivateSpecial()
    {
        this.setHealth(originalHealth);
        this.setRange(2);
    }
}
