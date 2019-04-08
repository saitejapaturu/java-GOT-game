package View;

import javax.swing.*;
import java.awt.*;

public class ToolBar extends JToolBar {

	public ToolBar()
	{
		super();
		addButtons(this);

	}

	protected void addButtons(ToolBar toolBar)
	{
		JButton newGame = new JButton("New Game");
		toolBar.add(newGame);
	}
}
