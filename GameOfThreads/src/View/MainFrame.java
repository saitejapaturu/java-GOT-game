package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Model.GameEngine;
import Model.Board;

import java.awt.*;

public class MainFrame extends JFrame {

	private final JPanel gui = new JPanel(new BorderLayout(3, 3));
	private GameEngine gameEngine;
	private Board board;

	public MainFrame(String title, Model.Board board, GameEngine gameEngine)
	{
		super(title);
		this.gameEngine = gameEngine;
		this.board = board;
		initialise();
		add(gui);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(750, 700);
		centreWindow(this);
		setPlayers();
		setVisible(true);

	}

	public void initialise()
	{
		gui.setBorder(new EmptyBorder(4,4,4,4));
		JToolBar toolbar = new JToolBar();
		JButton newGame = new JButton("New Game");
		toolbar.setFloatable(false);
		gui.add(toolbar, BorderLayout.PAGE_START);
	}

	//takes input of players and passes them to gameEngine for player object creation
	private void setPlayers() {
		String p1Name = JOptionPane.showInputDialog("Enter Player 1 Name:");
		gameEngine.setPlayer(p1Name, 1);

		String p2Name = JOptionPane.showInputDialog("Enter Player 2 Name:");
		gameEngine.setPlayer(p2Name, 2);

	}

	//ensures app starts in the middle of the screen
	public static void centreWindow(Window mainFrame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - mainFrame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - mainFrame.getHeight()) / 2);
		mainFrame.setLocation(x, y);
	}
}
