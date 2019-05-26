package Model;

public class ImmutableBoard implements Board
{
    private Square[][] grid;    // A 2-d array of squares
    final int turnCreated;
    
    public ImmutableBoard(int turnCreated, Square[][] grid)
    {
        this.grid = grid;
        this.turnCreated = turnCreated;
    }
    
    public ImmutableBoard getBoard() 
    {
    	return this;
    }

    public Square[][] getGrid()
    {
        return this.grid;
    }

    //getter setter methods
    public int getSize()
    {
		return this.SIZE;
	}
    
    public Square getSquare(int x, int y)
    {
        return grid[x][y];
    }

    public Piece getSquarePiece(int x, int y)
    {
        return grid[x][y].getPiece();
    }

    public void setSquarePiece(int x, int y, Piece piece)
    {
        grid[x][y].setPiece(piece);
    }

    // The piece in current coordinates attacks the piece in new coordinates
    public boolean attackPiece(int currentX, int currentY, int newX, int newY)
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

    // The piece in current coordiantes moves to new coordinates
    public boolean movePiece (int currentX, int currentY, int newX, int newY)
    {
        if(validateMove( currentX,  currentY,  newX,  newY))
        {
            grid[newX][newY].setPiece(grid[currentX][currentY].getPiece());

            grid[currentX][currentY].setPiece(null);

            //Notify user if corner square is captured and make appropriate changes
            if(grid[newX][newY] instanceof CornerSquare)
            {
                System.out.println("Corner Square captured by : Player " + grid[newX][newY].getPiece().getPLAYER());
                ((CornerSquare)(grid[newX][newY])).capture(grid[newX][newY].getPiece().getPLAYER());
                checkWinConditions();
            }
            return true;
        }

        else
            return false;
    }

    //Helper methiod to check if the move is valid and if not valid displays error messages
    private boolean validateMove(int currentX, int currentY, int newX, int newY)
    {
        //check
        //Pre conditions
        //If the new position already has a character.
        if(grid[newX][newY].getPiece() != null)
        {
            //If new position has the character of same team.
            if(grid[newX][newY].getPiece().getPLAYER() == grid[currentX][currentY].getPiece().getPLAYER())
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
        else if(countMoveLength(currentX, currentY, newX, newY) > grid[currentX][currentY].getPiece().getRange())
        {
            System.err.println("Move length is greater than the range of the character.");
            return false;
        }
        //If new position is not placeable.
        else if(grid[newX][newY].getIsPlacebale() == false)
        {
            System.err.println("Can't place character on the square selected");
            return false;
        }

        return true; //test return statement
    }

    // Helper method that counts the movement length to check if it fits the character's range.
    private int countMoveLength(int currentX, int currentY, int newX, int newY)
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

    // Helper methiod to check if either of the players won and if they did returns the winner's id
    // Returns 0 if no-one won
    // Returns 1 if player 1 won
    // returns 2 if player 2 won
    public int checkWinConditions()
    {
        //check for errors
        if(((allCornerSquareCaputeredBy() == 1) && (allEnemyCharactersDefeatedBy() == 2)) || ((allCornerSquareCaputeredBy() == 2) && (allEnemyCharactersDefeatedBy() == 1)))
        {
            System.err.println("Error: Both Player 1 and Player 2 have win conditions!");
            return 0;
        }

        else if((allCornerSquareCaputeredBy() == 1) || (allEnemyCharactersDefeatedBy() == 1))
        {
            System.out.println("Player 1 wins!");
            return 1;
        }

        else if((allCornerSquareCaputeredBy() == 2) || (allEnemyCharactersDefeatedBy() == 2))
        {
            System.out.println("Player 2 wins!");
            return 2;
        }

        return 0;
    }


    //Checks if all squares are occupied by characters of same team and if they did returns their player id.
    //Returns 0 if all corner squares aren't occupied by the same player characters
    //Returns 1 if all corner squares are occupied by player 1.
    //Returns 2 if all corner squares are occupied by player 2.
    private int allCornerSquareCaputeredBy()
    {
        //Check if any corner squares are unoccupied
        if((grid[10][5].getPiece() == null) || (grid[0][5].getPiece() == null) || (grid[5][0].getPiece() == null) || (grid[5][10].getPiece() == null))
        {
            return 0;
        }

        if((grid[10][5].getPiece().getPLAYER() == 1) && (grid[0][5].getPiece().getPLAYER() == 1) && (grid[5][0].getPiece().getPLAYER() == 1) && (grid[5][10].getPiece().getPLAYER() == 1))
        {
            System.out.println("All Corner Squares Captured by Player 1.");
            return 1;
        }

        else if((grid[10][5].getPiece().getPLAYER() == 2) && (grid[0][5].getPiece().getPLAYER() == 2) && (grid[5][0].getPiece().getPLAYER() == 2) && (grid[5][10].getPiece().getPLAYER() == 2))
        {
            System.out.println("All Corner Squares Captured by Player 2.");
            return 2;
        }

        return 0;
    }

    // Checks if all characters of either team are defeated and if they did, returns the survivingg player's id.
    //Returns 0 if both player's have atleast 1 character alive.
    //Returns 1 if player 1 killed all players on player 2.
    //Returns 2 if player 2 killed all players on player 1.
    private int allEnemyCharactersDefeatedBy()
    {
        boolean allPlayer1CharactersDied = true;
        boolean allPlayer2CharactersDied = true;

        //This for loops checks all squares of the grid for players and check's what team the players belong to.
        for(int i=0; i<SIZE; i++)
        {
            for(int j=0; j<SIZE; j++)
            {
                //Check if the square isn't null;
                if(grid[i][j] != null)
                {
                    //Check if the square has a piece
                    if(grid[i][j].getPiece() != null)
                    {
                        //Check what player characters belong to.
                        if(grid[i][j].getPiece().getPLAYER() == 1)
                        {
                            allPlayer1CharactersDied = false;
                        }
                        else if(grid[i][j].getPiece().getPLAYER() == 2)
                        {
                            allPlayer2CharactersDied = false;
                        }
                    }
                }

            }
        }

        //Check for errors
        if((allPlayer1CharactersDied) && (allPlayer2CharactersDied))
        {
            System.err.println("Error: All Characters Died.");
            return 0;
        }

        else if(allPlayer1CharactersDied)
        {
            System.out.println("All Player 1 Characters Died.");
            return 2;
        }

        else if(allPlayer2CharactersDied)
        {
            System.out.println("All Player 2 Characters Died.");
            return 1;
        }

        return 0;
    }

    //Activates special of all pieces if thir special turn is the same as the one given
    public void activateSpecial(int specialTurn)
    {
        System.out.println("\nSpecial Moves Activated: ");
        //This for loops checks all squares of the grid for pieces and activate appropriate specials.
        for(int i=0; i<SIZE; i++)
        {
            for(int j=0; j<SIZE; j++)
            {
                //Check if the square isn't null;
                if(grid[i][j] != null)
                {
                    //Check if the square has a piece
                    if(grid[i][j].getPiece() != null)
                    {
                        //If the special turn is the same activate special.
                        if(grid[i][j].getPiece().getSPECIALTURN() == specialTurn)
                        {
                            grid[i][j].getPiece().special();
                        }
                    }
                }
            }
        }
    }

    //deactivates special of all pieces on board.
    public void deactivateSpecial()
    {
        System.out.println("\nSpecial Moves De-activated: ");
        //This for loops checks all squares of the grid for pieces and activate appropriate specials.
        for(int i=0; i<SIZE; i++)
        {
            for(int j=0; j<SIZE; j++)
            {
                //Check if the square isn't null;
                if(grid[i][j] != null)
                {
                    //Check if the square has a piece
                    if(grid[i][j].getPiece() != null)
                    {
                        //If the special turn is the same deactivate special.
                        if(grid[i][j].getPiece().getSpecial())
                        {
                            grid[i][j].getPiece().deactivateSpecial();
                        }
                    }
                }
            }
        }
        System.out.println("\n");
    }
}
