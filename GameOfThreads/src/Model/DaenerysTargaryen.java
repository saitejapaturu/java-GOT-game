package Model;

public class DaenerysTargaryen extends AlivePiece
{

    private static final String ID = "Dragon Queen";
    private static final int SPECIALTURN = 2;

    private static final String SPECIAL_ACTIVE_MESSAGE = "All enemies within range got burned and health reduced by 2";
    private static final String SPECIAL_DEACTIVATE_MESSAGE= "";

    public DaenerysTargaryen()
    {
        super(10, 4, 3, ID, SPECIALTURN, SPECIAL_ACTIVE_MESSAGE, SPECIAL_DEACTIVATE_MESSAGE);
    }

    public void special()
    {
        //All enemies with the range of 4 got -2
        //Idea for A-2 cancels any special abilities of enemy pieces for 2nd turn

        announceSpecialActivation();


        this.setSpecial(true);
    }

    //Returns to original range
    public void deactivateSpecial()
    {
        this.setSpecial(false);
    }
}
