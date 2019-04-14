package Controller;


public class TurnController
{
    private int turn;

    private int playerTurn;

    public TurnController()
    {
        this.turn = 1;
        this.playerTurn = 1;
    }

    public int getTurn()
    {
        return turn;
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

        this.turn++;

    }
}
