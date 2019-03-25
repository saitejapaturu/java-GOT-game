package Model;

public class Square
{
    private int x;
    private int y;
    private boolean occupied;
    private boolean isPlacebale;
    private Piece piece;

    public Square(int x, int y, boolean isPlacebale)
    {
        this.x = x;
        this.y = y;
        this.isPlacebale = isPlacebale;
        this.occupied = false;
        this.piece = null;
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
        return this.x;
    }
    
    public int getY()
    {
        return this.y;
    }
    
    public void setX(int x)
    {
        this.x = x;
    }
    
    public void setY(int y)
    {
        this.y = y;
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
