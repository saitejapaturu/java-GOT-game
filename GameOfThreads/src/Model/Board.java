package Model;

public class Board
{
    final static int GRID_WIDTH = 11;   //Final board width
    final static int GRID_HEIGHT = 11;  //Final board height
    private Square[][] board;

    public Board()
    {
        this.board = new Square[GRID_HEIGHT][GRID_WIDTH];
        initBoard();
    }

    public int getWidth()
    {
		return GRID_WIDTH;
	}
	
	public int getHeight()
    {
		return GRID_HEIGHT;
	}
    
    public Square[][] getBoard()
    {
        return board;
    }

    
    public Square getSquare(int x, int y)
    {
        return board[x][y];
    }

    public Piece getSquarePiece(int x, int y)
    {
        return board[x][y].getPiece();
    }

    public void setSquare(int x, int y, Square square)
    {
        board[x][y] = square;
    }

    public void setSquarePiece(int x, int y, Piece piece) // throws PlacingOnHollowException
    {
        board[y][x].setPiece(piece);
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
        for (int a=1,b=9,low=4,high=6;a<b;a++,b--,low--,high++)
        {

            for(int i=low; i<=high;i++)
            {
                //For middle row
                if (a==(b-2))
                {
                    board[a+1][i] = new Square((a+1), i, true);
                    //System.out.println("line 97: Squares created are : s1: " + (a+1) + ", " + i);
                }

                board[a][i] =new Square(a, i, true);
                board[b][i] =new Square(b, i, true);

               // System.out.println("line 103: Squares created are : s1: " + a + ", " + i + " and s2: " + b + ", " + i);
            }
        }
        
        board[0][5].setPiece(new Assassin("Assassin", 1));
        board[1][4].setPiece(new Assassin("Assasin", 2));
        board[1][6].setPiece(new Mage("Mage", 1));
        board[2][3].setPiece(new Mage("Mage", 2));
        board[2][7].setPiece(new Scout("Scout", 1));
        board[3][2].setPiece(new Scout("Scout", 2));
        
        board[10][5].setPiece(new Soldier("Soldier",1));
        board[9][4].setPiece(new Soldier("Soldier",2));
        board[9][6].setPiece(new Support("Support",1));
        board[8][3].setPiece(new Support("Support",2));
        board[8][7].setPiece(new Tank("Tank",1));
        board[7][2].setPiece(new Tank("Tank",2));
        
        
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
        if(this.getSquarePiece(currentX, currentY).getPlayer() == this.getSquarePiece(newX, newY).getPlayer())
        {
            System.err.println("Attacking character from your team");
            return false;
        }

        this.getSquarePiece(newX, newY).takeDamage(this.getSquarePiece(currentX, currentY).getDamage());
        System.out.println(this.getSquarePiece(currentX, currentY).getID() + " attacked " + getSquarePiece(newX, newY).getID());


        //Post conditions
        //Update healths to client
        //Update deaths if killed
        System.out.println(this.getSquarePiece(newX, newY).getID() + " took " + this.getSquarePiece(currentX, currentY).getDamage() + " damage from " + getSquarePiece(currentX, currentY).getID());

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
