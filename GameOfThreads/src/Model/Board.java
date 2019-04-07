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
    	System.out.println("Initialising board");
        int max = (this.getWidth() - 1);    // the maximum co-ordinate

        int mid;                            //the middle co-ordinate
        int min = 0;                        //the starting co-ordinate

        if((max%2) == 0)
            mid = max/2;
        else
            mid = (max+1)/2;

        //Initialising corner squares;
        board[max][mid] = new CornerSquare(max, mid);

        board[min][mid] = new CornerSquare(min, mid);

        board[mid][min] = new CornerSquare(mid, min);

        board[mid][max] = new CornerSquare(mid, max);


        //Initlising normal squares of the diamond block.
        //a initialises the rows 1 to 5
        // and b initialises 6 to 9
        for (int a=1,b=9,low=4,high=6;a>b;a++,b--,low--,high++)
        {

            for(int i=low; i<=high;i++)
            {
                if (a==b)
                {
                    board[a][i] =new Square( a, i,true);
                }
                else
                {
                    board[a][i] =new Square(a, i, true);
                    board[b][i] =new Square(b, i, true);

                    System.out.println("line 101: Squares created are : s1: " + a + ", " + i + " and s2: " + b + ", " + i);
                }

            }

        }

    }
}
