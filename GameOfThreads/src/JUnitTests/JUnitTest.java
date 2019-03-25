
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

//Corrected imports
import Model.*;
import View.*;
import Controller.*;


public class JUnitTest {
	
	
	Board board;
	Square[][] grid;
	
	@BeforeEach
	public void setUp() throws Exception
	{
		board = new Board();
		grid = board.getBoard();
		
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
	
	@Test // To check the position of the occupied squares
	void checkOccupiedPos()
	{
		for (int i = 0; i < board.getHeight(); i++)
		{
			for (int j = 0; j < board.getWidth(); j++)
			{
				Square tempSq = board.getBoard()[j][i];
				assertTrue(tempSq.getX() >= 0 && tempSq.getY() >= 0);
			}
		}
	}
}
