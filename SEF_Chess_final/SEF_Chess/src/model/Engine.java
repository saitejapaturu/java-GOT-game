package model;

import java.util.ArrayList;

import client.Main;

public class Engine {

	private	Board board;
	private Player playerW;
	private Player playerB;
	private Table[][] table;
	private boolean currentPlayer = true;//true = playerw, false = playerB
	private int moves;
	private int maxMoves;
	
	public Engine(Board board)
	{
		this.board = board;
		this.playerW = null;
		this.playerB = null;
		this.table = board.getTable();
		this.moves = 0;
		this.maxMoves = 0;
	}

	public void newGame()
	{
		board.newBoard();
		playerW.resetScore();
		playerB.resetScore();
		moves = maxMoves;
	}
	public void movePiece(int pieceX, int pieceY, int moveX, int moveY, Player player) {
		Pieces move = table[pieceY][pieceX].getChessPiece();
		
		table[moveY][moveX].setChessPiece(move);
		table[pieceY][pieceX].setChessPiece(null);
		
		currentPlayer = !currentPlayer;
		if(player == playerB)
		{
			moves--;
		}
		if(moves == 0)
		{
			endGame();
		}
	}
	
	public boolean validateMove(Board board, int pieceX, int pieceY, int moveX, int moveY, Player currentPlayer) {
		Table table;
		Pieces piece;
		boolean valid = false;
		Pieces pieceMoving;
		Pieces moveSpace;
		String pieceType;
		String pieceColor;
		String moveColor = null;
		String playerColor;
		
		table = board.returnTable(pieceX, pieceY);
		pieceMoving = table.getChessPiece();
		playerColor = currentPlayer.getPlayerColor();
		
		table = board.returnTable(moveX, moveY);
		moveSpace = table.getChessPiece();
		
		
		if(pieceX < 0 || pieceX > 5 || pieceY < 0 || pieceY > 5) {
			valid = false;		// Returns false if coordinates of piece moving are not within the board
		}
		
		else if(moveX < 0 || moveX > 5 || moveY < 0 || moveY > 5) {
			valid = false;			// Returns false if coordinates of where the piece is moving are not within the board
		}
		
		else if(pieceMoving == null) {
			valid = false;			// Returns false if coordinates of the piece moving contain no piece
		}
		else {
			pieceType = pieceMoving.getType();
			pieceColor = pieceMoving.getColor();
			
			if(moveSpace != null)
			{
				moveColor = moveSpace.getColor();
			}
			
			
			if(playerColor != pieceColor)
			{
				valid = false;		// Returns false if piece being moved is not the same color as the player
			}
			else if(playerColor == moveColor)
			{
				valid = false;		// Returns false if the space the piece is being moved to is the same as the player
			}
			else if(pieceType == "Rook") {
				if(moveX == pieceX && moveY == pieceY-1) {
					valid = true;		// Returns true if valid rook move in the up direction
				}
				else if(moveX == pieceX && moveY == pieceY-2) {
					table = board.returnTable(pieceX, pieceY-1);
					piece = table.getChessPiece();
					
					if(piece == null) {
						valid = true;	// Returns true if valid rook move in the up direction and doesn't move over other pieces
					}
					else {
						valid = false;	
					}
				}
				else if(moveX == pieceX && moveY == pieceY+1) {
					valid = true;		// Returns true if valid rook move in the down direction
				}
				else if(moveX == pieceX && moveY == pieceY+2) {
					table = board.returnTable(pieceX, pieceY+1);
					piece = table.getChessPiece();
					
					if(piece == null) {
						valid = true;	// Returns true if valid rook move in the down direction and doesn't move over other pieces
					}
					else {
						valid = false;	
					}
				}
				else if(moveX == pieceX-1 && moveY == pieceY) {
					valid = true;		// Returns true if valid rook move in the left direction
				}
				else if(moveX == pieceX-2 && moveY == pieceY) {
					table = board.returnTable(pieceX-1, pieceY);
					piece = table.getChessPiece();
					
					if(piece == null) {
						valid = true;	// Returns true if valid rook move in the left direction and doesn't move over other pieces
					}
					else {
						valid = false;	
					}
				}
				else if(moveX == pieceX+1 && moveY == pieceY) {
					valid = true;		// Returns true if valid rook move in the right direction
				}
				else if(moveX == pieceX+2 && moveY == pieceY) {
					table = board.returnTable(pieceX+1, pieceY);
					piece = table.getChessPiece();
					
					if(piece == null) {
						valid = true;	// Returns true if valid rook move in the right direction and doesn't move over other pieces
					}
					else {
						valid = false;	
					}
				}
				else {
					valid = false;		// If the coordinates of the move do not satisfy any of the valid moves, returns false
				}
			}	
			
			else if(pieceType == "Bishop") {
				if(moveX == pieceX-1 && moveY == pieceY-1) {
					valid = true;		// Returns true if valid bishop move in the up left direction
				}
				else if(moveX == pieceX-2 && moveY == pieceY-2) {
					table = board.returnTable(pieceX-1, pieceY-1);
					piece = table.getChessPiece();
					
					if(piece == null) {
						valid = true;	// Returns true if valid bishop move in the up left direction and doesn't move over other pieces
					}
					else {
						valid = false;	
					}
				}
				else if(moveX == pieceX+1 && moveY == pieceY+1) {
					valid = true;		// Returns true if valid bishop move in the down right direction
				}
				else if(moveX == pieceX+2 && moveY == pieceY+2) {
					table = board.returnTable(pieceX+1, pieceY+1);
					piece = table.getChessPiece();
					
					if(piece == null) {
						valid = true;	// Returns true if valid bishop move in the down right direction and doesn't move over other pieces
					}
					else {
						valid = false;	
					}
				}
				else if(moveX == pieceX-1 && moveY == pieceY+1) {
					valid = true;		// Returns true if valid bishop move in the down left direction
				}
				else if(moveX == pieceX-2 && moveY == pieceY+2) {
					table = board.returnTable(pieceX-1, pieceY+1);
					piece = table.getChessPiece();
					
					if(piece == null) {
						valid = true;	// Returns true if valid bishop move in the down left direction and doesn't move over other pieces
					}
					else {
						valid = false;	
					}
				}
				else if(moveX == pieceX+1 && moveY == pieceY-1) {
					valid = true;		// Returns true if valid bishop move in the up right direction
				}
				else if(moveX == pieceX+2 && moveY == pieceY-2) {
					table = board.returnTable(pieceX+1, pieceY-1);
					piece = table.getChessPiece();
					
					if(piece == null) {
						valid = true;	// Returns true if valid bishop move in the up right direction and doesn't move over other pieces
					}
					else {
						valid = false;		// Returns false if bishop moves over other pieces
					}
				}
				else {
					valid = false;		// If the coordinates of the move do not satisfy any of the valid moves, returns false
				}
			}
			
			else if(pieceType == "Knight") {
				if(moveX == pieceX+1 && moveY == pieceY-2 || moveX == pieceX-1 && moveY == pieceY-2) {
					valid = true;		// Returns true if valid knight move in the up left/right direction
				}
				else if(moveX == pieceX+1 && moveY == pieceY+2 || moveX == pieceX-1 && moveY == pieceY+2) {
					valid = true;		// Returns true if valid knight move in the down left/right direction
				}
				else if(moveX == pieceX-2 && moveY == pieceY+1 || moveX == pieceX-2 && moveY == pieceY-1) {
					valid = true;		// Returns true if valid knight move in the left down/up direction
				}
				else if(moveX == pieceX+2 && moveY == pieceY+1 || moveX == pieceX+2 && moveY == pieceY+1) {
					valid = true;		// Returns true if valid knight move in the right down/up direction
				}
				else {
					valid = false;		// If the coordinates of the move do not satisfy any of the valid moves, returns false
				}
			}
		}
		return valid;
	}
	
	public void checkCapture(Board board, int moveX, int moveY, Player attackingPlayer)
	{
		Table table;
		Pieces piece;
		
		table = board.returnTable(moveX, moveY);
		piece = table.getChessPiece();
		
		if(piece != null)
		{
			attackingPlayer.changeScore(5);
			if(attackingPlayer.getScore() == 30)
			{
				endGame();
			}
		}
		
	}
	
	public Player getCurrentPlayer()
	{
		if (currentPlayer == true)
		{
			return playerW;
		}
		else return playerB;
	}
	
	public void setPlayerW(String name, String playerID)
	{
		this.playerW = new Player(name, playerID, "White");
		
	}
	
	public void setPlayerB(String name, String playerID)
	{
		this.playerB = new Player(name, playerID, "Black");
		
	}
	
	public Player getPlayerB()
	{
		return playerB;
		
	}
	
	public Player getPlayerW()
	{
		return playerW;
		
	}
	
	public int getMoves()
	{
		return moves;
	}
	
	public void setMaxMoves(int x, int y)
	{
		this.maxMoves = (x+y)/2;
	}
	
	public void endGame()
	{
		
	}
}
