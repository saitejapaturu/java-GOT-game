package View;

import java.awt.Dimension;

import javax.swing.JLabel;

import Controller.TurnController;

public class StatusBar extends JLabel {
    //	statusbar class from java docs
	// simple class used to display player turn and total turns
	private String p1Name;
	private String p2Name;

	private TurnController turnController;
    public StatusBar(TurnController turnController, String p1Name, String p2Name) {
        super();
        super.setPreferredSize(new Dimension(100, 16));
        setMessage("Game Of Threads!");
        this.turnController = turnController;
        this.p1Name = p1Name;
        this.p2Name = p2Name;
    }
     
    public void setMessage(String message) {
        setText(" "+message);        
    }        
    
    public void update()
    {
    	if(turnController.getPlayerTurn() == 1)
    	{
    	setMessage("Player " + turnController.getPlayerTurn() + " - " + p1Name + " its your turn!");
    	}
    	else if (turnController.getPlayerTurn() == 2)
    	{
    		setMessage("Player " + turnController.getPlayerTurn() + " - " + p2Name + " its your turn!");
    	}
    }
    
    public void updateTurns()
    {
    	setMessage("Turn Number " + turnController.getTurn());
    }
}
