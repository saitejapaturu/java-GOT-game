package Model;

public class Giant extends DeadPiece
{
	private static final String ID = "Giant";
	private static final int SPECIALTURN = 3;

	//As the special involves immunity. Stores the original health to return back to it next turn.
    private int originalHealth;

    private static final String SPECIAL_ACTIVE_MESSAGE = "Immune to any attack and cannot move this turn.";
    private static final String SPECIAL_DEACTIVATE_MESSAGE= "Health and range back to normal.";


    public Giant()
	{
		super(8, 1, 3, ID, SPECIALTURN, SPECIAL_ACTIVE_MESSAGE, SPECIAL_DEACTIVATE_MESSAGE);
	}

	public void special()
	{

		//tank piece goes fortifies itself every 3rd turn unable to move or take damage
        this.setRange(0);
        originalHealth = this.getHealth();
        this.setHealth(10);
        this.setSpecial(true);

        announceSpecialActivation();
	}

    //Returns to original range
    public void deactivateSpecial()
    {
        this.setHealth(originalHealth);
        this.setRange(1);
        this.setSpecial(false);

        announceSpecialDeactivation();
    }
}
