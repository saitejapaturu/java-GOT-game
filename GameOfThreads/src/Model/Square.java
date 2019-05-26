package Model;

public class Square
{
    private final int X;            // X coordinate of square
    private final int Y;            // Y coordinate of square
    private boolean isPlacebale;    // To signify if the square is placeable
    private Piece piece;            // Stores a piece in the square

    public Square(int X, int Y, boolean isPlacebale)
    {
        this.X = X;
        this.Y = Y;
        this.isPlacebale = isPlacebale;
        this.piece = null;
    }

    
    public void setPiece(Piece piece)
    {
        this.piece = piece;
    }
    
    public Piece getPiece()
    {
        return this.piece;
    }

    public boolean getIsPlacebale()
    {
        return this.isPlacebale;
    }
}
