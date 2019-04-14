package Model;

public class Player
{
	private String name;		// The player's name
	private int playerNumber;	// The player's number

	public Player(String name, int playerNumber)
	{
		this.playerNumber = playerNumber;
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public int getPlayerNumber()
	{
		return playerNumber;
	}
}