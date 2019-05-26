package Model;

public class MutableBoard implements Board
{

	@Override
	public int getWidth()
	{
		return 0;
	}

	@Override
	public Square getSquare(int x, int y)
	{
		return null;
	}

	@Override
	public Piece getSquarePiece(int x, int y)
	{
		return null;
	}

	@Override
	public void setSquarePiece(int x, int y, Piece piece)
	{

	}

	@Override
	public boolean attackPiece(int currentX, int currentY, int newX, int newY)
	{
		return false;
	}

	@Override
	public boolean movePiece(int currentX, int currentY, int newX, int newY)
	{
		return false;
	}

	@Override
	public int checkWinConditions()
	{
		return 0;
	}

	@Override
	public void activateSpecial(int specialTurn)
	{

	}

	@Override
	public void deactivateSpecial()
	{

	}

}
