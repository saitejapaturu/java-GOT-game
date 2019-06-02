package Model;

import View.MainFrame;

public class AbstractPieceFactory
{
    private MutableBoard board;
    private MainFrame mainFrame;


    public AbstractPieceFactory(MutableBoard board)
    {
        this.board = board;
        this.mainFrame = mainFrame;

        this.createPiece();
    }

    // Creates piece for board here in order to reduce the coupling between mutable board and piece classes.
    private void createPiece()
    {
        //Placing Player 1 pieces
        this.board.setPiece(0,5, new DaenerysTargaryen());
        this.board.setPiece(1, 4, new AryaStark());
        this.board.setPiece(1, 5, new JonSnow());
        this.board.setPiece(1, 6, new Unsullied());

        //Placing player 2 pieces
        this.board.setPiece(10, 5, new NightKing());
        this.board.setPiece(9, 4, new Giant());
        this.board.setPiece(9, 5, new General());
        this.board.setPiece(9, 6, new Horde());
    }
}
