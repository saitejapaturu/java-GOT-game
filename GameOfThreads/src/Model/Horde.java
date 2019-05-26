package Model;

public class Horde extends DeadPiece
{
	private static final String ID = "Horde";
	private static final int SPECIALTURN = 2;

	private int originalHealth; //As the special involves immunity. Stores the original health to return back to it next turn.

	private static final String SPECIAL_ACTIVE_MESSAGE = "Immune to attacks for this turn.";
	private static final String SPECIAL_DEACTIVATE_MESSAGE= "Health back to normal.";


	public Horde()
	{
		super(3,1, 3, ID, SPECIALTURN, SPECIAL_ACTIVE_MESSAGE, SPECIAL_DEACTIVATE_MESSAGE);
	}
	
	public void special()
	{
		//immune any damage done by enemy for one turn every 3nd turn

        originalHealth = this.getHealth();
        this.setHealth(10);
        this.setSpecial(true);

		announceSpecialActivation();
	}

    //Returns to original range
    public void deactivateSpecial()
    {
        this.setRange(originalHealth);
        this.setSpecial(false);

		announceSpecialDeactivation();
    }
}
