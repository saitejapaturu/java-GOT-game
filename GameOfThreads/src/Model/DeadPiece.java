package Model;

public abstract class DeadPiece extends Piece
{
    private static final int PLAYER = 2;

    public DeadPiece(int health, int range, int damage, String ID, int SPECIALTURN,
                     String SPECIAL_ACTIVE_MESSAGE, String SPECIAL_DEACTIVATE_MESSAGE)
    {
        super(health, range, damage, ID, PLAYER, SPECIALTURN, SPECIAL_ACTIVE_MESSAGE, SPECIAL_DEACTIVATE_MESSAGE);
    }

}
