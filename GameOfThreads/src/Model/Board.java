package Model;

public class Board
{
    final static int GRID_WIDTH = 11;   //Final board width
    final static int GRID_HEIGHT = 11;  //Final board height
    Square[][] board;

    public Board()
    {
        this.board = new Square[GRID_HEIGHT][GRID_WIDTH];
        initBoard();
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
        if(this.getSquare(newX, newY).getIsPlacebale() == true)
        {
            return true;
        }

        //Add conditions for players moving on players
        //Add conditions for player of the characters of the same team to be placed on each other.
        return false; //test return statement
    }
    

    private void initBoard()
    {
        int maxWidth = this.getWidth();
        int maxHeight = this.getHeight();

        int mid;

        if((maxHeight%2) == 0)
            mid = maxHeight/2;
        else
            mid = (maxHeight+1)/2;

            //Initialising corner squares;
        board[mid][1] = new CornerSquare(1,mid);
        board[mid][11] = new CornerSquare(11,mid);
        board[1][mid] = new CornerSquare(mid,1);
        board[11][mid] = new CornerSquare(mid,11);

        // Initialise mid row first;
        for (int i=2; i < GRID_WIDTH; i++)
        {
            board[mid][i] = new Square(i, mid, true);

            //for simple testing
            System.out.println("The square created is " + mid + ", " + i);
        }

        for(int a=(maxHeight-1); a>mid; a--)
        {
            int x = maxHeight - a;

            // for the rows 7 to 10
            for (int i = (mid-x); i < (mid+x); i++)
            {
                board[a][i] = new Square(i, a, true);
            }

            // for the rows 2 to 5

            int b = (x+1);
            for (int i = (mid-x); i < (mid+x); i++)
            {
                board[b][i] = new Square(i, b, true);
            }

        }

    }
}
