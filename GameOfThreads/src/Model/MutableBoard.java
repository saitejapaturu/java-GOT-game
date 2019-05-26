package Model;

public class MutableBoard implements Board
{

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Square getSquare(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Piece getSquarePiece(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSquarePiece(int x, int y, Piece piece) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean attackPiece(int currentX, int currentY, int newX, int newY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean movePiece(int currentX, int currentY, int newX, int newY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int checkWinConditions() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void activateSpecial(int specialTurn) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deactivateSpecial() {
		// TODO Auto-generated method stub

	}

}
