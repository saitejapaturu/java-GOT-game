package Model;

public abstract class Piece
{
    private int health;
    private boolean special;

    private final int MAX_MOVE;
    private final int RANGE;
    private final int DAMAGE;

    private final String ID;
    private final int PLAYER;
    private final int SPECIALTURN;

    // Initially, i.e turn 1, specials are turned off.
    public Piece(int health, int MAX_MOVE, int RANGE, int DAMAGE, String ID, int PLAYER, int SPECIALTURN)
    {
    	this.health = health;
        this.MAX_MOVE = MAX_MOVE;
        this.RANGE = RANGE;
        this.DAMAGE = DAMAGE;
        this.ID = ID;
       
        this.PLAYER = PLAYER;
        this.SPECIALTURN = SPECIALTURN;

        this.special = false;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public int getMAX_MOVE()
    {
        return MAX_MOVE;
    }

    public int getRANGE()
    {
        return RANGE;
    }

    public int getDAMAGE()
    {
        return DAMAGE;
    }

    public String getID()
    {
        return ID;
    }

    public int getPLAYER()
    {
        return PLAYER;
    }

    public boolean getSpecial()
    {
        return special;
    }

    public void setSpecial(boolean special)
    {
        this.special = special;
    }

    public int getSPECIALTURN()
    {
        return SPECIALTURN;
    }

    public void takeDamage(int damage)
    {
        this.health -= damage;
    }

    public boolean move (Board board, int currentX, int currentY, int newX, int newY)
    {
        if(validateMove( board, currentX,  currentY,  newX,  newY))
        {
            board.setSquarePiece(currentX, currentY, null);
            board.setSquarePiece(newX, newY,this);

            return true;
        }

        else
            return false;
    }

    public boolean validateMove(Board board, int currentX, int currentY, int newX, int newY)
    {
        //Pre conditions
        //If the new position already has a character.
        if(board.getSquarePiece(newX, newY) != null)
        {
            //If new position has the character of same team.
            if(board.getSquarePiece(newX, newY).getPLAYER() == this.getPLAYER())
            {
                System.err.println("Cannot place two characters of same team on the same square.");
            }

            //If new position has the character of different team.
            else
            {
                System.err.println("Cannot place two characters of different team on the same square, attack and defeat enemy.");
            }

            return false;
        }

        //Checks if the move is out of range.
        if(countMoveLen(currentX, currentY, newX, newY) > RANGE)
        {
            System.err.println("Move length is greater than the range of the character.");
            return false;
        }
        //If new position is not placeable.
        if(board.getSquare(newX, newY).getIsPlacebale() == false)
        {
            System.err.println("Can't place charcater on the square selected");
            return false;
        }

        //Add conditions for players moving on players
        //Add conditions for player of the characters of the same team to be placed on each other.
        return true; //test return statement
    }

    //Counts the movement length to check if it fits the character's range.
    private int countMoveLen(int currentX, int currentY, int newX, int newY)
    {
        int maxX, minX, xDiff;
        int maxY, minY, yDiff;


        if(currentX>=newX)
        {
            maxX = currentX;
            minX = newX;
        }
        else
        {
            maxX = newX;
            minX = currentX;
        }

        xDiff = maxX - minX;

        if(currentY>=newY)
        {
            maxY = currentY;
            minY = newY;
        }
        else
        {
            maxY = newY;
            minY = currentY;
        }

        yDiff = maxY - minY;

        int maxDiff;

        if(xDiff >= yDiff)
            maxDiff = xDiff;
        else
            maxDiff = yDiff;

        return maxDiff;

    }

    public abstract void special();
}
