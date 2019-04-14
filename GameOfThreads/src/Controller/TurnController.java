package Controller;

import Model.*;

public class TurnController
{
    private int turn;

    private int click;

    private boolean p1;
    private boolean p2;

    private Square selectedSquare;

    public TurnController()
    {
        this.turn = 1;
        this.click = 0;
        this.p1 = true;
        this.p2 = false;
    }

    public int getTurn()
    {
        return turn;
    }

    public void switchClick()
    {
        if (this.click == 0)
        {
            this.click = 1;
        }
        else
        {
            this.click = 0;
        }

    }

    public void switchTurn()
    {
        if (this.turn == 1)
        {
            this.turn = 2;
        }
        else
        {
            this.turn = 1;
        }

        this.click = 0;

    }
}
