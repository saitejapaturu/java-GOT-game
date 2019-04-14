package View;

import java.awt.Dimension;

import javax.swing.JLabel;

import Controller.TurnControllerBackUp;

public class StatusBar extends JLabel {
    //	statusbar class from java tips.org
	
	private TurnControllerBackUp turnControllerBackUp;
    public StatusBar(TurnControllerBackUp turnControllerBackUp) {
        super();
        super.setPreferredSize(new Dimension(100, 16));
        setMessage("Ready");
        this.turnControllerBackUp = turnControllerBackUp;
    }
     
    public void setMessage(String message) {
        setText(" "+message);        
    }        
    
    public void update()
    {
    	setMessage("Player " + turnControllerBackUp.getTurn() + " its your turn!");
    }
}
