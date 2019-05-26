package Model;

import Controller.BoardHistory;

public class MutableBoard implements Board
{
	private BoardHistory history;
	private Square[][] currentGrid;
	private ImmutableBoard currentBoard;
	private int turn;

	public MutableBoard()
	{
		this.currentGrid = new Square[SIZE][SIZE];
		initialiseGrid();
		this.turn = 0;
		this.currentBoard = new ImmutableBoard(this.turn, this.currentGrid);

		//Initial BoardHistory
//		Square[][] clone = currentGrid.clone();
//		this.history = new BoardHistory(new ImmutableBoard(turn, clone));
//		turn++;
		addToHistory();
	}

	// Sets up the pre destined squares and pieces
	private void initialiseGrid()
	{
		System.out.println("Initialising board");

		initialiseSquares();
		initialiseGridPieces();
	}

	// Sets up the pre destined squares
	private void initialiseSquares()
	{
		int max=10, mid=5, min=0;

		//Initialising corner squares;
		this.currentGrid[max][mid] = new CornerSquare(max, mid);    // Corner Square 10,5
		this.currentGrid[min][mid] = new CornerSquare(min, mid);    // Corner Square 0,5
		this.currentGrid[mid][min] = new CornerSquare(mid, min);    // Corner Square 5,0
		this.currentGrid[mid][max] = new CornerSquare(mid, max);    // Corner Square 5,10

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
					this.currentGrid[upperRow+1][i] = new Square((upperRow+1), i, true);
				}

				this.currentGrid[upperRow][i] = new Square(upperRow, i, true);
				this.currentGrid[lowerRow][i] = new Square(lowerRow, i, true);
			}
		}
	}

	// Sets up the pre destined pieces
	private void initialiseGridPieces()
	{
		//Placing Player 1 pieces
		this.currentGrid[0][5].setPiece(new DaenerysTargaryen());
		this.currentGrid[1][4].setPiece(new AryaStark());
		this.currentGrid[1][5].setPiece(new JonSnow());
		this.currentGrid[1][6].setPiece(new Unsullied());

		//Placing player 2 pieces
		this.currentGrid[10][5].setPiece(new NightKing());
		this.currentGrid[9][4].setPiece(new Giant());
		this.currentGrid[9][5].setPiece(new General());
		this.currentGrid[9][6].setPiece(new Horde());

		//Player 1 and 2 already occupy 1 corner square

		((CornerSquare)this.currentGrid[0][5]).capture(1);
		((CornerSquare)this.currentGrid[10][5]).capture(2);
	}

	public int getSize()
	{
		return this.SIZE;
	}

	public Square getSquare(int x, int y)
	{
		return this.currentBoard.getSquare(x, y);
	}

	public int checkWinConditions()
	{
		return this.currentBoard.checkWinConditions();
	}

	public void activateSpecial(int specialTurn)
	{
		this.currentBoard.activateSpecial(specialTurn);
	}

	public void deactivateSpecial()
	{
		this.currentBoard.deactivateSpecial();
	}

	public boolean movePiece (int currentX, int currentY, int newX, int newY)
	{
		boolean canMove = this.currentBoard.movePiece(currentX, currentY, newX, newY);

		if(canMove)
		{
			gridChanged();
		}

		return canMove;
	}

	public boolean attackPiece (int currentX, int currentY, int newX, int newY)
	{
		boolean canAttack = this.currentBoard.attackPiece(currentX, currentY, newX, newY);

		if(canAttack)
		{
			gridChanged();
		}

		return canAttack;
	}

	public void gridChanged()
	{
		currentGrid = this.currentBoard.getGrid();

		addToHistory();
	}

	public boolean undo()
	{
		ImmutableBoard undoBoard = this.history.undo();

		if(undoBoard == null)
		{
			return false;
		}
		else
		{
			turn--;
			this.currentGrid = undoBoard.getGrid();
			this.currentBoard = new ImmutableBoard(this.turn, this.currentGrid);
			return true;
		}
	}

	public boolean redo()
	{
		ImmutableBoard redoBoard = this.history.redo();

		if(redoBoard == null)
		{
			return false;
		}
		else
		{
			turn++;
			this.currentGrid = redoBoard.getGrid();
			this.currentBoard = new ImmutableBoard(this.turn, this.currentGrid);
			return true;
		}
	}

	private void addToHistory()
	{
		Square[][] gridClone = currentGrid.clone();

		// If initialising
		if(this.turn == 0)
		{
			this.history = new BoardHistory(new ImmutableBoard(this.turn, gridClone));
		}
		else
		{
			this.history.moveMade(new ImmutableBoard(this.turn, gridClone));
		}
		turn++;
	}



}
