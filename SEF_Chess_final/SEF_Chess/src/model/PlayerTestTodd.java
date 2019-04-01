package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlayerTestTodd {
	PlayerTestTodd playerTest;
	Player player = new Player("Player 1", "1","Black");
	public ArrayList<Player> test = new ArrayList<Player>();

	
	@Before
	public void setUp() throws Exception {
		test.add(player);
	}

	@After
	public void tearDown() throws Exception {
	}

	

	@Test
	public void testGetName() {
		assertEquals(player.getName(),"Player 1");
	}

	@Test
	public void testGetPlayerId() {
		assertEquals(player.getPlayerId(), "1");
	}

	@Test
	public void testGetGamesPlayed() {
		player.incrementGamesPlayed();
		player.incrementGamesPlayed();
		assertEquals(player.getGamesPlayed(),2);
	}

	@Test
	public void testIncrementGamesPlayed() {
		int i = player.getGamesPlayed();
		player.incrementGamesPlayed();
		int j = player.getGamesPlayed();
		assertFalse(i>j);
	}

	@Test
	public void testGetGamesWon() {
		player.incrementGamesWon();
		player.incrementGamesWon();
		assertEquals(player.getGamesWon(),2);
	}

	@Test
	public void testIncrementGamesWon() {
		int i = player.getGamesWon();
		player.incrementGamesWon();
		int j = player.getGamesWon();
		assertFalse(i>j);
	}


	@Test
	public void testAddPoints() {
		player.addPoints(5);
		assertEquals(player.getTotalPoints(),5);
	}

	@Test
	public void testGetTotalPoints() {
		player.addPoints(5);
		assertEquals(player.getTotalPoints(), 5);
	}

	@Test
	public void testGetAveragePoints() {
		player.addPoints(5);
		player.incrementGamesPlayed();
		player.incrementGamesPlayed();
		double ave = player.getAveragePoints();
		assertEquals(player.getAveragePoints(),2.5, 0.1);
	}

	@Test
	public void testGetWinPercentage() {
		player.incrementGamesPlayed();
		player.incrementGamesWon();
		assertEquals(player.getWinPercentage(),100);
	}
	
	@Test
	public void testGetScore() {
		player.changeScore(10);
		assertEquals(player.getScore(),10);
	}

	@Test
	public void testChangeScore() {
		player.changeScore(10);
		assertEquals(player.getScore(),10);
	}

	@Test
	public void testResetScore() {
		player.resetScore();
		assertEquals(player.getScore(),0);
	}

	

}
