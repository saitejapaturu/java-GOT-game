package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BoardTestTodd {
	Board board = new Board();
	
	public static final String BLACK = "Black";
	public static final String WHITE = "White";

	public static final String KNIGHT = "Knight";
	public static final String BISHOP = "Bishop";
	public static final String ROOK = "Rook";
	
	Pieces rookB = new Pieces(BLACK, ROOK);
	Pieces bishopB = new Pieces(BLACK, BISHOP);
	Pieces knightB = new Pieces(BLACK, KNIGHT);
			
	Pieces rookW = new Pieces(WHITE, ROOK);
	Pieces bishopW = new Pieces(WHITE, BISHOP);
	Pieces knightW = new Pieces(WHITE, KNIGHT);
				
	@Before
	public void setUp() throws Exception {
		board.newBoard();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNewBoard() {
		assertTrue(board.returnTable(0, 0).getChessPiece().getType()== ROOK);
		assertTrue(board.returnTable(0, 0).getChessPiece().getColor()== BLACK);
		assertTrue(board.returnTable(0, 1).getChessPiece().getType()== BISHOP);
		assertTrue(board.returnTable(0, 1).getChessPiece().getColor()== BLACK);
		assertTrue(board.returnTable(0, 2).getChessPiece().getType()== KNIGHT);
		assertTrue(board.returnTable(0, 2).getChessPiece().getColor()== BLACK);
		assertTrue(board.returnTable(0, 5).getChessPiece().getType()== ROOK);
		assertTrue(board.returnTable(0, 5).getChessPiece().getColor()== BLACK);
		assertTrue(board.returnTable(0, 4).getChessPiece().getType()== BISHOP);
		assertTrue(board.returnTable(0, 4).getChessPiece().getColor()== BLACK);
		assertTrue(board.returnTable(0, 3).getChessPiece().getType()== KNIGHT);
		assertTrue(board.returnTable(0, 3).getChessPiece().getColor()== BLACK);
		
		assertTrue(board.returnTable(5, 0).getChessPiece().getType()== ROOK);
		assertTrue(board.returnTable(5, 0).getChessPiece().getColor()== WHITE);
		assertTrue(board.returnTable(5, 1).getChessPiece().getType()== BISHOP);
		assertTrue(board.returnTable(5, 1).getChessPiece().getColor()== WHITE);
		assertTrue(board.returnTable(5, 2).getChessPiece().getType()== KNIGHT);
		assertTrue(board.returnTable(5, 2).getChessPiece().getColor()== WHITE);
		assertTrue(board.returnTable(5, 5).getChessPiece().getType()== ROOK);
		assertTrue(board.returnTable(5, 5).getChessPiece().getColor()== WHITE);
		assertTrue(board.returnTable(5, 4).getChessPiece().getType()== BISHOP);
		assertTrue(board.returnTable(5, 4).getChessPiece().getColor()== WHITE);
		assertTrue(board.returnTable(5, 3).getChessPiece().getType()== KNIGHT);
		assertTrue(board.returnTable(5, 3).getChessPiece().getColor()== WHITE);
		
		
	}

	@Test
	public void testMovePiece() {
		//co-ords a switched as they are switched when the player enters them due to how 
		//they are read.
//		board.movePiece(0, 0, 0, 1);
		assertTrue(board.returnTable(1,0).getChessPiece().getType() == ROOK);
	}

}
