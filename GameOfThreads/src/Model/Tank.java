package Model;

public class Tank extends Piece
{
	private static final String ID = "Tank";
	private static final int SPECIALTURN = 3;
	private int originalHealth;                 //As the special involves immunity. Stores the original health to return back to it next turn.

	public Tank(int player)
	{
		super(7, 2, 2, ID, player, SPECIALTURN);
	}

	public void special()
	{
        System.out.println("Special for tank activated");

		//tank piece goes fortifies itself every 3rd turn unable to move or take damage
        this.setRange(0);
        originalHealth = this.getHealth();
        this.setHealth(10);
        this.setSpecial(true);

        System.out.println("Special for Player - " + this.getPLAYER() + " Tank activated. Immune to any attack and cannot move this turn.");
    }

    //Returns to original range
    public void deactivateSpecial()
    {
        this.setHealth(originalHealth);
        this.setRange(2);
        this.setSpecial(false);

        System.out.println("Special for Player - " + this.getPLAYER() + " Tank de-activated. Health and range back to normal.");
    }
}
