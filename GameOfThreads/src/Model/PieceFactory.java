package Model;

public class PieceFactory
{


    public PieceFactory()
    {
        
    }

    // Creates piece for board here in order to reduce the coupling between mutable board and piece classes.
    public MutableBoard createPiece(MutableBoard board)
    {
        //Placing Player 1 pieces
        board.setPiece(0,5, new DaenerysTargaryen());
        board.setPiece(1, 4, new AryaStark());
        board.setPiece(1, 5, new JonSnow());
        board.setPiece(1, 6, new Unsullied());

        //Placing player 2 pieces
        board.setPiece(10, 5, new NightKing());
        board.setPiece(9, 4, new Giant());
        board.setPiece(9, 5, new General());
        board.setPiece(9, 6, new Horde());
    
        return  board;
    }
    
}
