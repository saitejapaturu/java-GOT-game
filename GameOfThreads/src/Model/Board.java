package Model;

public class Board
{
    final static int GRID_WIDTH = 11;   //Final board width
    final static int GRID_HEIGHT = 11;  //Final board height
    Square[][] board;

    public Board(int GRID_WIDTH, int GRID_HEIGHT)
    {
        this.board = new Square[GRID_HEIGHT][GRID_WIDTH];
        // initBoard(); create method to initialize board
    }

    public int getWidth() {
		return GRID_WIDTH;
	}
	
	public int getHeight() {
		return GRID_HEIGHT;
	}
    
    public Square[][] getBoard()
    {
        return board;
    }

    
    public Square getSquare(int x, int y)
    {
        return board[y][x];
    }

    public Piece getSquarePiece(int x, int y)
    {
        return board[y][x].getPiece();
    }

    public void setSquare(int x, int y, Square square)
    {
        board[y][x] = square;
    }

    public void setSquarePiece(int x, int y, Piece piece) // throws PlacingOnHollowException
    {
        board[y][x].setPiece(piece);
    }

    public boolean validateMove(int newX, int newY)
    {
        if(this.getSquare(newX, newY).getIsPlacebale() == false)
        {
            return false;
        }
    }
    

    private void initBoard()
    {
        int maxWidth = this.getWidth();
        int maxHeight = this.getHeight();



        for (int i=2; i <= GRID_WIDTH; i++)
        {
            for (int j=0; j < GRID_HEIGHT; j++)
            {
                board[j][i] = new Cell(true);
                board[j][i] = new Square()
            }
        }
        
        for (int i=1; i < 5; i++)
        {
            for (int j=1; j<5; j++)
            {
                board[j][i] = new Cell(false);
            }
            
            for (int j=6; j<10; j++)
            {
                board[j][i] = new Cell(false);
            }
        }
        
        for (int i=6; i < 10; i++)
        {
            for (int j=1; j<5; j++)
            {
                board[j][i] = new Cell(false);
            }
            
            for (int j=6; j<10; j++)
            {
                board[j][i] = new Cell(false);
            }
        }
    }
}

}
