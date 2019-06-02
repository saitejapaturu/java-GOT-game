package Model;

public abstract interface PieceFactory
{
    // Creates piece for board here in order to reduce the coupling between mutable board and piece classes.
    void createPiece(MutableBoard board);
}
