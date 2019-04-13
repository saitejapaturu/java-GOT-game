package Model;

public class Square
{
    private final int X;
    private final int Y;
    private boolean occupied;
    private boolean isPlacebale;
    private Piece piece;
    private boolean isCorner;

    public Square(int X, int Y, boolean isPlacebale)
    {
        this.X = X;
        this.Y = Y;
        this.isPlacebale = isPlacebale;
        this.occupied = false;
        this.piece = null;
        this.isCorner = false;
    }
    
    public void setOccupied(boolean status)
    {
        this.occupied = status;
    }
    
    public boolean getOccupied()
    {
        return this.occupied;
    }
    
    public int getX()
    {
        return this.X;
    }
    
    public int getY()
    {
        return this.Y;
    }
    
    public void setPiece(Piece piece)
    {
        this.piece = piece;
        this.occupied = true;
    }
    
    public Piece getPiece()
    {
        return this.piece;
    }

    public boolean getIsPlacebale()
    {
        return this.isPlacebale;
    }

    public boolean getIsCorner()
    {
        return this.isCorner;
    }

    public void setIsCorner(boolean isCorner)
    {
        this.isCorner = isCorner;
    }

}
