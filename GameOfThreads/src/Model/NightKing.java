package Model;

public class NightKing extends DeadPiece
{

    private static final String ID = "Night King";
    private static final int SPECIALTURN = 3;

    private static final String SPECIAL_ACTIVE_MESSAGE = "All enemies within range got burned and health reduced by 2";
    private static final String SPECIAL_DEACTIVATE_MESSAGE= "";

    public NightKing()
    {
        super(10, 4, 3, ID, SPECIALTURN, SPECIAL_ACTIVE_MESSAGE, SPECIAL_DEACTIVATE_MESSAGE);
    }

    public void special()
    {
        //All allies with the range of 4 get +2 health

        announceSpecialActivation();

        this.setSpecial(true);
    }

    //Returns to original range
    public void deactivateSpecial()
    {
        this.setSpecial(false);
    }
}
