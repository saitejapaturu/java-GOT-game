package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.*;
import Model.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MainFrame extends JFrame {
	
	private JPanel Board;
	private final JPanel gui = new JPanel(new BorderLayout(3, 3));
	private JButton[][] gridGUI;
	private MutableBoard gameBoard;
	private StatusBar statusBar;
	private StatusBar turnTracker;
	private ImageIcon DaenerysTargaryen, Unsullied, AryaStark, JonSnow, NightKing, Giant, General, Horde;
	private TurnController turnController;
	private static String p1Name;
	private static String p2Name;
	private UndoButton undoButton;
	private RedoButton redoButton;
	private SaveButton saveButton;
	private DefendButton defendButton;
	private EndOfTurnActionListenerDecorator endOfTurnActionListenerDecorator;

	public MainFrame(String title, MutableBoard board, TurnController turnController)
	{
		super(title);

		this.gameBoard = board;
		this.turnController = turnController;
		this.undoButton = new UndoButton();
		this.redoButton = new RedoButton();
		this.saveButton = new SaveButton();
		this.defendButton = new DefendButton();

		// Creating endOfturnDecorater for actionlisteners
		this.endOfTurnActionListenerDecorator = new EndOfTurnActionListenerDecorator(this.gameBoard,
				this.turnController, this);

		Initialise();
		createImages();
		updateBoardIcon();
		add(gui);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(1100, 1100);
		centreWindow(this);
		setPlayers();
		setVisible(true);
		this.statusBar = new StatusBar(turnController, p1Name, p2Name);
		this.turnTracker = new StatusBar(turnController, null, null);
		getContentPane().add(turnTracker, java.awt.BorderLayout.NORTH);
		getContentPane().add(statusBar, java.awt.BorderLayout.SOUTH);
		
		statusBar.update();

	}

	
	//takes input of players and passes them to gameEngine for status bar and win screen
	private void setPlayers() {
		p1Name = JOptionPane.showInputDialog("Enter Player 1 Name:");
		p2Name = JOptionPane.showInputDialog("Enter Player 2 Name:");
	}

	//ensures app starts in the middle of the screen
	public static void centreWindow(Window mainFrame)
	{
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - mainFrame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - mainFrame.getHeight()) / 2);
		mainFrame.setLocation(x, y);
	}
	
	//simple method for making piece icons
	private void createImages()
	{
		//For Player 1
		DaenerysTargaryen = createImageIcon("images/DaenerysTargaryen.png","Image of Daenerys Targaryen");
		Unsullied = createImageIcon("images/Unsullied.png","Image of Unsullied");
		AryaStark = createImageIcon("images/AryaStark.png","Image of Arya Stark");
		JonSnow = createImageIcon("images/JonSnow.png","Image of Jon Snow");

		//For player 2
		NightKing = createImageIcon("images/NightKing.png","Image of Nigght King");
		Giant = createImageIcon("images/Giant.png","Image of Giant");
		Horde = createImageIcon("images/Horde.png","Image of Horde");
		General = createImageIcon("images/General.png","Image of General");
	}
	
	//from java help docs
	 private ImageIcon createImageIcon(String path,String description)
	   {
		 	
		   java.net.URL imgURL = getClass().getResource(path);
		   if (imgURL != null) 
		   {
			   return new ImageIcon(imgURL, description);
		   } else 
		   {
			   System.err.println("Couldn't find file: " + path);
			   return null;
		   }
	   }
	 
	 private void Initialise()
	 {
		 undoButton.addActionListener(new UndoListener(gameBoard, this));
		 redoButton.addActionListener(new RedoListener(gameBoard, this));
		 saveButton.addActionListener(new SaveListener(gameBoard.getHistory()));

		 defendButton.addActionListener(new DefendListener(gameBoard, turnController,  endOfTurnActionListenerDecorator));
		 int width = gameBoard.getSize();

		 int max=10, mid=5, min=0;

		 //Initialising GUI
		 //Creating grid
	        gridGUI = new JButton[width][width];
			gui.setBorder(new EmptyBorder(4,4,4,4));
			JToolBar toolbar = new JToolBar();
			toolbar.setFloatable(false);
			gui.add(toolbar, BorderLayout.PAGE_START);
			
			 Board = new JPanel(new GridLayout(width, width));
			 Board.setBorder(new LineBorder(Color.BLACK));
			 gui.add(Board);
			    
			    //fills in the board panel with chess gridGUI
			    Insets buttonMargin = new Insets(0,0,0,0);
			    ImageIcon icon = new ImageIcon(
	                    new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB));
			    
			    
		        for (int y = 0; y < gridGUI.length; y++)
		        {
					for (int j = 0; j < gridGUI[y].length; j++)
					{
						JButton b = new JButton();
						b.setMargin(buttonMargin);

						b.setIcon(icon);
						b.setOpaque(false);
						b.setContentAreaFilled(false);
						b.setBorderPainted(false);
						gridGUI[j][y] = b;
						//adds action listener for square interaction
					}
				}
		        gridGUI[gridGUI.length - 1][gridGUI.length - 1] = undoButton;
		        gridGUI[gridGUI.length - 1][gridGUI.length - 2] = redoButton;
		        gridGUI[0][10] = saveButton;
		        gridGUI[10][0] = defendButton;


    		/* Initialising normal squares of the diamond block.
			 * upperRow initialises the rows 1 to 5
			 * and lowerRow initialises 6 to 9
			 *
			 * The initialisation starts at row 1 and row 9
			 * and creating squares at columns 4 to 6 in those rows.
			 * After every loop, upperRow increments and lowerRow decrements by 1
			 * and the column width increases on both sides by 1.
			 * 
			 * Jbuttons are created and given correct properties
			 */
    		for (int upperRow=1,lowerRow=9,low=4,high=6;upperRow<lowerRow;upperRow++,lowerRow--,low--,high++)
    		{
    			for(int i=low; i<=high;i++)
    			{
    				//For middle row
					if (upperRow==(lowerRow-2))
					{
						createJButton(upperRow+1, i, Color.DARK_GRAY);
					}

					createJButton(upperRow, i, Color.DARK_GRAY);

					createJButton(lowerRow, i, Color.DARK_GRAY);
    			}
    		}
    		
    		//individually creating corner squares so they can be assigned different colour


		 createJButton(max, mid, Color.GREEN);
		 createJButton(min, mid, Color.GREEN);
		 createJButton(mid, min, Color.GREEN);
		 createJButton(mid, max, Color.GREEN);
				
		 //adding buttons to view
		 for(int i = 0;i<width;i++)
		 {
		 	for (int j= 0; j<width;j++)
		 	{
		 		Board.add(gridGUI[i][j]);
		 	}
		 }

	 }

	 private void createJButton(int x, int y, Color color)
	 {
		gridGUI[x][y] = new JButton();
		gridGUI[x][y].addActionListener(new SquareActionListener(gameBoard, x, y, turnController,
																	endOfTurnActionListenerDecorator));
		gridGUI[x][y].setBackground(color);
		setButtonProperties(gridGUI[x][y]);
	 }

	  //simple helper method to set buttons not a part of board
	  public void setButtonProperties(JButton button)
	   {
		   button.setOpaque(true);
           button.setContentAreaFilled(true);
           button.setBorderPainted(true);
	   }

	   public void endOfTurn()
	   {
//	   		Board board = gameBoard;
//
//	   		history.moveMade(board);
	   		updateComponents();
	   }
	   //updates individual gui components according to board
	   public void updateComponents()
	   {
		   statusBar.update();
		   turnTracker.updateTurns();
		   updateBoardIcon();
		   int playerWins = gameBoard.checkWinConditions();
		   if(playerWins == 1)
		   {
			   statusBar.setMessage(p1Name + " Wins!");
			   displayWin(playerWins);
		   }
		   else if(playerWins == 2)
		   {
			  statusBar.setMessage(p2Name + " Wins!");
			  displayWin(playerWins);
		   }
	   }
	   
	 //checks for dead pieces and updates gui, also checks for character pieces when undo/redo
	   public void updateBoardIcon()
	   {
		   int dim = gameBoard.getSize();
		   for(int i = 0;i<dim;i++)
	        {
	        	for (int j= 0; j<dim;j++)
	        	{
	        		if(gameBoard.getSquare(i, j)!=null)
	        		{
	        			if(gameBoard.getSquare(i, j).getPiece() == null)
	        			{
	        				gridGUI[i][j].setIcon(null);
	        			}
	        			else if (gameBoard.getSquare(i,j).getPiece() instanceof DaenerysTargaryen)
	        			{
							gridGUI[i][j].setIcon(DaenerysTargaryen);
						}
						else if (gameBoard.getSquare(i,j).getPiece() instanceof AryaStark)
						{
							gridGUI[i][j].setIcon(AryaStark);
						}
						else if (gameBoard.getSquare(i,j).getPiece() instanceof JonSnow)
						{
							gridGUI[i][j].setIcon(JonSnow);
						}
						else if (gameBoard.getSquare(i,j).getPiece() instanceof Unsullied)
						{
							gridGUI[i][j].setIcon(Unsullied);
						}
						else if (gameBoard.getSquare(i,j).getPiece() instanceof NightKing)
						{
							gridGUI[i][j].setIcon(NightKing);
						}
						else if (gameBoard.getSquare(i,j).getPiece() instanceof Giant)
						{
							gridGUI[i][j].setIcon(Giant);
						}
						else if (gameBoard.getSquare(i,j).getPiece() instanceof General)
						{
							gridGUI[i][j].setIcon(General);
						}
						else if (gameBoard.getSquare(i,j).getPiece() instanceof Horde)
						{
							gridGUI[i][j].setIcon(Horde);
						}
	        		}
	        	}
	        }
	   }

	   public void undoRedo()
	   {
	   		turnController.updateTurn(this.gameBoard.getTurn());
		    endOfTurn();
	   }

	   private static void displayWin(int player)
	   {
	   //creates a simple win alert and closes game
		  String winningMessage = null;
		  if(player == 1)
		  {
		  		winningMessage = "Congratulations player " + p1Name + " you win!";
		  }
		  else if(player == 2)
		  {
		  		winningMessage = "Congratulations player " + p2Name + " you win!";
		  }
		  int close = JOptionPane.showConfirmDialog(null, winningMessage, "Game Over", JOptionPane.DEFAULT_OPTION);
		  if (close == 0)
		  {
	    	   System.exit(0);
		  }
	   }
}
