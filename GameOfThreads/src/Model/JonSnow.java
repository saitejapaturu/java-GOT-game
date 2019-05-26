package Model;

public class JonSnow extends AlivePiece
{
	private static final String ID = "JonSnow";
	private static final int SPECIALTURN = 2;

    private static final String SPECIAL_ACTIVE_MESSAGE = "Damage doubled for this turn.";
    private static final String SPECIAL_DEACTIVATE_MESSAGE= "Damage back to normal.";

    public JonSnow()
	{
		super(6, 2, 2, ID, SPECIALTURN, SPECIAL_ACTIVE_MESSAGE, SPECIAL_DEACTIVATE_MESSAGE);
	}

	public void special()
	{
		//soldier is able to deal double damage every 2nd turn
        this.setDamage(this.getDamage()*2);
        this.setSpecial(true);

        announceSpecialActivation();
    }

    //Returns to original range
    public void deactivateSpecial()
    {
        this.setDamage(this.getDamage()/2);
        this.setSpecial(false);

        announceSpecialDeactivation();
    }
}
