package Model;

public class General extends DeadPiece
{
	private static final String ID = "General";
	private static final int SPECIALTURN = 2;

	private static final String SPECIAL_ACTIVE_MESSAGE = "Health increased by 25%.";
	private static final String SPECIAL_DEACTIVATE_MESSAGE= "";


	public General()
	{
		super(5, 3, 2, ID, SPECIALTURN, SPECIAL_ACTIVE_MESSAGE, SPECIAL_DEACTIVATE_MESSAGE);
	}

	public void special()
	{
		//Heals itself by 25% of total hp every 2nd turn
		this.setHealth((this.getHealth())+1);
		this.setSpecial(true);

		announceSpecialActivation();
		System.out.print(" Health is now: " + this.getHealth() + "\n");
	}

	//Returns to original range
	public void deactivateSpecial()
	{
		//Nothing to be done later, decide on what to do in A-2
		this.setSpecial(false);
	}
}
