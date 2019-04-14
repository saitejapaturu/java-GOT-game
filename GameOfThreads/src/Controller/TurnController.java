package Controller;


public class TurnController
{
    private int turn;           //Turn increments when both players finish their turns
    private int chancetracker; //Tracks both players turns. i.e. is twice the urn.

    private int playerTurn;

    private int click; //Is used to check if it's the first square to be selected or the second.

    private int firstX;
    private int firstY;

    public TurnController()
    {
        this.turn = 1;
        this.playerTurn = 1;
        click = 0;
    }

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

        this.chancetracker++;
        if(((this.chancetracker)%2) == 0)
        {
            this.turn++;
        }

    }

    public void reset()
    {
        this.setFirstX(0);
        this.setFirstY(0);
        this.setClick(0);
    }

    public void validFirstClick(int firstX, int firstY)
    {
        this.setFirstX(firstX);
        this.setFirstY(firstY);
        this.setClick(1);
    }
}
