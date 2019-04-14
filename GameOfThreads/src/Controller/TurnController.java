package Controller;


public class TurnController
{
    private int turn;

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
        this.turn++;

    }
}
