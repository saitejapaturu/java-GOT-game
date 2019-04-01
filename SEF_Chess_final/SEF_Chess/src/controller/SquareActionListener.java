package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Board;
import model.Engine;
import model.Player;
import model.Table;
import view.Frame;

public class SquareActionListener implements ActionListener{
	private int i, j;
	private Board board;
	private static boolean selecting = false;
	private Engine gameEngine;
	private Frame gameFrame;
	private int moves;
	Player currentPlayer;
	
	public SquareActionListener(Board board, int i, int j, Engine gameEngine, Frame frame)
	{
		super();
		this.i = i;
		this.j = j;
		this.board = board;
		this.gameEngine = gameEngine;
		this.gameFrame = frame;
		this.moves = gameEngine.getMoves();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		moves = gameEngine.getMoves();
		Table[][] table = board.getTable();
		
		//checks to see if player is first selecting a piece, then if piece colour matches player
		/*is not validating the move is only determining whether the player is selecting a piece
		 *or a square that a piece is being moved to 
		 */
		//selecting represents whether the next square is a destination or origin in a move
		if(table[j][i].getChessPiece()!=null)
		{
		if(table[j][i].getChessPiece().getColor()==gameEngine.getCurrentPlayer().getPlayerColor())
		{
			board.setSelectedx(i);
			board.setSelctedy(j);
			setSelecting(true);
		}
		//checks all game rules with gameEngine then updates board and makes move
		if(table[j][i].getChessPiece().getColor()!=gameEngine.getCurrentPlayer().getPlayerColor())
		{
			if(gameEngine.validateMove(board,board.getSelectedx(), board.getSelectedy(), i, j, gameEngine.getCurrentPlayer()) == true)//engine movepice
			{
			currentPlayer = gameEngine.getCurrentPlayer();
			gameEngine.checkCapture(board,i, j, gameEngine.getCurrentPlayer());
			gameEngine.movePiece(board.getSelectedx(), board.getSelectedy(), i, j, gameEngine.getCurrentPlayer());
			gameFrame.Update(gameEngine.getCurrentPlayer().getName() + " It's your turn!" , moves);

			setSelecting(false);
			
			gameFrame.updateBoard(board.getSelectedx(), board.getSelectedy(), i, j);
			gameFrame.revalidate();
			setSelecting(false);
			//checks if game is finished
			if(gameEngine.getMoves() == 0 || currentPlayer.getScore() == 30)
			{
				gameFrame.endGame(gameEngine.getPlayerW().getScore(), gameEngine.getPlayerB().getScore(), gameEngine.getPlayerW(), gameEngine.getPlayerB());
				gameEngine.endGame();
				gameFrame.revalidate();
			}
		}
		}
		}
		else if(selecting == true)
		{
		if(table[board.getSelectedy()][board.getSelectedx()].getChessPiece()!= null)
		{
			if(gameEngine.validateMove(board,board.getSelectedx(), board.getSelectedy(), i, j, gameEngine.getCurrentPlayer()) == true)//engine movepice
				{
				currentPlayer = gameEngine.getCurrentPlayer();
				gameEngine.checkCapture(board,i, j, gameEngine.getCurrentPlayer());
				gameEngine.movePiece(board.getSelectedx(), board.getSelectedy(), i, j, gameEngine.getCurrentPlayer());
				gameFrame.Update(gameEngine.getCurrentPlayer().getName() + " It's your turn!" , moves);

				setSelecting(false);
				
				gameFrame.updateBoard(board.getSelectedx(), board.getSelectedy(), i, j);
				gameFrame.revalidate();
				setSelecting(false);
				//checks if game is finished
				if(gameEngine.getMoves() == 0 || currentPlayer.getScore() == 30)
				{
					gameFrame.endGame(gameEngine.getPlayerW().getScore(), gameEngine.getPlayerB().getScore(), gameEngine.getPlayerW(), gameEngine.getPlayerB());
					gameEngine.endGame();
					gameFrame.revalidate();
				}
			}
			else
			{
				
				setSelecting(false);
				
			}
		}
		  //if not a chess piece
		else
		{
			board.setSelectedx(i);
			board.setSelctedy(j);
			setSelecting(true);
		}
		
		}
		//if selecting == false
		else
		{
			board.setSelectedx(i);
			board.setSelctedy(j);
			setSelecting(true);
		}
		}
		//if a chess piece of same color
		
	
	public static void setSelecting(boolean b)
	{
		selecting = b;
	}

}
