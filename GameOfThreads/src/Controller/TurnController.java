package Controller;


public class TurnController
{
    private int turn;           //Turn increments when both players finish their turns
    private int chanceTracker;  //Tracks both players turns. i.e. is twice the urn.

    private int playerTurn;     // Tracks which player's turn it is.

    private int click;          //Is used to check if it's the first square to be selected or the second.

    private int firstX;         // Keeps data of the x coordinate of the first square selected
    private int firstY;         // Keeps data of the Y coordinate of the first square selected

    public TurnController()
    {
        this.turn = 1;
        this.playerTurn = 1;
        chanceTracker = 1;
        click = 0;
    }

    //Getter and Setter methods
    public int getTurn()
    {
        return turn;
    }

    public int getclick()
    {
        return click;
    }

    public void setClick(int click)
    {
        this.click = click;
    }

    public int getFirstX()
    {
        return firstX;
    }

    public void setFirstX(int firstX)
    {
        this.firstX = firstX;
    }

    public int getFirstY()
    {
        return firstY;
    }

    public void setFirstY(int firstY)
    {
        this.firstY = firstY;
    }

    public int getPlayerTurn()
    {
        return  playerTurn;
    }

    //Switches turns to the opposite player.
    public void switchTurn()
    {
        if (this.playerTurn == 1)
        {
            this.playerTurn = 2;
        }
        else
        {
            this.playerTurn = 1;
        }

        click = 0;

        this.chanceTracker++;
        if(((this.chanceTracker)%2) == 0)
        {
            this.turn = ((this.chanceTracker)/2);
        }

    }

    // Resets the first selected square coordinates and the click tracker for the next move
    public void reset()
    {
        this.setFirstX(0);
        this.setFirstY(0);
        this.setClick(0);
    }

    // If the first square selected is valid, applies the values to it.
    public void validFirstClick(int firstX, int firstY)
    {
        this.setFirstX(firstX);
        this.setFirstY(firstY);
        this.setClick(1);
    }
}
