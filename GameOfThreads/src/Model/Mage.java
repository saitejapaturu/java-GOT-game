package Model;

public class Mage extends Piece
{
	private static final String ID = "Mage";
	private static final int SPECIALTURN = 3;

	private int originalHealth; //As the special involves immunity. Stores the original health to return back to it next turn.

	public Mage (int player)
	{
		super(5,4, 2, ID, player, SPECIALTURN);
	}
	
	public void special()
	{
		//immune any damage done by enemy for one turn every 3nd turn

        originalHealth = this.getHealth();
        this.setHealth(10);
        this.setSpecial(true);

		System.out.println("Special for Player - " + this.getPLAYER() + " Mage activated. Immune for this turn.");
	}

    //Returns to original range
    public void deactivateSpecial()
    {
        this.setRange(originalHealth);
        this.setSpecial(false);

		System.out.println("Special for Player - " + this.getPLAYER() + " Mage de-activated. Health back to normal.");
    }
}
