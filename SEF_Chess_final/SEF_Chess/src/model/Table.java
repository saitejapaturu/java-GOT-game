package model;

public class Table {
	private int x;
	private int y;
	Pieces chessPiece;

	public Table(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		chessPiece = null;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Pieces getChessPiece() {
		return chessPiece;
	}

	public void setChessPiece(Pieces chessPiece) {
		this.chessPiece = chessPiece;
	}

}
