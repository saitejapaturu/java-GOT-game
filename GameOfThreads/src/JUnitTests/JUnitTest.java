
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import Model.*;
import View.*;
import Controller.*;


public class JUnitTest {
	
	
	Board board;
	Square[][] grid;
	Square sq;
	int x,y;
	Piece piece;
	CornerSquare cS;
	
	@BeforeEach
	public void setUp() throws Exception
	{
		board = new Board(11,11);
		grid = board.getBoard();
		
		sq = new Square(x,y);
		cS = new CornerSquare(x, y);
		
		
	}
	
	// Square Class Tests
	
	@Test
	void occupiedTest() {
		sq.setOccupied(true);
		assertTrue(sq.getOccupied() == true);
	}
	
	
	@Test 
	void checkPos() {
		sq.setX(2);
		sq.setY(1);
		assertTrue(sq.getY() == 1 && sq.getX() == 2);
	}
	
	
	@Test
	void pieceTest() {
		sq.setPiece(piece);
		assertNotNull(sq.getPiece() == piece);
	}
	

	@Test // To check and see if the square is empty 
	void checkOccupied()
	{
		for (int i = 0; i < board.getHeight(); i++)
		{
			for (int j = 0; j < board.getWidth(); j++)
			{
				Square tempSq = board.getBoard()[j][i];
				assertTrue(tempSq.getOccupied() == false);
			}
		}
	}
	
	//Board Class Tests
	
	@Test
	void widthAndHeightTest() {
		
		assertTrue(board.getWidth() == 11 && board.getHeight() == 11);
	}
	
	@Test 
	void squareTest() {
		x = 2;
		y = 3;
		
		board.setSquare(x, y, sq);
		assertTrue(board.getSquare(x, y) != null );
		
	}
	
	@Test
	void squarePieceTest() {
		x = 2;
		y = 3;
		
		board.setSquarePiece(x, y, piece);
		assertTrue(board.getSquarePiece(x, y) != null);
	}
	
	//CornerSquare Test
	
	@Test
	void capturedTest() {
		cS.setCaptured(true, 1);
		assertTrue(cS.getCaptureStatus() == true && cS.getCapturedTeam() == 1);

	}
}
