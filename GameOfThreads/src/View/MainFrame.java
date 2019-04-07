package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.SquareActionListener;
import Model.GameEngine;
import Model.Square;
import Model.Board;
import Model.CornerSquare;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MainFrame extends JFrame {
	
	private JPanel Board;
	private final JPanel gui = new JPanel(new BorderLayout(3, 3));
	private GameEngine gameEngine;
	private JButton[][] squares;
	private Model.Board gameBoard;

	public MainFrame(String title, Model.Board board, GameEngine gameEngine)
	{
		super(title);
		this.gameEngine = gameEngine;
		this.gameBoard = board;
		initialise();
		//createDiamond();
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
		 int maxWidth = gameBoard.getWidth();
	        int maxHeight = gameBoard.getHeight();

	        int mid;

	        if((maxHeight%2) == 0)
	            mid = maxHeight/2;
	        else
	            mid = (maxHeight+1)/2;
	     squares = new JButton[maxWidth][maxHeight];
	       
		gui.setBorder(new EmptyBorder(4,4,4,4));
		JToolBar toolbar = new JToolBar();
		JButton newGame = new JButton("New Game");
		toolbar.setFloatable(false);
		gui.add(toolbar, BorderLayout.PAGE_START);
		
		
		 Board = new JPanel(new GridLayout(maxWidth, maxHeight));
		    Board.setBorder(new LineBorder(Color.BLACK));
		    gui.add(Board);
		    
		    //fills in the board panel with chess squares
		    Insets buttonMargin = new Insets(0,0,0,0);
		    
		    
	        for (int i = 0; i < squares.length; i++) {
	            for (int j = 0; j < squares[i].length; j++) {
	                JButton b = new JButton();
	                b.setMargin(buttonMargin);
	                //uses a transparent icon to allow for a background to be used as colour
	                //set to same size as chess pieces
	                ImageIcon icon = new ImageIcon(
	                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
	                b.setIcon(icon);
	                if ((j % 2 == 1 && i % 2 == 1)
	                        //) {
	                        || (j % 2 == 0 && i % 2 == 0)) {
	                   // b.setBackground(Color.WHITE);
	                } else {
	                  //  b.setBackground(Color.GRAY);
	                }
	                squares[j][i] = b;
	                //adds action listener for square interaction
	            //    squares[j][i].addActionListener(new SquareActionListener(gameBoard, j, i, gameEngine, this));
	            }
	            
	        }
	        
	        //creating corner squares
	        squares[mid-1][0] = new JButton();
	        squares[mid-1][0].addActionListener(new SquareActionListener(gameBoard, mid - 1, 0, gameEngine, this));
            squares[mid-1][0].setBackground(Color.GREEN);
            
            squares[mid-1][10] = new JButton();
	        squares[mid-1][10].addActionListener(new SquareActionListener(gameBoard, mid - 1, 10, gameEngine, this));
            squares[mid-1][10].setBackground(Color.GREEN);
            
            squares[0][mid-1] = new JButton();
	        squares[0][mid-1].addActionListener(new SquareActionListener(gameBoard, 0, mid - 1, gameEngine, this));
            squares[0][mid-1].setBackground(Color.GREEN);
            
            squares[10][mid-1] = new JButton();
	        squares[10][mid-1].addActionListener(new SquareActionListener(gameBoard, 10, mid - 1, gameEngine, this));
            squares[10][mid-1].setBackground(Color.GREEN);
     
	        // Initialise mid row first;
	        for (int i=2; i < maxWidth; i++)
	        {
	            JButton b = new JButton();
	            b.setMargin(buttonMargin);
	            //uses a transparent icon to allow for a background to be used as colour
                //set to same size as pieces
	            ImageIcon icon = new ImageIcon(
                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
               // b.setIcon(icon);
                //adding squares to board and assigning action listener
                squares[mid-1][i-1] = b;
                squares[mid-1][i-1].addActionListener(new SquareActionListener(gameBoard, mid-1, i-1, gameEngine, this));
                squares[mid-1][i-1].setBackground(Color.WHITE);
	            //for simple testing
	            System.out.println("The square added to gui is" + mid + ", " + i);
	        }

	        for(int a=(maxHeight-1); a>mid; a--)
	        {
	            int x = maxHeight - a;
	            // for the rows 2 to 5
	            int b = (x+1);


	            for (int i = (mid-x); i < (mid+x + 1); i++)
	            {
	                JButton clickable = new JButton();
		            clickable.setMargin(buttonMargin);
		            //uses a transparent icon to allow for a background to be used as colour
	                //set to same size as pieces
		            ImageIcon icon = new ImageIcon(
	                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
	                clickable.setIcon(icon);
	                clickable.setBackground(Color.WHITE);
	                //adding squares to board and assigning action listener
	               // squares[a-1][i-1] = clickable;
	                squares[b-1][i-1].addActionListener(new SquareActionListener(gameBoard, (b-1), (i-1), gameEngine, this));
	                squares[a-1][i-1].addActionListener(new SquareActionListener(gameBoard, (a-1), (i-1), gameEngine, this));
	                squares[b-1][i-1].setBackground(Color.BLACK);
	                squares[a-1][i-1].setBackground(Color.BLACK);
	            }
	            for(int i =0;i<maxWidth;i++)
		        {
		        	for(int j =0;j<maxHeight;j++)
		        	{
		        		Board.add(squares[j][i]);
		        	}
		        }
	        }

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
