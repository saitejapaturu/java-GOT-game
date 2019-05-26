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
		this.turn = 0;
		this.currentBoard = new ImmutableBoard(this.turn, this.currentGrid);

		//Initial BoardHistory
		Square[][] clone = currentGrid.clone();
		this.history = new BoardHistory(new ImmutableBoard(turn, clone));
		turn++;
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

		cloneBoard();
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

	private void cloneBoard()
	{
		Square[][] clone = currentGrid.clone();
		history.moveMade(new ImmutableBoard(turn, clone));
		turn++;
	}



}
