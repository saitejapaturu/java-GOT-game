package Model;

public class Board
{
    final static int GRID_WIDTH = 11;   //Final board width
    private Square[][] grid;

    public Board()
    {
        this.grid = new Square[GRID_WIDTH][GRID_WIDTH];
        initialiseBoard();
    }

    public int getWidth()
    {
		return GRID_WIDTH;
	}
    
    public Square getSquare(int x, int y)
    {
        return grid[x][y];
    }

    public Piece getSquarePiece(int x, int y)
    {
        return grid[x][y].getPiece();
    }

    public void setSquare(int x, int y, Square square)
    {
        grid[x][y] = square;
    }

    public void setSquarePiece(int x, int y, Piece piece) // throws PlacingOnHollowException
    {
        grid[y][x].setPiece(piece);
    }

    private void initialiseBoard()
    {
        System.out.println("Initialising board");

        initialiseSquares();
        initialisePieces();
    }

    private void initialiseSquares()
    {

//        int max = (this.getWidth() - 1);    // the maximum co-ordinate
//
//        int mid;                            //the middle co-ordinate
//        int min = 0;                        //the starting co-ordinate
//
//        if((max%2) == 0)
//            mid = max/2;
//        else
//            mid = (max+1)/2;

        int max=10, mid=5, min=0;

        //Initialising corner squares;
        grid[max][mid] = new CornerSquare(max, mid);    // Corner Square 10,5
        grid[min][mid] = new CornerSquare(min, mid);    // Corner Square 0,5
        grid[mid][min] = new CornerSquare(mid, min);    // Corner Square 5,0
        grid[mid][max] = new CornerSquare(mid, max);    // Corner Square 5,10


        /* Initialising normal squares of the diamond block.
         * upperRow initialises the rows 1 to 5
         * and lowerRow initialises 6 to 9
         *
         * The initialisation starts at row 1 and row 9
         * and creating squares at columns 4 to 6 in those rows.
         * After every loop, upperRow increments and lowerRow decrements by 1
         * and the column width increases on both sides by 1.
         */
        for (int upperRow=1,lowerRow=9,low=4,high=6;upperRow<lowerRow;upperRow++,lowerRow--,low--,high++)
        {
            for(int i=low; i<=high;i++)
            {
                //For middle row
                if (upperRow==(lowerRow-2))
                {
                    grid[upperRow+1][i] = new Square((upperRow+1), i, true);

                    //debug
                    System.out.println("line 88: Squares created are : s0: " + (upperRow+1) + ", " + i);
                }

                grid[upperRow][i] = new Square(upperRow, i, true);
                grid[lowerRow][i] = new Square(lowerRow, i, true);

                //debug
               System.out.println("line 95: Squares created are : s1: " + upperRow + ", " + i + " and s2: " + lowerRow + ", " + i);
            }
        }
    }

    private void initialisePieces()
    {
        //Placing Player 1 pieces
        grid[0][5].setPiece(new Assassin(1));
        grid[1][4].setPiece(new Soldier(1));
        grid[1][6].setPiece(new Mage(1));
        grid[2][3].setPiece(new Support(1));
        grid[2][7].setPiece(new Scout(1));
        grid[3][2].setPiece(new Tank(1));

        //Placing player 2 pieces
        grid[10][5].setPiece(new Assassin(2));
        grid[9][4].setPiece(new Soldier(2));
        grid[9][6].setPiece(new Mage(2));
        grid[8][3].setPiece(new Support(2));
        grid[8][7].setPiece(new Scout(2));
        grid[7][2].setPiece(new Tank(2));
    }

    public boolean attack(int currentX, int currentY, int newX, int newY)
    {
        //Pre conditions
        //Check square
        if(this.getSquarePiece(newX, newY) == null)
        {
            System.err.println("Attacking an empty square");
            return false;
        }

        //if attacking character from same team
        if(this.getSquarePiece(currentX, currentY).getPLAYER() == this.getSquarePiece(newX, newY).getPLAYER())
        {
            System.err.println("Attacking character from your team");
            return false;
        }

        this.getSquarePiece(newX, newY).takeDamage(this.getSquarePiece(currentX, currentY).getDAMAGE());
        System.out.println(this.getSquarePiece(currentX, currentY).getID() + " attacked " + getSquarePiece(newX, newY).getID());


        //Post conditions
        //Update healths to client
        //Update deaths if killed
        System.out.println(this.getSquarePiece(newX, newY).getID() + " took " + this.getSquarePiece(currentX, currentY).getDAMAGE() + " damage from " + getSquarePiece(currentX, currentY).getID());

        if(this.getSquarePiece(newX, newY).getHealth() <= 0)
        {
            System.out.println(this.getSquarePiece(newX, newY).getID() + " took massive damage and died.");
            this.setSquarePiece(newX, newY, null);
        }
        else
        {
            System.out.println(this.getSquarePiece(newX, newY).getID() + " has " + this.getSquarePiece(newX, newY).getHealth() + " health remaining.");
        }

        return true;
    }
}
