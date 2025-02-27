//
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.ArrayList;
//
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.Test;
//import Model.*;
//import View.*;
//import Controller.*;
//
//
//public class JUnitTest {
//
//
//	Board board;
//	Square[][] grid;
//	Square sq;
//	int x,y;
//	Piece piece,mg,sc,sld,sup,tank,as;
//	CornerSquare cS;
//	ArrayList<Piece>pieceL;
//
//	@BeforeEach
//	public void setUp() throws Exception
//	{
//		board = new Board();
//		grid = board.getBoard();
//
//		sq = new Square(2,1, true);
//		cS = new CornerSquare(x, y);
//
//		mg = new Horde("1", x,y);
//		sc = new Horde("1", x,y);
//		sld = new Horde("1", x,y);
//		sup = new Horde("1", x,y);
//		tank = new Horde("1", x,y);
//		as = new Horde("1", x,y);
//
//	}
//
//	// Square Class Tests
//
//	@Test
//	void occupiedTest() {
//		sq.setOccupied(true);
//		assertTrue(sq.getOccupied() == true);
//	}
//
//
//	@Test
//	void checkPos() {
//
//		assertTrue(sq.getY() == 1 && sq.getX() == 2);
//	}
//
//
//	@Test
//	void pieceTest() {
//		sq.setPiece(piece);
//		assertNotNull(sq.getPiece() == piece);
//	}
//
//	@Test
//	void placebleTest() {
//		assertTrue(sq.getIsPlacebale());
//
//	}
//
//	@Test
//	void cornerTest() {
//		sq.setIsCorner(true);
//		assertTrue(sq.getIsCorner());
//	}
//
//	//Board Class Tests
//
//	@Test
//	void widthAndHeightTest() {
//
//		assertTrue(board.getWidth() == 11 && board.getHeight() == 11);
//	}
//
//	@Test
//	void squareTest() {
//		x = 2;
//		y = 3;
//
//		board.setSquare(x, y, sq);
//		assertTrue(board.getSquare(x, y) != null );
//
//	}
//
//	@Test
//	void squarePieceTest() {
//		x = 2;
//		y = 3;
//
//		board.setSquarePiece(x, y, null);
//		assertTrue(board.getSquarePiece(x, y) == null);
//	}
//
//	@Test
//	void validateMoveTest() {
//		x = 2;
//		y = 3;
//
//		board.validateMove(x, y);
//		assertTrue(board.getSquare(x, y).getIsPlacebale() == true);
//	}
//	//CornerSquare Test
//
//	@Test
//	void capturedTest() {
//		cS.setCaptured(true, 1);
//		assertTrue(cS.getCaptureStatus() == true && cS.getCapturedTeam() == 1);
//
//	}
//
//	//Piece Test
//
//
//	@Test
//	void checkPieces() {
//		pieceL.add(mg);
//		pieceL.add(sc);
//		pieceL.add(sld);
//		pieceL.add(sup);
//		pieceL.add(tank);
//		pieceL.add(as);
//
//		for(int i =0; i < pieceL.size(); i++) {
//
//			assertTrue(pieceL.get(i) instanceof Piece);
//
//		}
//	}
//
//	@Test
//	void countP() {
//		pieceL.add(mg);
//		pieceL.add(sc);
//		pieceL.add(sld);
//		pieceL.add(sup);
//		pieceL.add(tank);
//		pieceL.add(as);
//		int count = 0;
//
//		for(int i =0; i < pieceL.size(); i++) {
//
//			if (pieceL.get(i) instanceof Piece)
//			{
//				count++;
//			}
//
//		}
//		assertEquals(6, count);
//	}
//
//	//to Test an individual extended class of piece
//
//	@Test
//	void positionTest() {
//		x = 2;
//		y = 3;
//
//		mg.setX(x);
//		mg.setY(y);
//
//		assertNotNull(mg.getX() == x && mg.getY() == y);
//
//	}
//
//	@Test
//	void moveTest() {
//		x = 2;
//		y = 3;
//
//		int newX = 4;
//		int newY = 5;
//
//		mg.move(newX, newY);
//		assertTrue(mg.getX() == newX && mg.getY() == newY);
//
//
//	}
//
//	@Test
//	void healthTest() {
//		x = 2;
//		y = 3;
//
//		mg.setHealth(30);
//		assertTrue(mg.getHealth() == 30);
//
//	}
//
//
//	@Test
//	void damageTest() {
//		x = 2;
//		y = 3;
//
//		mg.setHealth(30);
//		mg.takeDamage(2);
//		assertTrue(mg.getHealth() == 28);
//		assertNotNull(mg.getDamage() == 2);
//
//	}
//}
