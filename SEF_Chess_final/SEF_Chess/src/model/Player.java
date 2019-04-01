package model;

import java.util.ArrayList;

public class Player {
	
	private String name;
	private String playerID;
	private int gamesPlayed;
	private int gamesWon;
	private int pointsTotal;
	private int score;
	private String color;		// Added String color to compare to color of pieces - Jerald
	private ArrayList<Player> players = new ArrayList<Player>();
	
	//playername, id and color to be created at runtime, id can be labelled as "nickname" with max of three chars
	public Player(String name, String playerID, String color) {
	    this.name = name;
	    this.playerID = playerID;
	    this.gamesPlayed =0;
	    this.gamesWon = 0;
	    this.score =0;
	    this.color = color;
	    players.add(this);
	}
	
	public String getName() 
	{
		return this.name;
	}
	
	public String getPlayerId()
	{
		return this.playerID;
	}
	
	public int getGamesPlayed()
	{
		return this.gamesPlayed;
	}
	
	public String getPlayerColor()
	{
		return this.color;
	}
	
	public void incrementGamesPlayed()
	{
		this.gamesPlayed++;
	}
	
	public int getGamesWon()
	{
		return this.gamesWon;
	}
	
	public void incrementGamesWon()
	{
		this.gamesWon++;
	}
	//returns whole array list of players
	public ArrayList<Player> getPlayers()
	{
		return players;
	}
	
	public void addPoints(int points)
	{
		this.pointsTotal += points;
	}
	
	//returns total points gathered across all games
	public int getTotalPoints()
	{
		return this.pointsTotal;
	}
	
	//returns average points across games as float
	public float getAveragePoints()
	{
		return (float) (this.pointsTotal*100.0f)/this.gamesPlayed;
	}
	//returns winPercentage of total games as int
	public int getWinPercentage()
	{
		return (int) (this.gamesWon/this.gamesPlayed)*100;
	}
	
	public void changeScore(int points)
	{
		this.score += points;
	}
	
	public void resetScore()
	{
		this.score =0;
	}
	
	public int getScore()
	{
		return this.score;
	}
}
