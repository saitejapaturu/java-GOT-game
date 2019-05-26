package Model;

public class Unsullied extends AlivePiece
{

	private static final String ID = "Assassin";
	private static final int SPECIALTURN = 2;

	private static final String SPECIAL_ACTIVE_MESSAGE = "Range Increased for this turn.";
	private static final String SPECIAL_DEACTIVATE_MESSAGE= "Range back to normal";

	public Unsullied()
	{
		super(5, 3, 3, ID, SPECIALTURN, SPECIAL_ACTIVE_MESSAGE, SPECIAL_DEACTIVATE_MESSAGE);
	}

	public void special()
	{
		//Increases range by 1 every 2nd turn;
		//Idea for A-2 cancels any special abilities of enemy pieces for 2nd turn

		this.setRange(this.getRange()+1);
		this.setSpecial(true);

		announceSpecialActivation();
	}

	//Returns to original range
	public void deactivateSpecial()
	{
		this.setRange(this.getRange()-1);
		this.setSpecial(false);

		announceSpecialDeactivation();
	}
}
