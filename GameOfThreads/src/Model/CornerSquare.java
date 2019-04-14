package Model;

public class CornerSquare extends Square
{
    private boolean isCaptured;
    private int capturedBy;

    public CornerSquare(int x, int y)
    {
        super(x,y, true);
        this.isCaptured = false;
        this.capturedBy = 0;
    }
    
    public void capture(int capturedBy)
    {
        this.isCaptured = true;
        this.capturedBy = capturedBy;
    }
    

}
