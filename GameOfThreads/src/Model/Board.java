package Model;

public interface Board {
	final static int GRID_WIDTH = 11;   // Final board width
      
	 public int getWidth();
	 
	 public Square getSquare(int x, int y);
	 
	 public Piece getSquarePiece(int x, int y);
	    
	 public void setSquarePiece(int x, int y, Piece piece);   
	

	 
	 
	 public boolean attackPiece(int currentX, int currentY, int newX, int newY);
	 
	 public boolean movePiece (int currentX, int currentY, int newX, int newY);
	 
	 
	 public int checkWinConditions();
	 
	 public void activateSpecial(int specialTurn);
	 
	 public void deactivateSpecial();
	 
}
