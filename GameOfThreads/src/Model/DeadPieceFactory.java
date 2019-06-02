package Model;

public class DeadPieceFactory implements PieceFactory
{
    @Override
    public void createPiece(MutableBoard board)
    {
        //Placing player 2 pieces
        board.setPiece(10, 5, new NightKing());
        board.setPiece(9, 4, new Giant());
        board.setPiece(9, 5, new General());
        board.setPiece(9, 6, new Horde());
    }
}
