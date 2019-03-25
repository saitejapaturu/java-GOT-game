package Model;

public class CornerSquare extends Square
{
    private boolean isCaptured;
    private int capturedBy;

    public CornerSquare(int x, int y)
    {
        super(x,y);
        this.isCaptured = false;
        this.capturedBy = 0;
    }
    
    public void setCaptured(boolean isCaptured, int capturedBy)
    {
        this.isCaptured = isCaptured;
        this.capturedBy = capturedBy;
    }
    
    public boolean getCaptureStatus()
    {
        return this.isCaptured;
    }
    
    public int getCapturedTeam()
    {
        return this.capturedBy;
    }
    

}
