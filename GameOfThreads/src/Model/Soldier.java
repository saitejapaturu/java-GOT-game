package Model;

public class Soldier extends Piece
{
	private static final String ID = "Soldier";
	private static final int SPECIALTURN = 2;

	public Soldier(int player)
	{
		super(4, 2, 2, ID, player, SPECIALTURN);
	}

	public void special()
	{
		//soldier is able to deal double damage every 2nd turn
        this.setDamage(4);
        this.setSpecial(true);
    }

    //Returns to original range
    public void deactivateSpecial()
    {
        this.setDamage(2);
        this.setSpecial(false);
    }
}
