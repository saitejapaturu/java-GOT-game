package Model;

public class AlivePieceFactory implements PieceFactory
{
    @Override
    public void createPiece(MutableBoard board)
    {
        //Placing Player 1 pieces
        board.setPiece(0,5, new DaenerysTargaryen());
        board.setPiece(1, 4, new AryaStark());
        board.setPiece(1, 5, new JonSnow());
        board.setPiece(1, 6, new Unsullied());
    }
}
