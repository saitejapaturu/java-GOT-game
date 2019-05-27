package Model;

public class AryaStark extends AlivePiece
{
	private static final String ID = "No One";
	private static final int SPECIALTURN = 3;

    private static final String SPECIAL_ACTIVE_MESSAGE = "Can move or attack to any empty place on board this turn.";
    private static final String SPECIAL_DEACTIVATE_MESSAGE= "Range is back to normal.";


    public AryaStark()
	{
		super(4, 4, 2, ID, SPECIALTURN, SPECIAL_ACTIVE_MESSAGE, SPECIAL_DEACTIVATE_MESSAGE);
	}

    public void special()
    {
        //scout is able to move to any square on the map instantly every 2nd turn
        this.setRange(10);
        this.setSpecial(true);

        announceSpecialActivation();
    }

    //Returns to original range
    public void deactivateSpecial()
    {
        this.setRange(4);
        this.setSpecial(false);

        announceSpecialDeactivation();
    }
}
