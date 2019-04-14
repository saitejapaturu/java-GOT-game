package Model;

public class Support extends Piece
{
	private static final String ID = "Support";
	private static final int SPECIALTURN = 2;

	public Support(int player)
	{
		super(4, 2, 1, ID, player, SPECIALTURN);
	}

	public void special()
	{
		//Heals itself by 25% of total hp every 2nd turn
		this.setHealth((this.getHealth())+1);
	}

	//Returns to original range
	public void deactivateSpecial()
	{
		//Nothing to be done later, decide on what to do in A-2
	}
}
