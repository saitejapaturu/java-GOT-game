package Model;

public class Scout extends Piece
{
	private static final String ID = "Scout";
	private static final int SPECIALTURN = 2;

	public Scout(int player)
	{
		super(3, 4, 1, ID, player, SPECIALTURN);
	}

    public void special()
    {
        //scout is able to move to any square on the map instantly every 2nd turn
        this.setRange(10);
        this.setSpecial(true);
    }

    //Returns to original range
    public void deactivateSpecial()
    {
        this.setRange(4);
        this.setSpecial(false);
    }
}
