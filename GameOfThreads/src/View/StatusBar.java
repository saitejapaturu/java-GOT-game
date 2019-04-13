package View;

import java.awt.Dimension;

import javax.swing.JLabel;

import Controller.TurnController;

public class StatusBar extends JLabel {
    //	statusbar class from java tips.org
	
	private TurnController turnController;
    public StatusBar(TurnController turnController) {
        super();
        super.setPreferredSize(new Dimension(100, 16));
        setMessage("Ready");
        this.turnController = turnController;
    }
     
    public void setMessage(String message) {
        setText(" "+message);        
    }        
    
    public void update()
    {
    	setMessage("Player " + turnController.getTurn() + " its your turn!");
    }
}
