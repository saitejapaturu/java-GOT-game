package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.NewGameListener;
import controller.SquareActionListener;
import model.Engine;
import model.Player;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.*;
import java.net.URL;
import javax.imageio.ImageIO;

public class Frame extends JFrame{
	private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JButton[][] squares = new JButton[6][6];
    private JPanel Board;
    private final JLabel status = new JLabel(
            "StartGame");
    private static final String COLUMNS = "012345";
    private Image[][] piecePics = new Image[2][6];
    public static final int ROOK = 2, KNIGHT = 3, BISHOP = 4, PAWN = 5;
    public static final int[] STARTING_ROW = {ROOK, KNIGHT, BISHOP,
    		BISHOP, KNIGHT, ROOK};
    public static final int BLACK = 0, WHITE = 1;
    
    public ImageIcon blackRook, blackBishop, blackKnight, whiteRook, whiteBishop, whiteKnight;
    private model.Board gameBoard;
    private Engine gameEngine;
    private StatusBar statusbar;
    private StatusBar scorebar;
    private StatusBar movesbar;
    
	public Frame(String title, model.Board board, Engine gameEngine)
	{
		super(title);
		this.gameBoard = board;
		this.gameEngine = gameEngine;
		initialise();
		add(gui);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(750, 700);
		centreWindow(this);
		//pack();
		setPlayers();
        setVisible(true);
	}
	
	//takes input of players and passes them to gameEngine for player object creation
	private void setPlayers() {
		String wName = JOptionPane.showInputDialog("Enter White Player Name:");
		String wPlayerID = JOptionPane.showInputDialog("Enter White Player Nickname:");
		int wMoves = Integer.parseInt(JOptionPane.showInputDialog("Enter White Player's preferred number of moves:"));
		gameEngine.setPlayerW(wName, wPlayerID);
		
		String bName = JOptionPane.showInputDialog("Enter Black Player Name:");
		String bPlayerID = JOptionPane.showInputDialog("Enter Black Player Nickname:");
		int bMoves = Integer.parseInt(JOptionPane.showInputDialog("Enter Black Player's preferred number of moves:"));
		gameEngine.setPlayerB(bName, bPlayerID);
		
		gameEngine.setMaxMoves(wMoves, bMoves);
	}

	//creates elements of appframe and sets initial values
	public void initialise()
	{
		gui.setBorder(new EmptyBorder(4,4,4,4));
		JToolBar toolbar = new JToolBar();
		JButton newGame = new JButton("New Game");
		scorebar = new StatusBar();
		newGame.addActionListener(new NewGameListener(gameEngine, this));
		toolbar.add(newGame);
		statusbar = new StatusBar();
		movesbar = new StatusBar();
		scorebar.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.GRAY));
		toolbar.add(statusbar);
		toolbar.addSeparator();
		toolbar.add(movesbar);
		toolbar.addSeparator();
		toolbar.add(scorebar);
		toolbar.addSeparator();
		toolbar.setFloatable(false);
		gui.add(toolbar, BorderLayout.PAGE_START);
		

	    Board = new JPanel(new GridLayout(0, 6));
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
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.GRAY);
                }
                squares[j][i] = b;
                //adds action listener for square interaction
                squares[j][i].addActionListener(new SquareActionListener(gameBoard, j, i, gameEngine, this));
            }
            
        }
        
        for(int i =0;i<6;i++)
        {
        	for(int j =0;j<6;j++)
        	{
        		Board.add(squares[j][i]);
        	}
        }
	}
	
	 public final JComponent getBoard() {
	        return Board;
	    }

	    public final JComponent getGui() {
	        return gui;
	    }
	    //finds images for chess piece icons
	    private final void createImages() {
	       blackRook = createImageIcon("Black_Rook.png","Black Rook");
	       blackBishop = createImageIcon("Black_Bishop.png","Black Bishop");
	       blackKnight = createImageIcon("Black_Knight.png","Black Knight");
	       
	       whiteRook = createImageIcon("White_Rook.png","White Rook");
	       whiteBishop = createImageIcon("White_Bishop.png","White Bishop");
	       whiteKnight = createImageIcon("White_Knight.png","White Knight");
	    }

	   //sets actual square icons to chess piece icons
	   public final void setupNewGame() {
		   	createImages();
		   	for (int i = 0; i < squares.length; i++) {
	            for (int j = 0; j < squares[i].length; j++) {
	            	squares[i][j].setIcon(null);
	            }
	            }
	        squares[0][0].setIcon(blackRook);
	        squares[5][0].setIcon(blackRook);
	        squares[1][0].setIcon(blackBishop);
	        squares[4][0].setIcon(blackBishop);
	        squares[2][0].setIcon(blackKnight);
	        squares[3][0].setIcon(blackKnight);
	        
	        squares[0][5].setIcon(whiteRook);
	        squares[5][5].setIcon(whiteRook);
	        squares[1][5].setIcon(whiteBishop);
	        squares[4][5].setIcon(whiteBishop);
	        squares[2][5].setIcon(whiteKnight);
	        squares[3][5].setIcon(whiteKnight);
	        
	        status.setText("Take Move");
	    }
	   
	   //from javadocs finds class path of imgurl and creates the imageicon from img
	   protected ImageIcon createImageIcon(String path,String description)
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
	   
	   //reflects a move made on the board
	   public void updateBoard(int i, int j, int x, int y)
	   {
		   squares[x][y].setIcon(squares[i][j].getIcon());
		   squares[i][j].setIcon(null);
	   }
	   
	   //updates score, playerturn and moves left on the toolbar
	   public void Update(String text, int moves)
		{
			statusbar.setText(text + " ");
			scorebar.setText(gameEngine.getPlayerW().getPlayerId() + " Score: " + 
			gameEngine.getPlayerW().getScore() + "   " + gameEngine.getPlayerB().getPlayerId() + 
			" Score: " + gameEngine.getPlayerB().getScore());
			String movesleft = Integer.toString(moves);
			movesbar.setText("Moves Left: " + movesleft);
		}
	   
	   //ensures app starts in the middle of the screen
	   public static void centreWindow(Window frame) {
		    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		    frame.setLocation(x, y);
		}
	   
	   //endgame method called to show results and reset game
	   public void endGame(int playerWscore, int playerBscore, Player playerW, Player playerB)
	   {
		   Player winner;
		   if(playerWscore > playerBscore)
		   {
			   winner = playerW;
		   }
		   else if(playerWscore < playerBscore)
		   {
			   winner = playerB;
		   }
		   else
		   {
			   //draw event
			 String stats = String.format(playerW.getName() + "'s final score is: %d\n" + 
			 playerB.getName() + "'s final score is: %d" , playerW.getScore(), playerB.getScore());
			 JOptionPane.showMessageDialog(null, stats, "It's a Draw!", 2);
			 setupNewGame();
			 return;
		   }
		   
		   String stats = String.format(playerW.getName() + "'s final score is: %d\n" + 
		   playerB.getName() + "'s final score is: %d" , playerW.getScore(), playerB.getScore());
		   JOptionPane.showMessageDialog(null, stats, "Game Over! " + winner.getName() + " Wins!", 1);
		   setupNewGame();
	   }
	 }



