package model;

public class Board {
	private Table[][] table = new Table[6][6];
	
	public static final String BLACK = "Black";
	public static final String WHITE = "White";

	public static final String KNIGHT = "Knight";
	public static final String BISHOP = "Bishop";
	public static final String ROOK = "Rook";
	
	private int selectedx;
	private int selectedy;
	private int nextx;
	private int nexty;
	// Added initializing pieces and placing them on the board - Jerald

	public void newBoard() {
		
		// Initialize Pieces - Jerald
		Pieces rookB = new Pieces(BLACK, ROOK);
		Pieces bishopB = new Pieces(BLACK, BISHOP);
		Pieces knightB = new Pieces(BLACK, KNIGHT);
				
		Pieces rookW = new Pieces(WHITE, ROOK);
		Pieces bishopW = new Pieces(WHITE, BISHOP);
		Pieces knightW = new Pieces(WHITE, KNIGHT);
				
		// Initialize Board
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table.length; j++) {
				this.table[i][j] = new Table(i, j);
			}
		}
		
		// Set Pieces on Board - Jerald
		for (int i = 0; i < table.length; i++) {
			if(i == 0 ) {
				for (int j = 0; j < table.length; j++) {
					if(j == 0 || j == 5) {
						table[i][j].setChessPiece(rookB);
					}
					else if(j == 1 || j == 4) {
						table[i][j].setChessPiece(bishopB);
					}
					else if(j == 2 || j == 3) {
						table[i][j].setChessPiece(knightB);
					}
				}
			}
			else if(i == 5) {
				for (int j = 0; j < table.length; j++) {
					if(j == 0 || j == 5) {
						table[i][j].setChessPiece(rookW);
					}
					else if(j == 1 || j == 4) {
						table[i][j].setChessPiece(bishopW);
					}
					else if(j == 2 || j == 3) {
						table[i][j].setChessPiece(knightW);
					}
				}
			}
		}
	}
	
	public void printBoard() {
		System.out.println("\n----------------------------------------------------");
		System.out.println("\n\t 0|\t 1|\t 2|\t 3|\t 4|\t 5|");
		System.out.println("\n====================================================");
		
		for(int i = 0; i < table.length; i++) {
			System.out.print("\n"+i+" |\t");
			
			for(int j = 0; j < table.length; j++) {
				
				Pieces check = table[i][j].getChessPiece();
				
				if(check == null) {
					System.out.print("  |\t");
				}
				else if(check.getType() == "Rook") {
					if(check.getColor() == "White") {
						System.out.print("R1|\t");
					}
					else {
						System.out.print("R2|\t");
					}
				}
				else if(check.getType() == "Bishop") {
					if(check.getColor() == "White") {
						System.out.print("B1|\t");
					}
					else {
						System.out.print("B2|\t");
					}
				}
				else if(check.getType() == "Knight") {
					if(check.getColor() == "White") {
						System.out.print("K1|\t");
					}
					else {
						System.out.print("K2|\t");
					}
				}
			}
			System.out.println("\n----------------------------------------------------");
		}
	}

	public Table returnTable(int x, int y) {
		return table[y][x];
	}
	
	public Table[][] getTable()
	{
		return table;
	}
	
	public int getSelectedx()
	{
		return this.selectedx;
	}
	
	public int getSelectedy()
	{
		controller.SquareActionListener.setSelecting(true);
		return this.selectedy;
	}
	
	public void setSelectedx(int x)
	{
		this.selectedx = x;
	}
	
	public void setSelctedy(int y)
	{
		this.selectedy = y;
		controller.SquareActionListener.setSelecting(false);
	}

}