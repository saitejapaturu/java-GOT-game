package Controller;

import Model.MutableBoard;
import View.MainFrame;

public class EndOfTurnActionListenerDecorator
{
    private MutableBoard board;
    private TurnController turnController;
    private MainFrame mainFrame;

    public EndOfTurnActionListenerDecorator(MutableBoard board, TurnController turnController, MainFrame mainFrame)
    {
        this.board = board;
        this.turnController = turnController;
        this.mainFrame = mainFrame;
    }

    //This method gets called at the end of the turn.
    //move to turn controller based on patterns
    public void endTurn()
    {

        turnController.switchTurn();
        mainFrame.revalidate();
        //debug
        mainFrame.endOfTurn();

        specials();
    }

    // All the specials from previous turn get deactivated and specials for this turn get activated.
    private void specials()
    {
        board.deactivateSpecial();

        //If the turn is a multiple of 2, activate specials of the pieces whose special activates on every 3rd turn
        if(turnController.getTurn()%2 == 0)
        {
            board.activateSpecial(2);
        }

        //If the turn is a multiple of 3, activate specials of the pieces whose special activates on every 3rd turn
        else if(turnController.getTurn()%3 == 0)
        {
            board.activateSpecial(3);
        }
    }
}
