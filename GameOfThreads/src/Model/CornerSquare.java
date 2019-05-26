package Model;

public class CornerSquare extends Square
{
    //Used in A-2
    private boolean isCaptured;         // Specifies if the square is captured to check win conditions in A-2
    private int capturedBy;             // Specifies who the square is captured by to check win conditions in A-2

    public CornerSquare(int x, int y)
    {
        super(x,y, true);
        this.isCaptured = false;
        this.capturedBy = 0;
    }

    //When corner square is captured.
    public void capture(int capturedBy)
    {
        this.isCaptured = true;
        this.capturedBy = capturedBy;
    }
}
